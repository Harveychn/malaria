package com.edupractice.malaria.modules.download.service.impl;

import com.edupractice.malaria.modules.download.dao.CategoryFieldsMapper;
import com.edupractice.malaria.modules.download.dao.IndicatorByFieldsMapper;
import com.edupractice.malaria.modules.download.pojo.CategoryFieldsRe;
import com.edupractice.malaria.modules.download.pojo.DownloadParamVo;
import com.edupractice.malaria.modules.download.service.DownloadDBDataService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private List<Map<String, Object>> getDiseaseIndicators(DownloadParamVo downloadParamVo) {

        return new ArrayList<>();
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
