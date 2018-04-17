package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.Map;

public class AgeClusterProv {
    private String province;
    private Map<String,Integer> ageValue;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Map<String, Integer> getAgeValue() {
        return ageValue;
    }

    public void setAgeValue(Map<String, Integer> ageValue) {
        this.ageValue = ageValue;
    }
}
