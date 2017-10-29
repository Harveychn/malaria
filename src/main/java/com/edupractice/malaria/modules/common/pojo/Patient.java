package com.edupractice.malaria.modules.common.pojo;

import java.util.Date;

public class Patient {
    private Integer patientId;

    private String patientName;

    private String sex;

    private String age;

    private Date birthday;

    private String workUnit;

    private String tel;

    private Integer addressId;

    private Integer careerId;

    private Integer belongsId;

    public Patient(Integer patientId, String patientName, String sex, String age, Date birthday, String workUnit, String tel, Integer addressId, Integer careerId, Integer belongsId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.workUnit = workUnit;
        this.tel = tel;
        this.addressId = addressId;
        this.careerId = careerId;
        this.belongsId = belongsId;
    }

    public Patient() {
        super();
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCareerId() {
        return careerId;
    }

    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
    }

    public Integer getBelongsId() {
        return belongsId;
    }

    public void setBelongsId(Integer belongsId) {
        this.belongsId = belongsId;
    }
}