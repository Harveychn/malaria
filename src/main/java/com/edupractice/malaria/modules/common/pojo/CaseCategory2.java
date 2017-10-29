package com.edupractice.malaria.modules.common.pojo;

public class CaseCategory2 {
    private Integer categoryId2;

    private String category2Name;

    public CaseCategory2(Integer categoryId2, String category2Name) {
        this.categoryId2 = categoryId2;
        this.category2Name = category2Name;
    }

    public CaseCategory2() {
        super();
    }

    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public String getCategory2Name() {
        return category2Name;
    }

    public void setCategory2Name(String category2Name) {
        this.category2Name = category2Name == null ? null : category2Name.trim();
    }
}