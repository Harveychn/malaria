package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.List;

public class AgeGroupChart {
    private String disease;
    private List<String> yearList;
    private List<List> ageGroupList;
    private List<List> valuesList;

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

    public List<List> getAgeGroupList() {
        return ageGroupList;
    }

    public void setAgeGroupList(List<List> ageGroupList) {
        this.ageGroupList = ageGroupList;
    }

    public List<List> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<List> valuesList) {
        this.valuesList = valuesList;
    }
}
