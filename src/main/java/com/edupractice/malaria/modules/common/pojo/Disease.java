package com.edupractice.malaria.modules.common.pojo;

public class Disease {
    private Integer diseaseId;

    private String diseaseName;

    public Disease(Integer diseaseId, String diseaseName) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
    }

    public Disease() {
        super();
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }
}