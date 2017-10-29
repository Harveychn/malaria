package com.edupractice.malaria.modules.common.pojo;

public class Career {
    private Integer careerId;

    private String career;

    public Career(Integer careerId, String career) {
        this.careerId = careerId;
        this.career = career;
    }

    public Career() {
        super();
    }

    public Integer getCareerId() {
        return careerId;
    }

    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }
}