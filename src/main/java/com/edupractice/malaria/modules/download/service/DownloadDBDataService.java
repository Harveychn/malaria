package com.edupractice.malaria.modules.download.service;

import com.edupractice.malaria.modules.download.pojo.CategoryFieldsRe;

import java.util.List;

public interface DownloadDBDataService {
    List<CategoryFieldsRe> getFieldsNameDownload(String category)throws Exception;
}
