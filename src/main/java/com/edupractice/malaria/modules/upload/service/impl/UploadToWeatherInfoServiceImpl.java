package com.edupractice.malaria.modules.upload.service.impl;

import com.edupractice.malaria.modules.common.dao.MeteorologicalStationMapper;
import com.edupractice.malaria.modules.common.dao.WeatherDataMapper;
import com.edupractice.malaria.modules.common.pojo.MeteorologicalStation;
import com.edupractice.malaria.modules.common.pojo.MeteorologicalStationExample;
import com.edupractice.malaria.modules.common.pojo.WeatherData;
import com.edupractice.malaria.modules.common.pojo.WeatherDataExample;
import com.edupractice.malaria.modules.upload.pojo.ErrorWeatherInfo;
import com.edupractice.malaria.modules.upload.pojo.RowDataSorted;
import com.edupractice.malaria.modules.upload.pojo.Upload2DBInfo;
import com.edupractice.malaria.modules.upload.service.UploadToWeatherInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UploadToWeatherInfoServiceImpl implements UploadToWeatherInfoService{
    @Resource
    private MeteorologicalStationMapper meteorologicalStationMapper;
    @Resource
    private WeatherDataMapper weatherDataMapper;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UploadToWeatherInfoServiceImpl.class);
    /**
     * 对Weather表中行数据，每个单元数据进行读取处理，返回正确或错误信息
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    public RowDataSorted<WeatherData,ErrorWeatherInfo> WeatherDateCellData(Map<String, String> cellValues) {
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
    public Upload2DBInfo saveDataToWeatherDB(WeatherData rowData) {
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

}
