package com.edupractice.malaria.modules.common.pojo;

public class MedicalUnit {
    private Integer medicalUnitId;

    private String unitName;

    private String uniteType;

    private String uniteAreaCode;

    public MedicalUnit(Integer medicalUnitId, String unitName, String uniteType, String uniteAreaCode) {
        this.medicalUnitId = medicalUnitId;
        this.unitName = unitName;
        this.uniteType = uniteType;
        this.uniteAreaCode = uniteAreaCode;
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

    public String getUniteType() {
        return uniteType;
    }

    public void setUniteType(String uniteType) {
        this.uniteType = uniteType == null ? null : uniteType.trim();
    }

    public String getUniteAreaCode() {
        return uniteAreaCode;
    }

    public void setUniteAreaCode(String uniteAreaCode) {
        this.uniteAreaCode = uniteAreaCode == null ? null : uniteAreaCode.trim();
    }
}