package com.edupractice.malaria.modules.upload.service;

import com.edupractice.malaria.modules.common.pojo.MeteorologicalStation;
import com.edupractice.malaria.modules.upload.pojo.ErrorStationInfo;
import com.edupractice.malaria.modules.upload.pojo.RowDataSorted;
import com.edupractice.malaria.modules.upload.pojo.Upload2DBInfo;

import java.util.Map;

public interface UploadToStationInfoService {
    RowDataSorted<MeteorologicalStation, ErrorStationInfo> MeteorologicalStationCellData(Map<String, String> cellValues) throws Exception;
    Upload2DBInfo saveDataToStationDB(MeteorologicalStation rowData) throws Exception;
}
