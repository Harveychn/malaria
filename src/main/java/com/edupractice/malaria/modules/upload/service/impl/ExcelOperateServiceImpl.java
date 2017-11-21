package com.edupractice.malaria.modules.upload.service.impl;

import com.edupractice.malaria.modules.common.pojo.MeteorologicalStation;
import com.edupractice.malaria.modules.common.pojo.WeatherData;
import com.edupractice.malaria.modules.upload.pojo.*;
import com.edupractice.malaria.modules.upload.service.ExcelOperateService;
import com.edupractice.malaria.modules.upload.service.UploadToCardInfoService;
import com.edupractice.malaria.modules.upload.service.UploadToStationInfoService;
import com.edupractice.malaria.modules.upload.service.UploadToWeatherInfoService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ExcelOperateServiceImpl implements ExcelOperateService {
    @Resource
    private UploadToStationInfoService uploadToStationInfoService;
    @Resource
    private UploadToWeatherInfoService uploadToWeatherInfoService;
    @Resource
    private UploadToCardInfoService uploadToCardInfoService;

    public Data2DBInfo ExcelOperateSave(String filePath) throws Exception {
        String fileName=filePath.substring(filePath.lastIndexOf("-") + 1, filePath.lastIndexOf("."));

        List<Integer> errorRowsCode = new ArrayList<>();
        List<Integer> savedRowsCode = new ArrayList<>();
        //文件流数据
        InputStream fileStream = new FileInputStream(filePath);
        //获取excel单元格数值
        GetExcelValue getExcelValue = new GetExcelValue();
        //excel低版本
        if (filePath.endsWith(".xls")) {
            //创建工作簿
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileStream);
            //遍历sheet表
            for (int sheetNum = 0; sheetNum < hssfWorkbook.getNumberOfSheets(); sheetNum++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNum);
                if (null == hssfSheet) {
                    continue;
                }
                //获取第一行字段名
                HSSFRow firstRow = hssfSheet.getRow(0);
                //列数
                int finalCellNum = firstRow.getLastCellNum();
                List<String> fieldNames = new ArrayList<>();
                for (int cellNum = 0; cellNum < finalCellNum; cellNum++) {
                    fieldNames.add(cellNum, getExcelValue.getValue(firstRow.getCell(cellNum)));
                }
                //遍历行，此处从第二行开始，第一行为字段名
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    Map<String, String> cellValues = new HashMap<>();
                    for (int cellNum = 0; cellNum < finalCellNum; cellNum++) {
                        cellValues.put(fieldNames.get(cellNum), getExcelValue.getValue(hssfRow.getCell(cellNum)));
                    }

                    //根据字段判断上传的文件，同时上传数据到数据库
                    if (switchTable(fieldNames, cellValues, rowNum,fileName)) {
                        savedRowsCode.add(rowNum);
                    } else {
                        errorRowsCode.add(rowNum);
                    }
                }
            }
        }
        //excel高版本
        if (filePath.endsWith(".xlsx")) {
            //创建工作簿
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileStream);
            //遍历sheet表
            for (int sheetNum = 0; sheetNum < xssfWorkbook.getNumberOfSheets(); sheetNum++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetNum);
                if (null == xssfSheet) {
                    continue;
                }
                //获取第一行字段名
                XSSFRow firstRow = xssfSheet.getRow(0);
                //列数
                int finalCellNum = firstRow.getLastCellNum();
                List<String> fieldNames = new ArrayList<>();
                for (int cellNum = 0; cellNum < finalCellNum; cellNum++) {
                    fieldNames.add(cellNum, getExcelValue.getValue(firstRow.getCell(cellNum)));
                }
                //遍历行，此处从第二行开始，第一行为字段名
                //List<实体类> 保存待存数据 = new ArrayList<>()；
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    Map<String, String> cellValues = new HashMap<>();
                    for (int cellNum = 0; cellNum < finalCellNum; cellNum++) {
                        cellValues.put(fieldNames.get(cellNum), getExcelValue.getValue(xssfRow.getCell(cellNum)));
                    }
                    //根据字段判断上传的文件，同时上传数据到数据库
                    if (switchTable(fieldNames, cellValues, rowNum,fileName)) {
                        savedRowsCode.add(rowNum);
                    } else {
                        errorRowsCode.add(rowNum);
                    }
                }
            }
        }
        Data2DBInfo data2DBInfo = new Data2DBInfo();
        data2DBInfo.setErrorRowsCode(errorRowsCode);
        data2DBInfo.setSavedRowsTotal(savedRowsCode.size());
        return data2DBInfo;
    }
    /**
     * 上传数据到数据库，记录行数据正确保存、错误的行数到全局变量
     *
     * @param fieldNames
     * @param cellValues
     * @param rowNum
     * @throws Exception
     */
    private Boolean switchTable(List<String> fieldNames, Map<String, String> cellValues, int rowNum,String fileName) throws Exception {
        Boolean flag = null;
        switch (fieldNames.size()) {
            //气候站表
            case 11:
                RowDataSorted<MeteorologicalStation, ErrorStationInfo> rowDataSorted1 = null;
                rowDataSorted1 = uploadToStationInfoService.MeteorologicalStationCellData(cellValues);
                if (rowDataSorted1.getHasError()) {//行数据有错
//                    this.errorRowsCode.add(rowNum);
                    flag = false;
                } else {//行数据没有错误
                    Upload2DBInfo upload2DBInfo = uploadToStationInfoService.saveDataToStationDB(rowDataSorted1.getCorrectData());
                    if (upload2DBInfo.isSuccessOp()) {
                        //记录成功插入第几行的数据
//                        this.savedRowsCode.add(rowNum);
                        flag = true;
                    }
                }
                break;
            //气候信息表
            case 20: RowDataSorted<WeatherData, ErrorWeatherInfo> rowDataSorted2 = null;
                rowDataSorted2 = uploadToWeatherInfoService.WeatherDateCellData(cellValues);
                if (rowDataSorted2.getHasError()) {//行数据有错
//                    this.errorRowsCode.add(rowNum);
                    flag = false;
                } else {//行数据没有错误
                    Upload2DBInfo upload2DBInfo = uploadToWeatherInfoService.saveDataToWeatherDB(rowDataSorted2.getCorrectData());
                    if (upload2DBInfo.isSuccessOp()) {
                        //记录成功插入第几行的数据
//                        this.savedRowsCode.add(rowNum);
                        flag = true;
                    }
                }
                break;
            //疾病信息表
            case 42:
                RowDataSorted<CardInfo, ErrorCardInfo> rowDataSorted3 = uploadToCardInfoService.cardInformationCellData(cellValues,fileName);
                if (rowDataSorted3.getHasError()) {//行数据有错
//                    this.errorRowsCode.add(rowNum);
                    flag = false;
                } else {//行数据没有错误
                    Upload2DBInfo upload2DBInfo = uploadToCardInfoService.saveDataToCardDB(rowDataSorted3.getCorrectData());
                    if (upload2DBInfo.isSuccessOp()) {
                        //记录成功插入第几行的数据
//                        this.savedRowsCode.add(rowNum);
                        flag = true;
                    }
                }
                break;
            case 1:
                break;
            default:
                break;
        }
        return flag;
    }
}
