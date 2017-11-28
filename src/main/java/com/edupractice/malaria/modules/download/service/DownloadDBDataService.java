package com.edupractice.malaria.modules.download.service;

import com.edupractice.malaria.modules.download.pojo.CategoryFieldsRe;
import com.edupractice.malaria.modules.download.pojo.DownloadParamVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public interface DownloadDBDataService {
    List<CategoryFieldsRe> getFieldsNameDownload(String category)throws Exception;
    HSSFWorkbook downloadData(DownloadParamVo downloadParamVo) throws Exception;
}
