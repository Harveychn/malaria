package com.edupractice.malaria.modules.upload.service;

import com.edupractice.malaria.modules.upload.pojo.Data2DBInfo;

public interface ExcelOperateService {
    Data2DBInfo ExcelOperateSave(String path)throws Exception;
}
