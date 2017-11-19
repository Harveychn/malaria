package com.edupractice.malaria.modules.upload.service;

import com.edupractice.malaria.modules.upload.pojo.*;

import java.util.Map;

public interface UploadToCardInfoService {
    Upload2DBInfo saveDataToCardDB(CardInfo rowData) throws Exception;
    RowDataSorted<CardInfo, ErrorCardInfo> cardInformationCellData(Map<String, String> cellValues,String fileName) throws Exception;
}
