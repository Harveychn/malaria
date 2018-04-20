package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.List;

public class Cluster {
    private String diseaseName;
    private List<String> yearList;
    private List<List<ClusterProvince>> clusterProvinceLists;

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

    public List<List<ClusterProvince>> getClusterProvinceLists() {
        return clusterProvinceLists;
    }

    public void setClusterProvinceLists(List<List<ClusterProvince>> clusterProvinceLists) {
        this.clusterProvinceLists = clusterProvinceLists;
    }
}
