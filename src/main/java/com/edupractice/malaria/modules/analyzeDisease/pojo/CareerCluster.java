package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.List;

public class CareerCluster {
    private String diseaseName;
    private List<String> yearList;
    private List<List<CareerClusterProv>> careerClusterProvList;

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

    public List<List<CareerClusterProv>> getCareerClusterProvList() {
        return careerClusterProvList;
    }

    public void setCareerClusterProvList(List<List<CareerClusterProv>> careerClusterProvList) {
        this.careerClusterProvList = careerClusterProvList;
    }

    public String toString(){
        return "疾病名:"+diseaseName
                +"年份"+yearList;
    }

}
