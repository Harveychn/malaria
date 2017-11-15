package com.edupractice.malaria.modules.upload.service.impl;

import com.edupractice.malaria.modules.common.dao.*;
import com.edupractice.malaria.modules.common.pojo.*;
import com.edupractice.malaria.modules.upload.pojo.*;
import com.edupractice.malaria.modules.upload.service.UploadToCardInfoService;
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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UploadToCardInfoServiceImpl implements UploadToCardInfoService {
    @Resource
    private CardMapper cardInformationMapper;
    @Resource
    private CaseCategory1Mapper caseCategory1Mapper;
    @Resource
    private CaseCategory2Mapper caseCategory2Mapper;
    @Resource
    private DiseaseMapper diseaseMapper;
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private PatientBelongsMapper patientBelongsMapper;
    @Resource
    private CareerMapper careerMapper;
    @Resource
    private AddressGeocodeMapper addressGeocodeMapper;
    @Resource
    private MedicalUnitMapper medicalUnitMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private MeteorologicalStationMapper meteorologicalStationMapper;
    @Resource
    private WeatherDataMapper weatherDataMapper;

    private String fileYear;
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UploadToCardInfoServiceImpl.class);

    public Data2DBInfo saveDataToDB(String filePath) throws Exception {
        fileYear = filePath.substring(filePath.lastIndexOf("-") + 1, filePath.lastIndexOf("."));
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
                    if (switchTable(fieldNames, cellValues, rowNum)) {
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
                    if (switchTable(fieldNames, cellValues, rowNum)) {
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
    private Boolean switchTable(List<String> fieldNames, Map<String, String> cellValues, int rowNum) throws Exception {
        Boolean flag = null;

        switch (fieldNames.size()) {

            //气候站表
            case 11:
                RowDataSorted<MeteorologicalStation, ErrorStationInfo> rowDataSorted1 = null;
                rowDataSorted1 = MeteorologicalStationCellData(cellValues);
                if (rowDataSorted1.getHasError()) {//行数据有错
//                    this.errorRowsCode.add(rowNum);
                    flag = false;
                } else {//行数据没有错误
                    Upload2DBInfo upload2DBInfo = saveDataToStationDB(rowDataSorted1.getCorrectData());
                    if (upload2DBInfo.isSuccessOp()) {
                        //记录成功插入第几行的数据
//                        this.savedRowsCode.add(rowNum);
                        flag = true;
                    }
                }
                break;
            //气候信息表
            case 20: RowDataSorted<WeatherData, ErrorWeatherInfo> rowDataSorted2 = null;
                rowDataSorted2 = WeatherDateCellData(cellValues);
                if (rowDataSorted2.getHasError()) {//行数据有错
//                    this.errorRowsCode.add(rowNum);
                    flag = false;
                } else {//行数据没有错误
                    Upload2DBInfo upload2DBInfo = saveDataToWeatherDB(rowDataSorted2.getCorrectData());
                    if (upload2DBInfo.isSuccessOp()) {
                        //记录成功插入第几行的数据
//                        this.savedRowsCode.add(rowNum);
                        flag = true;
                    }
                }
                break;
            //疾病信息表
            case 42:
                RowDataSorted<CardInfo, ErrorCardInfo> rowDataSorted3 = cardInformationCellData(cellValues);
                if (rowDataSorted3.getHasError()) {//行数据有错
//                    this.errorRowsCode.add(rowNum);
                    flag = false;
                } else {//行数据没有错误
                    Upload2DBInfo upload2DBInfo = saveDataToCardDB(rowDataSorted3.getCorrectData());
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

    /**
     * 对Card表中行数据，每个单元数据进行读取处理，返回正确或错误信息
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private RowDataSorted<CardInfo, ErrorCardInfo> cardInformationCellData(Map<String, String> cellValues) throws Exception {
        RowDataSorted<CardInfo, ErrorCardInfo> rowDataSorted = new RowDataSorted<>();
        DateFormat df = DateFormat.getDateInstance();
        Date nullDate = df.parse("0000-00-00");
        try {
            CardInfo cardInfo = new CardInfo();
            cardInfo.setYear(Integer.parseInt(fileYear));
            cardInfo.setCardID(Integer.parseInt(cellValues.get("卡片ID")));
            cardInfo.setCardNum(cellValues.get("卡片编号"));
            if (cellValues.get("卡片状态").trim().equals("原始卡")) {
                cardInfo.setCardStatus(CONSTANT.getOriginCardstatus());
            } else if (cellValues.get("卡片状态").trim().equals("订正卡")) {
                cardInfo.setCardStatus(CONSTANT.getRevisedCardstatus());
            } else {
                cardInfo.setCardStatus(CONSTANT.getUknownCardstatus());
            }
            cardInfo.setPatientName(cellValues.get("患者姓名"));
            if (cellValues.get("性别").trim().equals("男")) {
                cardInfo.setSex(CONSTANT.getSexMale());
            } else if (cellValues.get("性别").trim().equals("女")) {
                cardInfo.setSex(CONSTANT.getSexFemale());
            } else {
                cardInfo.setSex(CONSTANT.getSexUnknown());
            }
            if (!cellValues.get("出生日期").equals(".")) {
                cardInfo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("出生日期")));
            } else {
                cardInfo.setBirthday(nullDate);
            }

            cardInfo.setAge(cellValues.get("年龄"));
            cardInfo.setWorkUnit(cellValues.get("患者工作单位"));
            cardInfo.setTel(cellValues.get("联系电话"));
            cardInfo.setBelongsLevel(cellValues.get("病人属于"));
            cardInfo.setAddressNationID(Integer.parseInt(cellValues.get("现住地址国标")));
            cardInfo.setAddress(cellValues.get("现住详细地址"));
            cardInfo.setCareer(cellValues.get("职业"));
            cardInfo.setCaseCategory1Name(cellValues.get("病例分类"));
            cardInfo.setCaseCategory2Name(cellValues.get("病例分类2"));
            if (!cellValues.get("发病日期").equals(".")) {
                cardInfo.setIllDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("发病日期")));
            } else {
                cardInfo.setIllDate(nullDate);
            }
            if (!cellValues.get("诊断时间").equals(".")) {
                cardInfo.setConfirmDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("诊断时间")));
            } else {
                cardInfo.setConfirmDate(nullDate);
            }
            if (!cellValues.get("死亡日期").equals(".")) {
                cardInfo.setDeathDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("死亡日期")));
            } else {
                cardInfo.setDeathDate(nullDate);
            }
            cardInfo.setDiseaseName(cellValues.get("疾病名称"));
            cardInfo.setDiseasePreRevised(cellValues.get("订正前病种"));
            cardInfo.setFillCardDoc(cellValues.get("填卡医生"));
            if (!cellValues.get("医生填卡日期").equals(".")) {
                cardInfo.setFillCardDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("医生填卡日期")));
            } else {
                cardInfo.setFillCardDate(nullDate);
            }
            cardInfo.setReportUnitAreaCode(cellValues.get("报告单位地区编码"));
            cardInfo.setReportUnit(cellValues.get("报告单位"));
            cardInfo.setUnitType(cellValues.get("单位类型"));
            if (!cellValues.get("报告卡录入时间").equals(".")) {
                cardInfo.setReportInputDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("报告卡录入时间")));
            } else {
                cardInfo.setReportInputDate(nullDate);
            }
            cardInfo.setInputUser(cellValues.get("录卡用户"));
            cardInfo.setInputUserUnit(cellValues.get("录卡用户所属单位"));
            cardInfo.setCountyJudgeDate(cellValues.get("县区审核时间"));
            cardInfo.setLocalJudgeDate(cellValues.get("地市审核时间"));
            cardInfo.setProvinceJudgeDate(cellValues.get("省市审核时间"));
            if (cellValues.get("审核状态").equals("已终审卡")) {
                cardInfo.setJudgeStatus(CONSTANT.getPassJudgestatus());
            } else {
                cardInfo.setJudgeStatus(CONSTANT.getOtherJudgestatus());
            }
            if (!cellValues.get("订正报告时间").equals(".")) {
                cardInfo.setRevisedReportDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("订正报告时间")));
            } else {
                cardInfo.setRevisedReportDate(nullDate);
            }
            if (!cellValues.get("订正终审时间").equals(".")) {
                cardInfo.setRevisedFinalJudgeDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("订正终审时间")));
            } else {
                cardInfo.setRevisedFinalJudgeDate(nullDate);
            }
            if (!cellValues.get("终审死亡时间").equals(".")) {
                cardInfo.setDeathFinalJudgeDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("终审死亡时间")));
            } else {
                cardInfo.setDeathFinalJudgeDate(nullDate);
            }
            cardInfo.setRevisedUser(cellValues.get("订正用户"));
            cardInfo.setRevisedUserUnit(cellValues.get("订正用户所属单位"));
            if (!cellValues.get("删除时间").equals(".")) {
                cardInfo.setDelDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("删除时间")));
            } else {
                cardInfo.setDelDate(nullDate);
            }
            cardInfo.setDelUser(cellValues.get("删除用户"));
            cardInfo.setDelUserUnit(cellValues.get("删除用户所属单位"));
            cardInfo.setDelReason(cellValues.get("删除原因"));
            cardInfo.setNotes(cellValues.get("备注"));
            rowDataSorted.setHasError(Boolean.FALSE);
            rowDataSorted.setCorrectData(cardInfo);
        } catch (NumberFormatException e) {
            logger.error("NumberFormatException: " + e.getMessage());
            ErrorCardInfo errorCardInform = dealCardError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        } catch (ParseException e) {
            logger.error("ParseException: " + e.getMessage());
            ErrorCardInfo errorCardInform = dealCardError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            ErrorCardInfo errorCardInform = dealCardError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        }
        return rowDataSorted;
    }

    /**
     * 对Station表中行数据，每个单元数据进行读取处理，返回正确或错误信息
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private RowDataSorted<MeteorologicalStation, ErrorStationInfo> MeteorologicalStationCellData(Map<String, String> cellValues) throws Exception {
        RowDataSorted<MeteorologicalStation, ErrorStationInfo> rowDataSorted = new RowDataSorted<>();
        try {
            MeteorologicalStation meteorologicalStation = new MeteorologicalStation();
            if (!cellValues.get("区站号").trim().equals(".")) {
                meteorologicalStation.setStationId(Integer.parseInt(cellValues.get("区站号")));
            }
            if (!cellValues.get("台站名称").trim().equals(".")) {
                meteorologicalStation.setStationName(cellValues.get("台站名称").trim());
            }
            if (!cellValues.get("省份").trim().equals(".")) {
                meteorologicalStation.setProvinces(cellValues.get("省份").trim());
            }
            if (!cellValues.get("纬度(度分)").trim().equals(".")) {
                meteorologicalStation.setLat(Integer.parseInt(cellValues.get("纬度(度分)").trim()));
            }
            if (!cellValues.get("经度(度分)").trim().equals(".")) {
                meteorologicalStation.setLng(Integer.parseInt(cellValues.get("经度(度分)").trim()));
            }
            if (!cellValues.get("海拔高度(0.1米)").trim().equals(".")) {
                meteorologicalStation.setAltitude(Integer.parseInt(cellValues.get("海拔高度(0.1米)")));
            }
            if (!cellValues.get("开始年份").trim().equals(".")) {
                meteorologicalStation.setStartYear(Integer.parseInt(cellValues.get("开始年份").trim()));
            }
            if (!cellValues.get("开始月份").trim().equals(".")) {
                meteorologicalStation.setStartMonth(Integer.parseInt(cellValues.get("开始月份").trim()));
            }
            if (!cellValues.get("截止年份").trim().equals(".")) {
                meteorologicalStation.setEndYear(Integer.parseInt(cellValues.get("截止年份").trim()));
            }
            if (!cellValues.get("截止月份").trim().equals(".")) {
                meteorologicalStation.setEndMonth(Integer.parseInt(cellValues.get("截止月份").trim()));
            }
            if (!cellValues.get("缺测情况").trim().equals(".")) {
                meteorologicalStation.setLackMeasurement(cellValues.get("缺测情况").trim());
            }
            rowDataSorted.setHasError(Boolean.FALSE);
            rowDataSorted.setCorrectData(meteorologicalStation);

        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            ErrorStationInfo errorStationInfo = dealStationError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorStationInfo);
        }
        return rowDataSorted;
    }

    /**
     * 对Weather表中行数据，每个单元数据进行读取处理，返回正确或错误信息
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private RowDataSorted<WeatherData,ErrorWeatherInfo> WeatherDateCellData(Map<String, String> cellValues) {
        RowDataSorted<WeatherData,ErrorWeatherInfo> rowDataSorted = new RowDataSorted<>();
        try{
            WeatherData weatherData =new WeatherData();
            weatherData.setStationId(Integer.parseInt(cellValues.get("区站号").trim()));
            weatherData.setWeatherYear(Integer.parseInt(cellValues.get("年").trim()));
            weatherData.setWeatherMonth(Integer.parseInt(cellValues.get("月").trim()));
            weatherData.setWeatherDay(Integer.parseInt(cellValues.get("日").trim()));
            weatherData.setPrecipitation2020(cellValues.get("20-20时降水量").trim());
            weatherData.setMaximumWindSpeed(Integer.parseInt(cellValues.get("极大风速").trim()));
            weatherData.setDirectionMaximumWindSpeed(cellValues.get("极大风速的风向").trim());
            weatherData.setAvePressure(Integer.parseInt(cellValues.get("平均本站气压").trim()));
            weatherData.setAveWindSpeed(Integer.parseInt(cellValues.get("平均风速").trim()));
            weatherData.setAveTemperature(Integer.parseInt(cellValues.get("平均气温").trim()));
            weatherData.setAveVaporPressure(Integer.parseInt(cellValues.get("平均水汽压").trim()));
            weatherData.setAveRelativeHumidity(Integer.parseInt(cellValues.get("平均相对湿度").trim()));
            weatherData.setSunshineTime(Integer.parseInt(cellValues.get("日照时数").trim()));
            weatherData.setDailyMinPressure(Integer.parseInt(cellValues.get("日最低本站气压").trim()));
            weatherData.setDailyMinTemperature(Integer.parseInt(cellValues.get("日最低气温").trim()));
            weatherData.setDailyMaxPressure(Integer.parseInt(cellValues.get("日最高本站气压").trim()));
            weatherData.setDailyMaxTemperature(Integer.parseInt(cellValues.get("日最高气温").trim()));
            weatherData.setMaxWindSpeed(Integer.parseInt(cellValues.get("最大风速").trim()));
            weatherData.setDirectionMaxWindspeed(cellValues.get("最大风速的风向").trim());
            weatherData.setMinRelativeHumidity(Integer.parseInt(cellValues.get("最小相对湿度").trim()));
            rowDataSorted.setHasError(Boolean.FALSE);
            rowDataSorted.setCorrectData(weatherData);
        }catch (Exception e){
            logger.error("Exception: " + e.getMessage());
            ErrorWeatherInfo  errorWeatherInfo= dealWeatherDataError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorWeatherInfo);
        }

        return rowDataSorted;
    }


    /**
     * 用于提取Card不符合格式的、错误的数据
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private ErrorCardInfo dealCardError(Map<String, String> cellValues) throws Exception {
        ErrorCardInfo errorCardInfo = new ErrorCardInfo();
        errorCardInfo.setYear(cellValues.get("数据年份"));
        errorCardInfo.setCardID(cellValues.get("卡片ID"));
        errorCardInfo.setCardNum(cellValues.get("卡片编号"));
        errorCardInfo.setCardStatus(cellValues.get("卡片状态"));
        errorCardInfo.setPatientName(cellValues.get("患者姓名"));
        errorCardInfo.setSex(cellValues.get("性别"));
        errorCardInfo.setBirthday(cellValues.get("出生日期"));
        errorCardInfo.setAge(cellValues.get("年龄"));
        errorCardInfo.setWorkUnit(cellValues.get("患者工作单位"));
        errorCardInfo.setTel(cellValues.get("联系电话"));
        errorCardInfo.setBelongsLevel(cellValues.get("病人属于"));
        errorCardInfo.setAddressNationID(cellValues.get("现住地址国标"));
        errorCardInfo.setAddress(cellValues.get("现住详细地址"));
        errorCardInfo.setCareer(cellValues.get("职业"));
        errorCardInfo.setCaseCategory1Name(cellValues.get("病例分类"));
        errorCardInfo.setCaseCategory2Name(cellValues.get("病例分类2"));
        errorCardInfo.setIllDate(cellValues.get("发病日期"));
        errorCardInfo.setConfirmDate(cellValues.get("诊断时间"));
        errorCardInfo.setDeathDate(cellValues.get("死亡日期"));
        errorCardInfo.setDiseaseName(cellValues.get("疾病名称"));
        errorCardInfo.setDiseasePreRevised(cellValues.get("订正前病种"));
        errorCardInfo.setFillCardDoc(cellValues.get("填卡医生"));
        errorCardInfo.setFillCardDate(cellValues.get("医生填卡日期"));
        errorCardInfo.setReportUnitAreaCode(cellValues.get("报告单位地区编码"));
        errorCardInfo.setReportUnit(cellValues.get("报告单位"));
        errorCardInfo.setUnitType(cellValues.get("单位类型"));
        errorCardInfo.setReportInputDate(cellValues.get("报告卡录入时间"));
        errorCardInfo.setInputUser(cellValues.get("录卡用户"));
        errorCardInfo.setInputUserUnit(cellValues.get("录卡用户所属单位"));
        errorCardInfo.setCountyJudgeDate(cellValues.get("县区审核时间"));
        errorCardInfo.setLocalJudgeDate(cellValues.get("地市审核时间"));
        errorCardInfo.setProvinceJudgeDate(cellValues.get("省市审核时间"));
        errorCardInfo.setJudgeStatus(cellValues.get("审核状态"));
        errorCardInfo.setRevisedReportDate(cellValues.get("订正报告时间"));
        errorCardInfo.setRevisedFinalJudgeDate(cellValues.get("订正终审时间"));
        errorCardInfo.setDeathFinalJudgeDate(cellValues.get("终审死亡时间"));
        errorCardInfo.setRevisedUser(cellValues.get("订正用户"));
        errorCardInfo.setRevisedUserUnit(cellValues.get("订正用户所属单位"));
        errorCardInfo.setDelDate(cellValues.get("删除时间"));
        errorCardInfo.setDelUser(cellValues.get("删除用户"));
        errorCardInfo.setDelUserUnit(cellValues.get("删除用户所属单位"));
        errorCardInfo.setDelReason(cellValues.get("删除原因"));
        errorCardInfo.setNotes(cellValues.get("备注"));
        return errorCardInfo;
    }

    /**
     * 用于提取Station不符合格式的、错误的数据
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private ErrorStationInfo dealStationError(Map<String, String> cellValues) throws Exception {
        ErrorStationInfo errorStationInfo = new ErrorStationInfo();
        errorStationInfo.setStationId(cellValues.get("区站号"));
        errorStationInfo.setStationName(cellValues.get("台站名称"));
        errorStationInfo.setProvinces(cellValues.get("省份"));
        errorStationInfo.setLat(cellValues.get("纬度(度分)"));
        errorStationInfo.setLng(cellValues.get("经度(度分)"));
        errorStationInfo.setAltitude(cellValues.get("海拔高度(0.1米)"));
        errorStationInfo.setStartYear(cellValues.get("开始年份"));
        errorStationInfo.setStartMonth(cellValues.get("开始月份"));
        errorStationInfo.setEndYear(cellValues.get("截止年份"));
        errorStationInfo.setEndMonth(cellValues.get("截止月份"));
        errorStationInfo.setLackMeasurement(cellValues.get("缺测情况"));
        return errorStationInfo;
    }

    /**
     * 用于提取WeatherData不符合格式的、错误的数据
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private ErrorWeatherInfo dealWeatherDataError(Map<String, String> cellValues) {
        ErrorWeatherInfo errorWeatherInfo = new ErrorWeatherInfo();
        errorWeatherInfo.setDistrictStationNum(cellValues.get("区站号").trim());
        errorWeatherInfo.setWeatherYear(cellValues.get("年").trim());
        errorWeatherInfo.setWeatherMonth(cellValues.get("月").trim());
        errorWeatherInfo.setWeatherDay(cellValues.get("日").trim());
        errorWeatherInfo.setPrecipitation2020(cellValues.get("20-20时降水量").trim());
        errorWeatherInfo.setMaximumWindSpeed(cellValues.get("极大风速").trim());
        errorWeatherInfo.setDirectionMaximumWindSpeed(cellValues.get("极大风速的风向").trim());
        errorWeatherInfo.setAvePressure(cellValues.get("平均本站气压").trim());
        errorWeatherInfo.setAveWindSpeed(cellValues.get("平均风速").trim());
        errorWeatherInfo.setAveTemperature(cellValues.get("平均气温").trim());
        errorWeatherInfo.setAveVaporPressure(cellValues.get("平均水汽压").trim());
        errorWeatherInfo.setAveRelativeHumidity(cellValues.get("平均相对湿度").trim());
        errorWeatherInfo.setSunshineTime(cellValues.get("日照时数").trim());
        errorWeatherInfo.setDailyMinPressure(cellValues.get("日最低本站气压").trim());
        errorWeatherInfo.setDailyMinTemperature(cellValues.get("日最低气温").trim());
        errorWeatherInfo.setDailyMaxPressure(cellValues.get("日最高本站气压").trim());
        errorWeatherInfo.setDailyMaxTemperature(cellValues.get("日最高气温").trim());
        errorWeatherInfo.setMaxWindSpeed(cellValues.get("最大风速").trim());
        errorWeatherInfo.setDirectionMaxWindSpeed(cellValues.get("最大风速的风向").trim());
        errorWeatherInfo.setMinRelativeHumidity(cellValues.get("最小相对湿度").trim());
        return errorWeatherInfo;
    }


    /**
     * 保存正确的行数据到数据库Card中
     *
     * @param rowData
     * @throws Exception
     */
    private Upload2DBInfo saveDataToCardDB(CardInfo rowData) throws Exception {
        Upload2DBInfo upload2DBInfo = new Upload2DBInfo();
        if (null != cardInformationMapper.selectByPrimaryKey(rowData.getCardID())) {
            upload2DBInfo.setNeedUpdate(true);
            upload2DBInfo.setNeedInsert(false);
        } else {
            upload2DBInfo.setNeedUpdate(false);
            upload2DBInfo.setNeedInsert(true);
        }
        try {
            Card card = new Card();
            //卡片编号，主键唯一标识
            card.setCardId(rowData.getCardID());
            card.setCardNum(rowData.getCardNum());
            card.setCardStatus(rowData.getCardStatus() + "");
            card.setYear(rowData.getYear());
            card.setIllDate(rowData.getIllDate());
            card.setConfirmDate(rowData.getConfirmDate());
            card.setDeathDate(rowData.getDeathDate());
            card.setFillCardDate(rowData.getFillCardDate());
            card.setReportInputDate(rowData.getReportInputDate());
            card.setCountyJudgeDate(rowData.getCountyJudgeDate());
            card.setProvinceJudgeDate(rowData.getProvinceJudgeDate());
            card.setLocalJudgeDate(rowData.getLocalJudgeDate());
            card.setJudgeStatus(rowData.getJudgeStatus() + "");
            card.setDiseasePreRevised(rowData.getDiseasePreRevised());
            card.setRevisedReportDate(rowData.getRevisedReportDate());
            card.setRevisedFinalJudgeDate(rowData.getRevisedFinalJudgeDate());
            card.setDelDate(rowData.getDelDate());
            card.setDelReason(rowData.getDelReason());
            card.setNotes(rowData.getNotes());
            //外键部分
            //Card外键Categoryid1;
            CaseCategory1Example caseCategory1Example = new CaseCategory1Example();
            caseCategory1Example.createCriteria().andCategory1NameEqualTo(rowData.getCaseCategory1Name());
            List<CaseCategory1> caseCategory1 = caseCategory1Mapper.selectByExample(caseCategory1Example);
            //若现有数据库中存在，则直接将数据库中的结果插入到card表中
            if (0 < caseCategory1.size()) {
                card.setCategoryId1(caseCategory1.get(0).getCategoryId1());
            } else {
                CaseCategory1 insertCase = new CaseCategory1();
                insertCase.setCategory1Name(rowData.getCaseCategory1Name());
                if (1 == caseCategory1Mapper.insertSelective(insertCase)) {
                    card.setCategoryId1(insertCase.getCategoryId1());
                } else {
                    logger.error("caseCategory1Mapper.insertSelective(insertCase) 失败！");
                }
            }
            //card外键setCategoryid2();
            CaseCategory2Example caseCategory2Example = new CaseCategory2Example();
            caseCategory2Example.createCriteria().andCategory2NameEqualTo(rowData.getCaseCategory2Name());
            List<CaseCategory2> caseCategory2List = caseCategory2Mapper.selectByExample(caseCategory2Example);
            if (0 < caseCategory2List.size()) {
                card.setCategoryId1(caseCategory2List.get(0).getCategoryId2());
            } else {
                CaseCategory2 insertCase = new CaseCategory2();
                insertCase.setCategory2Name(rowData.getCaseCategory1Name());
                if (1 == caseCategory2Mapper.insertSelective(insertCase)) {
                    card.setCategoryId2(insertCase.getCategoryId2());
                } else {
                    logger.error("caseCategory2Mapper.insertSelective(insertCase) 失败!");
                }
            }

            //Card外键Patientid;
            PatientExample patientExample = new PatientExample();
            //patient外键AddressID
            int addressID = 0;
            AddressGeocodeExample addressGeocodeExample = new AddressGeocodeExample();
            addressGeocodeExample.createCriteria().andAddressEqualTo(rowData.getAddress());
            List<AddressGeocode> addressGeocodeList = addressGeocodeMapper.selectByExample(addressGeocodeExample);
            if (0 < addressGeocodeList.size()) {
                addressID = addressGeocodeList.get(0).getAddressId();
            } else {
                AddressGeocode addressGeocode = new AddressGeocode();
                addressGeocode.setAddress(rowData.getAddress());
                addressGeocode.setAddrNationId(rowData.getAddressNationID());
                if (1 == addressGeocodeMapper.insertSelective(addressGeocode)) {
                    addressID = addressGeocode.getAddressId();
                } else {
                    logger.error("addressGeocodeMapper.insertSelective(addressGeocode) 失败!");
                }
            }
            //patient外键CareerID
            int careerID = 0;
            CareerExample careerExample = new CareerExample();
            careerExample.createCriteria().andCareerEqualTo(rowData.getCareer());
            List<Career> careerList = careerMapper.selectByExample(careerExample);
            if (0 < careerList.size()) {
                careerID = careerList.get(0).getCareerId();
            } else {
                Career career = new Career();
                career.setCareer(rowData.getCareer());
                if (1 == careerMapper.insertSelective(career)) {
                    careerID = career.getCareerId();
                } else {
                    logger.error("careerMapper.insertSelective(career) 失败!");
                }
            }
            //patient外键belongsID
            int belongsID = 0;
            PatientBelongsExample patientBelongsExample = new PatientBelongsExample();
            patientBelongsExample.createCriteria().andBelongsLevelEqualTo(rowData.getBelongsLevel());
            List<PatientBelongs> patientBelongsList = patientBelongsMapper.selectByExample(patientBelongsExample);
            if (0 < patientBelongsList.size()) {
                belongsID = patientBelongsList.get(0).getBelongsId();
            } else {
                PatientBelongs patientBelongs = new PatientBelongs();
                patientBelongs.setBelongsLevel(rowData.getBelongsLevel());
                if (1 == patientBelongsMapper.insertSelective(patientBelongs)) {
                    belongsID = patientBelongs.getBelongsId();
                } else {
                    logger.error("patientBelongsMapper.insertSelective(patientBelongs) 失败!");
                }
            }

            patientExample.createCriteria().andPatientNameEqualTo(rowData.getPatientName())
                    .andSexEqualTo(rowData.getSex() + "")
                    .andAgeEqualTo(rowData.getAge())
                    .andBirthdayEqualTo(rowData.getBirthday())
                    .andWorkUnitEqualTo(rowData.getWorkUnit())
                    .andTelEqualTo(rowData.getTel())
                    .andAddressIdEqualTo(addressID)
                    .andCareerIdEqualTo(careerID)
                    .andBelongsIdEqualTo(belongsID);
            List<Patient> patientList = patientMapper.selectByExample(patientExample);
            if (0 < patientList.size()) {
                card.setPatientId(patientList.get(0).getPatientId());
            } else {
                Patient patient = new Patient();
                patient.setPatientName(rowData.getPatientName());
                patient.setSex(rowData.getSex() + "");
                patient.setAge(rowData.getAge());
                patient.setBirthday(rowData.getBirthday());
                patient.setWorkUnit(rowData.getWorkUnit());
                patient.setTel(rowData.getTel());
                patient.setAddressId(addressID);
                patient.setCareerId(careerID);
                patient.setBelongsId(belongsID);
                if (1 == patientMapper.insertSelective(patient)) {
                    card.setPatientId(patient.getPatientId());
                } else {
                    logger.error("patientMapper.insertSelective(patient) 失败!");
                }
            }

//        cardInformation.setDiseaseid();
            DiseaseExample diseaseExample = new DiseaseExample();
            diseaseExample.createCriteria().andDiseaseNameEqualTo(rowData.getDiseaseName());
            List<Disease> diseaseList = diseaseMapper.selectByExample(diseaseExample);
            if (0 < diseaseList.size()) {
                card.setDiseaseId(diseaseList.get(0).getDiseaseId());
            } else {
                Disease inserted = new Disease();
                inserted.setDiseaseName(rowData.getDiseaseName());
                if (1 == diseaseMapper.insertSelective(inserted)) {
                    card.setDiseaseId(inserted.getDiseaseId());
                } else {
                    logger.error("diseaseMapper.insertSelective(inserted) 失败!");
                }
            }


//        cardInformation.setFillcarddocid();
            MedicalUnit fillCardUnit = new MedicalUnit();
            fillCardUnit.setUnitName(rowData.getReportUnit());
//            fillCardUnit.setUnitetype(rowData.getUnitType());
//            fillCardUnit.setUniteareacode(rowData.getReportUnitAreaCode());
            int fillCardUniteID = getMedicalUniteID(fillCardUnit);
            Doctor fillCardDoc = new Doctor();
            fillCardDoc.setDoctorName(rowData.getFillCardDoc());
            fillCardDoc.setMedicalUnitId(fillCardUniteID);
            card.setFillCardDocId(dealDoctorID(fillCardDoc));
//        cardInformation.setInputuserid()
            MedicalUnit inputUnite = new MedicalUnit();
            inputUnite.setUnitName(rowData.getInputUserUnit());
            int inputUniteID = getMedicalUniteID(inputUnite);
            Doctor inputDoc = new Doctor();
            inputDoc.setDoctorName(rowData.getInputUser());
            inputDoc.setMedicalUnitId(inputUniteID);
            card.setInputUserId(dealDoctorID(inputDoc));
//        cardInformation.setReviseduserid();
            MedicalUnit revisedUnite = new MedicalUnit();
            revisedUnite.setUnitName(rowData.getRevisedUserUnit());
            int revisedUniteID = getMedicalUniteID(revisedUnite);
            Doctor revisedDoc = new Doctor();
            revisedDoc.setDoctorName(rowData.getRevisedUser());
            revisedDoc.setMedicalUnitId(revisedUniteID);
            card.setRevisedUserId(dealDoctorID(revisedDoc));
//        cardInformation.setDeluserid();
            MedicalUnit delUnite = new MedicalUnit();
            delUnite.setUnitName(rowData.getDelUserUnit());
            int delUniteID = getMedicalUniteID(delUnite);
            Doctor delDoc = new Doctor();
            delDoc.setDoctorName(rowData.getDelUser());
            delDoc.setMedicalUnitId(delUniteID);
            card.setDelUserId(dealDoctorID(delDoc));
            if (upload2DBInfo.isNeedUpdate()) {
                CardExample cardInformationExample = new CardExample();
                cardInformationExample.createCriteria().andCardIdEqualTo(rowData.getCardID());
                if (1 == cardInformationMapper.updateByExampleSelective(card, cardInformationExample)) {
                    logger.trace("cardInformation更新cardID为的" + card.getCardId() + "记录  成功 ");
                } else {
                    logger.error("cardInformation更新cardID为的" + card.getCardId() + "记录  失败 ");
                }
            }
            if (upload2DBInfo.isNeedInsert()) {
                if (1 == cardInformationMapper.insert(card)) {
                    logger.trace("cardInformation插入cardID为的" + card.getCardId() + "记录  成功 ");
                } else {
                    logger.error("cardInformation插入cardID为的" + card.getCardId() + "记录  失败 ");
                }
            }
        } catch (SQLException s) {
            upload2DBInfo.setSuccessOp(false);
            logger.error("saveDataToCardDB(CardInform rowData) 数据库操作失败");
            s.printStackTrace();
            return upload2DBInfo;
        } catch (Exception e) {
            upload2DBInfo.setSuccessOp(false);
            e.printStackTrace();
            logger.error("saveDataToCardDB(CardInform rowData)失败 Exception信息：" + e.getMessage());
            return upload2DBInfo;
        }
        upload2DBInfo.setSuccessOp(true);
        return upload2DBInfo;
    }

    /**
     * 获取medical_unite ID值
     *
     * @param medicalUnit
     * @return
     * @throws Exception
     */
    private int getMedicalUniteID(MedicalUnit medicalUnit) throws Exception {
        MedicalUnitExample medicalUnitExample = new MedicalUnitExample();
        //uniteName为unique
        medicalUnitExample.createCriteria().andUnitNameEqualTo(medicalUnit.getUnitName());
        List<MedicalUnit> medicalUnitList = medicalUnitMapper.selectByExample(medicalUnitExample);
        try {
            if (0 < medicalUnitList.size()) {
                return medicalUnitList.get(0).getMedicalUnitId();
            } else {//medical_Unit表没有该记录,此时插入记录
                MedicalUnit insertMedicalUnit = new MedicalUnit();
                insertMedicalUnit.setUnitName(medicalUnit.getUnitName());
                if (1 == medicalUnitMapper.insertSelective(insertMedicalUnit)) {
                    return insertMedicalUnit.getMedicalUnitId();
                } else {
                    logger.error("medicalUnitMapper.insertSelective(insertMedicalUnit) 失败!");
                }
            }
        } catch (Exception e) {
            logger.error("medical_unite插入数据时出现Exception 错误信息：" + e.getMessage());
        }
        return 0;
    }

    /**
     * 获取医生ID
     *
     * @param doctor
     * @return
     * @throws Exception
     */
    private int dealDoctorID(Doctor doctor) throws Exception {
        DoctorExample fillCardDoctorExample = new DoctorExample();
        fillCardDoctorExample.createCriteria().andDoctorNameEqualTo(doctor.getDoctorName())
                .andMedicalUnitIdEqualTo(doctor.getMedicalUnitId());
        List<Doctor> fillCardDocList = doctorMapper.selectByExample(fillCardDoctorExample);
        if (0 < fillCardDocList.size()) {
            return fillCardDocList.get(0).getDoctorId();
        } else {
            Doctor insertDoctor = new Doctor();
            insertDoctor.setDoctorName(doctor.getDoctorName());
            try {
                insertDoctor.setMedicalUnitId(doctor.getMedicalUnitId());
            } catch (Exception e) {
                logger.error("doctor.setMedicalunitid(fillCardUnitID) 错误");
            }
            if (1 == doctorMapper.insert(insertDoctor)) {
                return insertDoctor.getDoctorId();
            } else {
                logger.error("doctorMapper.insert(insertDoctor) 失败!");
            }
        }
        return 0;
    }

    /**
     * 保存正确的行数据到数据库Station中
     *
     * @param rowData
     * @throws Exception
     */
    private Upload2DBInfo saveDataToStationDB(MeteorologicalStation rowData) throws Exception {
        Upload2DBInfo upload2DBInfo = new Upload2DBInfo();
        if (null != meteorologicalStationMapper.selectByPrimaryKey(rowData.getStationId())) {
            upload2DBInfo.setNeedUpdate(true);
            upload2DBInfo.setNeedInsert(false);
        } else {
            upload2DBInfo.setNeedUpdate(false);
            upload2DBInfo.setNeedInsert(true);
        }
        try {
            MeteorologicalStation meteorologicalStation = new MeteorologicalStation();
            meteorologicalStation.setStationId(rowData.getStationId());
            meteorologicalStation.setStationName(rowData.getStationName());
            meteorologicalStation.setProvinces(rowData.getProvinces());
            meteorologicalStation.setLat(rowData.getLat());
            meteorologicalStation.setLng(rowData.getLng());
            meteorologicalStation.setAltitude(rowData.getAltitude());
            meteorologicalStation.setStartYear(rowData.getStartYear());
            meteorologicalStation.setStartMonth(rowData.getStartMonth());
            meteorologicalStation.setEndYear(rowData.getEndYear());
            meteorologicalStation.setEndMonth(rowData.getEndMonth());
            meteorologicalStation.setLackMeasurement(rowData.getLackMeasurement());
            if (upload2DBInfo.isNeedUpdate()) {
                MeteorologicalStationExample meteorologicalStationExample = new MeteorologicalStationExample();
                meteorologicalStationExample.createCriteria().andStationIdEqualTo(rowData.getStationId());
                if (1 == meteorologicalStationMapper.updateByExampleSelective(meteorologicalStation, meteorologicalStationExample)) {
                    logger.trace("meteorologicalStation更新stationID为的" + meteorologicalStation.getStationId() + "记录  成功 ");
                } else {
                    logger.error("meteorologicalStation更新stationID为的" + meteorologicalStation.getStationId() + "记录  失败 ");
                }
            }
            if (upload2DBInfo.isNeedInsert()) {
                if (1 == meteorologicalStationMapper.insert(meteorologicalStation)) {
                    logger.trace("meteorologicalStation插入stationID为的" + meteorologicalStation.getStationId() + "记录  成功 ");
                } else {
                    logger.error("meteorologicalStation插入stationID为的" + meteorologicalStation.getStationId() + "记录  失败 ");
                }
            }
        } catch (Exception e) {
            upload2DBInfo.setSuccessOp(false);
            logger.error("saveDataToStationDB(MeteorologicalStation rowData)失败 Exception信息：" + e.getMessage());
            return upload2DBInfo;
        }
        upload2DBInfo.setSuccessOp(true);
        return upload2DBInfo;
    }
    private Upload2DBInfo saveDataToWeatherDB(WeatherData rowData) {
        Upload2DBInfo upload2DBInfo = new Upload2DBInfo();
        WeatherDataExample weatherDataExample = new WeatherDataExample();
        //外键station_id
        MeteorologicalStationExample meteorologicalStationExample = new MeteorologicalStationExample();
        meteorologicalStationExample.createCriteria().andStationIdEqualTo(rowData.getStationId());
        MeteorologicalStation meteorologicalStation= meteorologicalStationMapper.selectByPrimaryKey(rowData.getStationId());
        if(null != meteorologicalStation ){

        }else {
            MeteorologicalStation inserted = new MeteorologicalStation();
            inserted.setStationId(rowData.getStationId());
            if (1 == meteorologicalStationMapper.insertSelective(inserted)) {
                //rowData.setStationId(inserted.getStationId());
            } else {
                logger.error("diseaseMapper.insertSelective(inserted) 失败!");
            }

        }
        weatherDataExample.createCriteria().andStationIdEqualTo(rowData.getStationId())
                .andWeatherYearEqualTo(rowData.getWeatherYear())
                .andWeatherMonthEqualTo(rowData.getWeatherMonth())
                .andWeatherDayEqualTo(rowData.getWeatherDay());
        List<WeatherData> weatherDataList = weatherDataMapper.selectByExample(weatherDataExample);
        if (0 < weatherDataList.size()) {
            upload2DBInfo.setNeedUpdate(true);
            upload2DBInfo.setNeedInsert(false);
            rowData.setWeatherId(weatherDataList.get(0).getWeatherId());
            if(1==weatherDataMapper.updateByPrimaryKey(rowData)){
                logger.trace("weatherData更新weatherID为的" + rowData.getWeatherId() + "记录  成功 ");
            } else {
                logger.error("cardInformation更新cardID为的" + rowData.getWeatherId() + "记录  失败 ");
            }
        } else {
            upload2DBInfo.setNeedUpdate(false);
            upload2DBInfo.setNeedInsert(true);
            if (1 == weatherDataMapper.insertSelective(rowData)) {
                System.out.println(rowData.getWeatherId());
            } else {
                logger.error("weatherDataMapper.insertSelective(rowData) 失败!");
            }
        }
        upload2DBInfo.setSuccessOp(true);

        return upload2DBInfo;
    }

}
