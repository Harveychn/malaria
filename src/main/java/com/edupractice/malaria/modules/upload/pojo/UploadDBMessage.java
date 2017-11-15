package com.edupractice.malaria.modules.upload.pojo;

import java.util.List;

public class UploadDBMessage<E,T> {
    private int successInsertNum;
    private int successUpdateNum;
    //读取excel时的错误信息
    private List<E> errorReadingList;
    //读取正常、操作时异常信息
    private List<T> errorOperatingList;

    public int getSuccessInsertNum() {
        return successInsertNum;
    }

    public void setSuccessInsertNum(int successInsertNum) {
        this.successInsertNum = successInsertNum;
    }

    public int getSuccessUpdateNum() {
        return successUpdateNum;
    }

    public void setSuccessUpdateNum(int successUpdateNum) {
        this.successUpdateNum = successUpdateNum;
    }

    public List<E> getErrorReadingList() {
        return errorReadingList;
    }

    public void setErrorReadingList(List<E> errorReadingList) {
        this.errorReadingList = errorReadingList;
    }

    public List<T> getErrorOperatingList() {
        return errorOperatingList;
    }

    public void setErrorOperatingList(List<T> errorOperatingList) {
        this.errorOperatingList = errorOperatingList;
    }
}
