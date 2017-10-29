package com.edupractice.malaria.modules.upload.pojo;

import java.util.List;

public class UploadInfo {
    //成功保存的行数
    private int savedRowsTotal;
    //有错数据行
    private List<Integer> errorRowCodes;
    //当前操作文件名
    private String fileName;
    private boolean isFileTypeError;
    //非正常读取错误及信息
//    private boolean isErrorOccur;
//    private String errorMessage;
    //是否有该上传文件数据格式的模板
    private boolean isHasThisModule;

    public int getSavedRowsTotal() {
        return savedRowsTotal;
    }

    public void setSavedRowsTotal(int savedRowsTotal) {
        this.savedRowsTotal = savedRowsTotal;
    }

    public List<Integer> getErrorRowCodes() {
        return errorRowCodes;
    }

    public void setErrorRowCodes(List<Integer> errorRowCodes) {
        this.errorRowCodes = errorRowCodes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFileTypeError() {
        return isFileTypeError;
    }

    public void setFileTypeError(boolean fileTypeError) {
        isFileTypeError = fileTypeError;
    }

    public boolean isHasThisModule() {
        return isHasThisModule;
    }

    public void setHasThisModule(boolean hasThisModule) {
        isHasThisModule = hasThisModule;
    }
}
