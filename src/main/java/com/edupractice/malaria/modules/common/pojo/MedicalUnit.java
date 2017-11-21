package com.edupractice.malaria.modules.common.pojo;

public class MedicalUnit {
    private Integer medicalUnitId;

    private String unitName;

    private String unitType;

    private String unitAreaCode;

    public MedicalUnit(Integer medicalUnitId, String unitName, String unitType, String unitAreaCode) {
        this.medicalUnitId = medicalUnitId;
        this.unitName = unitName;
        this.unitType = unitType;
        this.unitAreaCode = unitAreaCode;
    }

    public MedicalUnit() {
        super();
    }

    public Integer getMedicalUnitId() {
        return medicalUnitId;
    }

    public void setMedicalUnitId(Integer medicalUnitId) {
        this.medicalUnitId = medicalUnitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getUnitAreaCode() {
        return unitAreaCode;
    }

    public void setUnitAreaCode(String unitAreaCode) {
        this.unitAreaCode = unitAreaCode == null ? null : unitAreaCode.trim();
    }
}