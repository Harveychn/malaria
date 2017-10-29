package com.edupractice.malaria.modules.common.pojo;

public class PatientBelongs {
    private Integer belongsId;

    private String belongsLevel;

    public PatientBelongs(Integer belongsId, String belongsLevel) {
        this.belongsId = belongsId;
        this.belongsLevel = belongsLevel;
    }

    public PatientBelongs() {
        super();
    }

    public Integer getBelongsId() {
        return belongsId;
    }

    public void setBelongsId(Integer belongsId) {
        this.belongsId = belongsId;
    }

    public String getBelongsLevel() {
        return belongsLevel;
    }

    public void setBelongsLevel(String belongsLevel) {
        this.belongsLevel = belongsLevel == null ? null : belongsLevel.trim();
    }
}