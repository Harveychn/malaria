package com.edupractice.malaria.modules.common.domain;

/**
 * creator : jianeneng zhang
 * time : 17-10-16 21:49
 * function
 */
public class FourLevelLinkage {
    private Integer id;
    private String name;
    private Byte level;
    private Integer upld;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getUpld() {
        return upld;
    }

    public void setUpld(Integer upld) {
        this.upld = upld;
    }
}
