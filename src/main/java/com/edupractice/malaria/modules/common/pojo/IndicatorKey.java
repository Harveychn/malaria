package com.edupractice.malaria.modules.common.pojo;

public class IndicatorKey {
    private String fieldName;

    private String belongTable;

    public IndicatorKey(String fieldName, String belongTable) {
        this.fieldName = fieldName;
        this.belongTable = belongTable;
    }

    public IndicatorKey() {
        super();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getBelongTable() {
        return belongTable;
    }

    public void setBelongTable(String belongTable) {
        this.belongTable = belongTable == null ? null : belongTable.trim();
    }
}