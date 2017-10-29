package com.edupractice.malaria.modules.common.pojo;

public class Doctor {
    private Integer doctorId;

    private String doctorName;

    private Integer medicalUnitId;

    public Doctor(Integer doctorId, String doctorName, Integer medicalUnitId) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.medicalUnitId = medicalUnitId;
    }

    public Doctor() {
        super();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public Integer getMedicalUnitId() {
        return medicalUnitId;
    }

    public void setMedicalUnitId(Integer medicalUnitId) {
        this.medicalUnitId = medicalUnitId;
    }
}