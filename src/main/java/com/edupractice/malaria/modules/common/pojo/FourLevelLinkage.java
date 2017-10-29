package com.edupractice.malaria.modules.common.pojo;

public class FourLevelLinkage {
    private Integer id;

    private String name;

    private Byte level;

    private Integer upid;

    public FourLevelLinkage(Integer id, String name, Byte level, Integer upid) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.upid = upid;
    }

    public FourLevelLinkage() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }
}