package com.edupractice.malaria.modules.download.pojo;

import java.util.List;

public class GetDownData {
    private List<FromTable> fromTables;
    private List<SelectField> selectFields;
    //数据地区
    private String location;
    //时间区间
    private int beginYear;
    private int endYear;
    //年龄区间
    private int minAge;
    private int maxAge;
    /*性别：
        0:全部
        1：男
        2：女
    */
    private int sex;

    public List<FromTable> getFromTables() {
        return fromTables;
    }

    public void setFromTables(List<FromTable> fromTables) {
        this.fromTables = fromTables;
    }

    public List<SelectField> getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(List<SelectField> selectFields) {
        this.selectFields = selectFields;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(int beginYear) {
        this.beginYear = beginYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
