package com.edupractice.malaria.modules.upload.pojo;

import java.util.List;

public class Data2DBInfo {
    private List<Integer> errorRowsCode;
    private int savedRowsTotal;

    public List<Integer> getErrorRowsCode() {
        return errorRowsCode;
    }

    public void setErrorRowsCode(List<Integer> errorRowsCode) {
        this.errorRowsCode = errorRowsCode;
    }

    public int getSavedRowsTotal() {
        return savedRowsTotal;
    }

    public void setSavedRowsTotal(int savedRowsTotal) {
        this.savedRowsTotal = savedRowsTotal;
    }
}
