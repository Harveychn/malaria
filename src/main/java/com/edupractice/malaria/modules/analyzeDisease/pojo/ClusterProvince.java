package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.Map;

public class ClusterProvince {
    private String province;
    private Map<String,Integer> patientNum;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Map<String, Integer> getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(Map<String, Integer> patientNum) {
        this.patientNum = patientNum;
    }
}
