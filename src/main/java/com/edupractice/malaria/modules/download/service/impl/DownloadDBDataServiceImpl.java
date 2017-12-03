package com.edupractice.malaria.modules.download.service.impl;

import com.edupractice.malaria.modules.common.pojo.Indicator;
import com.edupractice.malaria.modules.download.dao.CategoryFieldsMapper;
import com.edupractice.malaria.modules.download.dao.IndicatorByFieldsMapper;
import com.edupractice.malaria.modules.download.pojo.CategoryFieldsRe;
import com.edupractice.malaria.modules.download.pojo.DownloadParamVo;
import com.edupractice.malaria.modules.download.pojo.SQLQuery;
import com.edupractice.malaria.modules.download.service.DownloadDBDataService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class DownloadDBDataServiceImpl implements DownloadDBDataService {

    @Resource
    private CategoryFieldsMapper categoryFieldsMapper;
    @Resource
    private IndicatorByFieldsMapper indicatorByFieldsMapper;

    /**
     * 根据数据类别获取展示的字段
     *
     * @param category
     * @return
     * @throws Exception
     */
    public List<CategoryFieldsRe> getFieldsNameDownload(String category) throws Exception {
        return categoryFieldsMapper.selectCategoryFields(category);
    }

    /**
     * 根据用户提交的筛选及选择的字段名来下载数据
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    public HSSFWorkbook downloadData(DownloadParamVo downloadParamVo) throws Exception {
        List<Map<String, Object>> totalData = new ArrayList<>();
        List<String> selectedFields = downloadParamVo.getSelectedName();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        if ("Disease".equals(downloadParamVo.getCategory().trim())) {
            totalData = getDiseaseIndicators(downloadParamVo);
        } else if ("Weather".equals(downloadParamVo.getCategory().trim())) {
            totalData = getWeatherIndicators(downloadParamVo);
        } else if ("Station".equals(downloadParamVo.getCategory().trim())) {
            totalData = getStationIndicators(downloadParamVo);
        }
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("下载数据");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCells[] = new HSSFCell[selectedFields.size()];
        //第一行，设置字段名
        for (int i = 0; i < selectedFields.size(); i++) {
            hssfCells[i] = hssfRow.createCell(i);
            hssfCells[i].setCellValue(selectedFields.get(i));
        }
        //第二行开始，设置每一行的数据
        for (int i = 0, rowNum = 1; i < totalData.size(); i++, rowNum++) {
            HSSFRow currentRow = hssfSheet.createRow(rowNum);
            HSSFCell cells[] = new HSSFCell[selectedFields.size()];
            Map<String, Object> currentData = totalData.get(i);
            //根据字段名来获取数据，并设置数据
            for (int cellNum = 0; cellNum < selectedFields.size(); cellNum++) {
                String currentKey = selectedFields.get(cellNum);
                cells[cellNum] = currentRow.createCell(cellNum);
                //单元格数据为空时，设置为“ ”
                if (null == currentData.get(currentKey)) {
                    cells[cellNum].setCellValue(" ");
                    continue;
                }
                cells[cellNum].setCellValue(currentData.get(currentKey).toString());
            }
        }
        return hssfWorkbook;
    }

    /**
     * 疟疾数据
     * 获取mysql中选择好的字段及筛选字段的数据
     * 同时可以做展示数据用
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    private List<Map<String, Object>> getDiseaseIndicators(DownloadParamVo downloadParamVo) throws Exception {
        List<String> selectedDisplayFields = downloadParamVo.getSelectedName();
        List<Indicator> indicators = indicatorByFieldsMapper.selectIndicatorByFields(selectedDisplayFields);
        List<Indicator> diseaseIndicators = indicatorByFieldsMapper.selectIndicatorOfDisease();
        Set<String> selectFieldSet = new HashSet<>();
        Set<String> fromTableSet = new HashSet<>();
        Set<String> tableSet = new HashSet<>();
        Set<String> whereSet = new HashSet<>();
        for (Indicator diseaseIndicator : diseaseIndicators
                ) {
            tableSet.add(diseaseIndicator.getBelongTable());
            fromTableSet.add(" " + diseaseIndicator.getBelongTable() +"  "+ "AS"+"  "+ diseaseIndicator.getTableAlias());
            selectFieldSet.add(" " + diseaseIndicator.getTableAlias() + "." + diseaseIndicator.getFieldName() + " AS '" + diseaseIndicator.getDisplayName() + "'");
        }
        //多表连接条件
        whereSet.add(" AND cd.patient_id = " + "pi.patient_id" +
                " AND cd.patient_id = " + "pi.patient_id" +
                " AND cd.disease_id = " + "di.disease_id" +
                " AND cd.category_id1 = " + "cc1.category_id1" +
                " AND cd.category_id2 = " + "cc2.category_id2" +
                " AND cd.fill_card_doc_id = " + "do.doctor_id" +
                " AND cd.report_unit_id = " + "mu.medical_unit_id" +
                " AND cd.input_user_id = " + "do.doctor_id" +
                " AND cd.revised_user_id = " + "do.doctor_id" +
                " AND cd.del_user_id = " + "do.doctor_id" +
                " AND pi.address_id = " + "ag.address_id" +
                " AND pi.career_id = " + "ca.career_id" +
                " AND pi.belongs_id = " + "pb.belongs_id");

        //筛选条件
        if (tableSet.contains("patient") && tableSet.contains("card")) {
            //时间区间
            if ((0 != downloadParamVo.getBeginYear() && 0 != downloadParamVo.getEndYear() && (downloadParamVo.getBeginYear() <= downloadParamVo.getEndYear()))) {
                whereSet.add("AND cd.year BETWEEN " + downloadParamVo.getBeginYear() + " AND " + downloadParamVo.getEndYear());
            }
            //性别   0表示全部性别 1表示男 2表示女
            if (0 != downloadParamVo.getSex()) {
                if (1 == downloadParamVo.getSex()) {
                    whereSet.add(" AND pi.sex = '男' ");
                } else if (2 == downloadParamVo.getSex()) {
                    whereSet.add(" AND pi.sex = '女' ");
                }
            }

            //年龄
            if (0 != downloadParamVo.getMinAge() && 0 != downloadParamVo.getMaxAge() && downloadParamVo.getMinAge() <= downloadParamVo.getMaxAge()) {
                whereSet.add(" AND (cd.year-YEAR(pi.birthday)+1) BETWEEN " + downloadParamVo.getMinAge() + " AND " + downloadParamVo.getMaxAge());
            }
            //地区 (应该区分为四级 省、市、镇、村)
            if (null != downloadParamVo.getAddrLevel1()) {
                whereSet.add(" AND (ag.address LIKE '%" + downloadParamVo.getAddrLevel1() + "%')");
                if (null != downloadParamVo.getAddrLevel2()) {
                    whereSet.add(" AND (ag.address LIKE '%" + downloadParamVo.getAddrLevel2() + "%')");
                    if (null != downloadParamVo.getAddrLevel3()) {
                        whereSet.add(" AND (ag.address LIKE '%" + downloadParamVo.getAddrLevel3() + "%')");
                        if (null != downloadParamVo.getAddrLevel4()) {
                            whereSet.add(" AND (ag.address LIKE '%" + downloadParamVo.getAddrLevel4() + "%')");
                        }
                    }
                }
            }
        }

        StringBuilder selectBuilder = new StringBuilder();
        for (Iterator<String> it = selectFieldSet.iterator(); it.hasNext(); ) {
            selectBuilder.append(it.next());
            if (it.hasNext()) {
                selectBuilder.append(",");
            }
        }

        StringBuilder fromBuilder = new StringBuilder();
        for (Iterator<String> it = fromTableSet.iterator(); it.hasNext(); ) {
            fromBuilder.append(it.next());
            if (it.hasNext()) {
                fromBuilder.append(",");
            }
        }

        StringBuilder whereBuilder = new StringBuilder();
        for (Iterator<String> it = whereSet.iterator(); it.hasNext(); ) {
            whereBuilder.append(it.next());
            if (it.hasNext()) {
                whereBuilder.append(" ");
            }
        }


        SQLQuery sqlQuery = new SQLQuery();
        sqlQuery.setSelect(selectBuilder.toString());
        sqlQuery.setFrom(fromBuilder.toString());
        sqlQuery.setWhere(whereBuilder.toString());
        List<Map<String, Object>> resultMapList = indicatorByFieldsMapper.selectData(sqlQuery);
        return resultMapList;
    }

    /**
     * 气候数据
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    private List<Map<String, Object>> getWeatherIndicators(DownloadParamVo downloadParamVo) {
        return new ArrayList<>();
    }


    /**
     * 观测站信息
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    private List<Map<String, Object>> getStationIndicators(DownloadParamVo downloadParamVo) {
        return new ArrayList<>();
    }


}
