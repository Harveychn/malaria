package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.List;

public class AgeCluster {
    private String diseaseName;
    private List<String> yearList;
    private List<List<AgeClusterProv>> AgeClusterProvList;

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<List<AgeClusterProv>> getAgeClusterProvList() {
        return AgeClusterProvList;
    }

    public void setAgeClusterProvList(List<List<AgeClusterProv>> ageClusterProvList) {
        AgeClusterProvList = ageClusterProvList;
    }
}
