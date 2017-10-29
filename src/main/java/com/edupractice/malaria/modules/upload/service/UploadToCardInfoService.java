package com.edupractice.malaria.modules.upload.service;

import com.edupractice.malaria.modules.upload.pojo.Data2DBInfo;

public interface UploadToCardInfoService {
    Data2DBInfo saveDataToDB(String filePath) throws Exception;
}
