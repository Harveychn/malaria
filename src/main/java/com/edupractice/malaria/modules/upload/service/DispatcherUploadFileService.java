package com.edupractice.malaria.modules.upload.service;

/**
 * 根据第一行字段来判断文件数据应该上传到那一个表
 */
public interface DispatcherUploadFileService {
    int getDestination(String filePath) throws Exception;
}
