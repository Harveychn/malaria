package com.edupractice.malaria.modules.common.domain;

import java.io.StringReader;

/**
 * creator : jianeneng zhang
 * time : 17-10-16 21:29
 * function
 */
public class Indicator {

    private String fieldName;
    private String belongTable;
    private String tableAlias;
    private String displayName;
    private Byte downloadable;
    private String category;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getBelongTable() {
        return belongTable;
    }

    public void setBelongTable(String belongTable) {
        this.belongTable = belongTable;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Byte getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(Byte downloadable) {
        this.downloadable = downloadable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
