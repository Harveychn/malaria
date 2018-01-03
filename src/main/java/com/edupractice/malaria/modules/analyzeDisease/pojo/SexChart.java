package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.List;

public class SexChart {
    private String disease;
    private List<String> yearList;
    private List<String> sexList;
    private List<Integer> valuesList;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<String> getSexList() {
        return sexList;
    }

    public void setSexList(List<String> sexList) {
        this.sexList = sexList;
    }

    public List<Integer> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<Integer> valuesList) {
        this.valuesList = valuesList;
    }
}
