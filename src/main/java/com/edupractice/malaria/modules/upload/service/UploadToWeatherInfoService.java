package com.edupractice.malaria.modules.upload.service;

import com.edupractice.malaria.modules.common.pojo.WeatherData;
import com.edupractice.malaria.modules.upload.pojo.ErrorWeatherInfo;
import com.edupractice.malaria.modules.upload.pojo.RowDataSorted;
import com.edupractice.malaria.modules.upload.pojo.Upload2DBInfo;

import java.util.Map;

public interface UploadToWeatherInfoService {
    RowDataSorted<WeatherData,ErrorWeatherInfo> WeatherDateCellData(Map<String, String> cellValues);
    Upload2DBInfo saveDataToWeatherDB(WeatherData rowData);
}
