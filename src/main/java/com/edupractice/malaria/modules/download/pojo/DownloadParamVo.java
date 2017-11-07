package com.edupractice.malaria.modules.download.pojo;

import java.util.List;

/**
 * 前段提交参数封装类
 * 包括
 * 1.用户选择的数据字段
 * 2.地区
 * 3.时间区间
 * 4.年龄区间
 * 5.性别
 */
public class DownloadParamVo {
    private String category;
    //用户选择的展示数据字段
    private List<String> selectedName;
    //数据地区
    private String addrLevel1;
    private String addrLevel2;
    private String addrLevel3;
    private String addrLevel4;
    //时间区间
    private int beginYear;
    private int endYear;
    //年龄区间
    private int minAge;
    private int maxAge;
    //性别：        0:全部        1：男        2：女
    private int sex;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(List<String> selectedName) {
        this.selectedName = selectedName;
    }

    public String getAddrLevel1() {
        return addrLevel1;
    }

    public void setAddrLevel1(String addrLevel1) {
        this.addrLevel1 = addrLevel1;
    }

    public String getAddrLevel2() {
        return addrLevel2;
    }

    public void setAddrLevel2(String addrLevel2) {
        this.addrLevel2 = addrLevel2;
    }

    public String getAddrLevel3() {
        return addrLevel3;
    }

    public void setAddrLevel3(String addrLevel3) {
        this.addrLevel3 = addrLevel3;
    }

    public String getAddrLevel4() {
        return addrLevel4;
    }

    public void setAddrLevel4(String addrLevel4) {
        this.addrLevel4 = addrLevel4;
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
