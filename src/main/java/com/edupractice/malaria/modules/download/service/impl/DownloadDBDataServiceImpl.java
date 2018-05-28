package com.edupractice.malaria.modules.download.service.impl;

import com.edupractice.malaria.modules.common.pojo.Indicator;
import com.edupractice.malaria.modules.common.pojo.WeatherData;
import com.edupractice.malaria.modules.download.dao.CategoryFieldsMapper;
import com.edupractice.malaria.modules.download.dao.IndicatorByFieldsMapper;
import com.edupractice.malaria.modules.download.pojo.CategoryFieldsRe;
import com.edupractice.malaria.modules.download.pojo.DownloadParamVo;
import com.edupractice.malaria.modules.download.pojo.SQLQuery;
import com.edupractice.malaria.modules.download.service.DownloadDBDataService;
import org.apache.poi.hssf.usermodel.*;
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
        //创建excel工作簿
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        if (downloadParamVo.getCategory().trim().equals("Disease")) {
            totalData = getDiseaseIndicators(downloadParamVo);
        } else if (downloadParamVo.getCategory().trim().equals("Weather")) {
            totalData = getWeatherIndicators(downloadParamVo);
        } else if (downloadParamVo.getCategory().trim().equals("Station")) {
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
                //单元格数据为空或为"."时，设置为" "0
                if (null == currentData.get(currentKey) || currentData.get(currentKey).equals(".")) {
                    cells[cellNum].setCellValue(" ");
                    continue;
                } else if (currentData.get(currentKey).equals("0") && currentKey.equals("卡片状态")) {
                    cells[cellNum].setCellValue("原始卡");
                    continue;
                } else if (currentData.get(currentKey).equals("1") && currentKey.equals("卡片状态")) {
                    cells[cellNum].setCellValue("订正卡");
                    continue;
                } else if (currentData.get(currentKey).equals("0") && currentKey.equals("审核状态")) {
                    cells[cellNum].setCellValue("未审核卡");
                    continue;
                } else if (currentData.get(currentKey).equals("1") && currentKey.equals("审核状态")) {
                    cells[cellNum].setCellValue("已审核卡");
                    continue;
                }
                cells[cellNum].setCellValue(currentData.get(currentKey).toString());
            }
        }
        return hssfWorkbook;
    }

    /**
     * 设置单元格格式
     */
    private void setStyle(String string) {

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
        for (Indicator diseaseIndicator : diseaseIndicators) {

            tableSet.add(diseaseIndicator.getBelongTable());
            fromTableSet.add(" " + diseaseIndicator.getBelongTable() + "  " + "AS" + "  " + diseaseIndicator.getTableAlias());
            selectFieldSet.add(" " + diseaseIndicator.getTableAlias() + "." + diseaseIndicator.getFieldName() + " AS '" + diseaseIndicator.getDisplayName() + "'");
        }
        //多表连接条件
        whereSet.add(" AND cd.patient_id = " + "pi.patient_id" +
                " AND cd.disease_id = " + "di.disease_id" +
                " AND cd.category_id1 = " + "cc1.category_id1" +
                " AND cd.category_id2 = " + "cc2.category_id2" +
                " AND cd.fill_card_doc_id = " + "do.doctor_id" +
                " AND cd.report_unit_id = " + "mu.medical_unit_id" +
                " AND cd.input_user_id = " + "do1.doctor_id" +
                " AND cd.revised_user_id = " + "do2.doctor_id" +
                " AND cd.del_user_id = " + "do3.doctor_id" +
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
    private List<Map<String, Object>> getWeatherIndicators(DownloadParamVo downloadParamVo) throws Exception {
        List<String> selectedDisplayFields = downloadParamVo.getSelectedName();
        List<Indicator> indicators = indicatorByFieldsMapper.selectIndicatorByFields(selectedDisplayFields);
        Set<String> selectFieldSet = new HashSet<>();
        Set<String> fromTableSet = new HashSet<>();
        Set<String> tableSet = new HashSet<>();
        Set<String> whereSet = new HashSet<>();
        fromTableSet.add(" " + "weather_data" + "  " + "AS" + "  " + "wd");
        fromTableSet.add(" " + "meteorological_station" + "  " + "AS" + "  " + "ms");
        for (Indicator indicator : indicators
                ) {

            selectFieldSet.add(" " + indicator.getTableAlias() + "." + indicator.getFieldName() + " AS '" + indicator.getDisplayName() + "'");
        }

        //多表连接条件
        whereSet.add(" AND wd.station_id = ms.station_id");

        //筛选条件
        if (0 != downloadParamVo.getBeginYear() && 0 != downloadParamVo.getEndYear() && downloadParamVo.getBeginYear() <= downloadParamVo.getEndYear()) {
            whereSet.add(" AND wd.weather_year BETWEEN " + downloadParamVo.getBeginYear() + " AND " + downloadParamVo.getEndYear());
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
     * 观测站信息
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    private List<Map<String, Object>> getStationIndicators(DownloadParamVo downloadParamVo) throws Exception {
        List<String> selectedDisplayFields = downloadParamVo.getSelectedName();
        List<Indicator> indicators = indicatorByFieldsMapper.selectIndicatorByFields(selectedDisplayFields);
        SQLQuery sqlQuery = new SQLQuery();
        sqlQuery.setSelect(toString(indicators));
        sqlQuery.setFrom("meteorological_station");
        sqlQuery.setWhere("");
        List<Map<String, Object>> resultMapList = indicatorByFieldsMapper.selectData(sqlQuery);
        return resultMapList;
    }

    public String toString(List<Indicator> strings) {
        String returnString = "";
        for (Indicator string : strings
                ) {
            returnString += (string.getFieldName() + " AS " + string.getDisplayName() + ",");
        }
        return returnString.substring(0, returnString.length() - 1);
    }


}
