package com.edupractice.malaria.modules.analyzeDisease.pojo;

import java.util.Map;

public class ClusterProvince {
    private String province;
    private Map<String, Float> patientNum;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Map<String, Float> getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(Map<String, Float> patientNum) {
        this.patientNum = patientNum;
    }
}
