package com.edupractice.malaria.modules.upload.service.impl;

import com.edupractice.malaria.modules.common.pojo.constant.CARDCONSTANT;
import com.edupractice.malaria.modules.common.pojo.constant.STATIONCONSTANT;
import com.edupractice.malaria.modules.common.pojo.constant.WEATHERCONSTANT;
import com.edupractice.malaria.modules.upload.service.DispatcherUploadFileService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DispatcherUploadFileServiceImpl implements DispatcherUploadFileService{

    public int getDestination(String filePath) throws Exception {
        int caseNum = 0;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            HSSFSheet hssfSheet = workbook.getSheetAt(0);
            //第一行
            HSSFRow hssfRow = hssfSheet.getRow(0);
            List<String> fieldNames = new ArrayList<>();
            //循环第一行单元格,每一个单元格的值保存到list中
            for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
                String cellValue = hssfRow.getCell(i).getStringCellValue().trim();
                fieldNames.add(i, cellValue);
            }
            caseNum = getCaseNum(fieldNames);
        } else if (filePath.endsWith(".xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet xssfSheet = workbook.getSheetAt(0);
            XSSFRow xssfRow = xssfSheet.getRow(0);
            List<String> fieldNames = new ArrayList<>();
            for (int i = 0; i < xssfRow.getLastCellNum(); i++) {
                String cellValue = xssfRow.getCell(i).getStringCellValue().trim();
                fieldNames.add(i, cellValue);
            }
            caseNum = getCaseNum(fieldNames);
        }
        return caseNum;
    }

    /**
     * 根据上传excel文件的第一行字段名判断数据是上传到那张表
     *
     * @param fieldNames
     * @return -1:无效格式表格
     * 1：疾病信息
     * 2：气候信息
     * 3：气候站信息
     * @throws Exception
     */
    private int getCaseNum(List<String> fieldNames) throws Exception {
        if (cardRowNameList().equals(fieldNames)) {
                return 1;
            }
        if (weatherRowNameList().equals(fieldNames)) {
                return 2;
            }
        if(stationRowNameList().equals(fieldNames)){
            {
                return 3;
            }
        }
        //-1 表示出现错误，不存在该字段值的文件模板
        return -1;
    }

    private List<String> cardRowNameList(){
        List<String> cardList = new ArrayList<>();
        cardList.add(0,CARDCONSTANT.getCardId());
        cardList.add(1,CARDCONSTANT.getCardNum());
        cardList.add(2,CARDCONSTANT.getCardStatus());
        cardList.add(3,CARDCONSTANT.getPatientName());
        cardList.add(4,CARDCONSTANT.getSEX());
        cardList.add(5,CARDCONSTANT.getBIRTHDAY());
        cardList.add(6,CARDCONSTANT.getAGE());
        cardList.add(7,CARDCONSTANT.getWorkUnit());
        cardList.add(8,CARDCONSTANT.getTEL());
        cardList.add(9,CARDCONSTANT.getBelongsLevel());
        cardList.add(10,CARDCONSTANT.getAddressNationId());
        cardList.add(11,CARDCONSTANT.getADDRESS());
        cardList.add(12,CARDCONSTANT.getCAREER());
        cardList.add(13,CARDCONSTANT.getCaseCategory1Name());
        cardList.add(14,CARDCONSTANT.getCaseCategory2Name());
        cardList.add(15,CARDCONSTANT.getIllDate());
        cardList.add(16,CARDCONSTANT.getConfirmDate());
        cardList.add(17,CARDCONSTANT.getDeathDate());
        cardList.add(18,CARDCONSTANT.getDiseaseName());
        cardList.add(19,CARDCONSTANT.getDiseasePreRevised());
        cardList.add(20,CARDCONSTANT.getFillCardDoc());
        cardList.add(21,CARDCONSTANT.getFillCardDate());
        cardList.add(22,CARDCONSTANT.getReportUnitAreaCode());
        cardList.add(23,CARDCONSTANT.getReportUnit());
        cardList.add(24,CARDCONSTANT.getUnitType());
        cardList.add(25,CARDCONSTANT.getReportInputDate());
        cardList.add(26,CARDCONSTANT.getInputUser());
        cardList.add(27,CARDCONSTANT.getInputUserUnit());
        cardList.add(28,CARDCONSTANT.getCountyJudgeDate());
        cardList.add(29,CARDCONSTANT.getLocalJudgeDate());
        cardList.add(30,CARDCONSTANT.getProvinceJudgeDate());
        cardList.add(31,CARDCONSTANT.getJudgeStatus());
        cardList.add(32,CARDCONSTANT.getRevisedReportDate());
        cardList.add(33,CARDCONSTANT.getRevisedFinalJudgeDate());
        cardList.add(34,CARDCONSTANT.getDeathFinalJudgeDate());
        cardList.add(35,CARDCONSTANT.getRevisedUser());
        cardList.add(36,CARDCONSTANT.getRevisedUserUnit());
        cardList.add(37,CARDCONSTANT.getDelDate());
        cardList.add(38,CARDCONSTANT.getDelUser());
        cardList.add(39,CARDCONSTANT.getDelUserUnit());
        cardList.add(40,CARDCONSTANT.getDelReason());
        cardList.add(41,CARDCONSTANT.getNOTES());

        return cardList;
    }

    private List<String> stationRowNameList(){
        List<String> stationList = new ArrayList<>();
        stationList.add(0,STATIONCONSTANT.getStationId());
        stationList.add(1,STATIONCONSTANT.getStationName());
        stationList.add(2,STATIONCONSTANT.getPROVINCES());
        stationList.add(3,STATIONCONSTANT.getLAT());
        stationList.add(4,STATIONCONSTANT.getLNG());
        stationList.add(5,STATIONCONSTANT.getALTITUDE());
        stationList.add(6,STATIONCONSTANT.getStartYear());
        stationList.add(7,STATIONCONSTANT.getStartMonth());
        stationList.add(8,STATIONCONSTANT.getEndYear());
        stationList.add(9,STATIONCONSTANT.getEndMonth());
        stationList.add(10, STATIONCONSTANT.getLackMeasurement());
        return stationList;
    }

    private List<String> weatherRowNameList(){
        List<String> weatherList = new ArrayList<>();
        weatherList.add(0,WEATHERCONSTANT.getStationId());
        weatherList.add(1,WEATHERCONSTANT.getWeatherYear());
        weatherList.add(2,WEATHERCONSTANT.getWeatherMonth());
        weatherList.add(3,WEATHERCONSTANT.getWeatherDay());
        weatherList.add(4,WEATHERCONSTANT.getPrecipitation2020());
        weatherList.add(5,WEATHERCONSTANT.getMaximumWindSpeed());
        weatherList.add(6,WEATHERCONSTANT.getDirectionMaximumWindSpeed());
        weatherList.add(7,WEATHERCONSTANT.getAvePressure());
        weatherList.add(8,WEATHERCONSTANT.getAveWindSpeed());
        weatherList.add(9,WEATHERCONSTANT.getAveTemperature());
        weatherList.add(10,WEATHERCONSTANT.getAveVaporPressure());
        weatherList.add(11,WEATHERCONSTANT.getAveRelativeHumidity());
        weatherList.add(12,WEATHERCONSTANT.getSunshineTime());
        weatherList.add(13,WEATHERCONSTANT.getDailyMinPressure());
        weatherList.add(14,WEATHERCONSTANT.getDailyMinTemperature());
        weatherList.add(15,WEATHERCONSTANT.getDailyMaxPressure());
        weatherList.add(16,WEATHERCONSTANT.getDailyMaxTemperature());
        weatherList.add(17,WEATHERCONSTANT.getMaxWindSpeed());
        weatherList.add(18,WEATHERCONSTANT.getDirectionMaxWindSpeed());
        weatherList.add(19,WEATHERCONSTANT.getMinRelativeHumidity());
        return weatherList;
    }
}
