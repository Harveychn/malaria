package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.List;
import java.util.Map;

public class CareerClusterProv {
    private String province;
    private Map<String,Integer> careerValue;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Map<String, Integer> getCareerValue() {
        return careerValue;
    }

    public void setCareerValue(Map<String, Integer> careerValue) {
        this.careerValue = careerValue;
    }
}
