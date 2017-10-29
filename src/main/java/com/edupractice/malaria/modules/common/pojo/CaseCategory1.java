package com.edupractice.malaria.modules.common.pojo;

public class CaseCategory1 {
    private Integer categoryId1;

    private String category1Name;

    public CaseCategory1(Integer categoryId1, String category1Name) {
        this.categoryId1 = categoryId1;
        this.category1Name = category1Name;
    }

    public CaseCategory1() {
        super();
    }

    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public String getCategory1Name() {
        return category1Name;
    }

    public void setCategory1Name(String category1Name) {
        this.category1Name = category1Name == null ? null : category1Name.trim();
    }
}