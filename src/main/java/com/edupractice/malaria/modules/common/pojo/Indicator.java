package com.edupractice.malaria.modules.common.pojo;

public class Indicator extends IndicatorKey {
    private String tableAlias;

    private String displayName;

    private Byte downable;

    private String category;

    public Indicator(String fieldName, String belongTable, String tableAlias, String displayName, Byte downable, String category) {
        super(fieldName, belongTable);
        this.tableAlias = tableAlias;
        this.displayName = displayName;
        this.downable = downable;
        this.category = category;
    }

    public Indicator() {
        super();
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias == null ? null : tableAlias.trim();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public Byte getDownable() {
        return downable;
    }

    public void setDownable(Byte downable) {
        this.downable = downable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}