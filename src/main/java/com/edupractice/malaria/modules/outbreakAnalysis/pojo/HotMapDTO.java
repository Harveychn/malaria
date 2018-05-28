package com.edupractice.malaria.modules.outbreakAnalysis.pojo;

/**
 * 热力图数据传输对象
 */
public class HotMapDTO {
    private String diseaseName;
    private String year;
    private String career;

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
