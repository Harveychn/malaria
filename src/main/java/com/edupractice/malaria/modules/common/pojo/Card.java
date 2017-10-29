package com.edupractice.malaria.modules.common.pojo;

import java.util.Date;

public class Card {
    private Integer cardId;

    private String cardNum;

    private String cardStatus;

    private Integer year;

    private Integer patientId;

    private Integer diseaseId;

    private Integer categoryId1;

    private Integer categoryId2;

    private Date illDate;

    private Date confirmDate;

    private Date deathDate;

    private Date fillCardDate;

    private Integer fillCardDocId;

    private Integer reportUnitId;

    private Date reportInputDate;

    private Integer inputUserId;

    private String countyJudgeDate;

    private String localJudgeDate;

    private String provinceJudgeDate;

    private String judgeStatus;

    private String diseasePreRevised;

    private Date revisedReportDate;

    private Date revisedFinalJudgeDate;

    private Integer revisedUserId;

    private Date delDate;

    private Integer delUserId;

    private String delReason;

    private String notes;

    public Card(Integer cardId, String cardNum, String cardStatus, Integer year, Integer patientId, Integer diseaseId, Integer categoryId1, Integer categoryId2, Date illDate, Date confirmDate, Date deathDate, Date fillCardDate, Integer fillCardDocId, Integer reportUnitId, Date reportInputDate, Integer inputUserId, String countyJudgeDate, String localJudgeDate, String provinceJudgeDate, String judgeStatus, String diseasePreRevised, Date revisedReportDate, Date revisedFinalJudgeDate, Integer revisedUserId, Date delDate, Integer delUserId, String delReason, String notes) {
        this.cardId = cardId;
        this.cardNum = cardNum;
        this.cardStatus = cardStatus;
        this.year = year;
        this.patientId = patientId;
        this.diseaseId = diseaseId;
        this.categoryId1 = categoryId1;
        this.categoryId2 = categoryId2;
        this.illDate = illDate;
        this.confirmDate = confirmDate;
        this.deathDate = deathDate;
        this.fillCardDate = fillCardDate;
        this.fillCardDocId = fillCardDocId;
        this.reportUnitId = reportUnitId;
        this.reportInputDate = reportInputDate;
        this.inputUserId = inputUserId;
        this.countyJudgeDate = countyJudgeDate;
        this.localJudgeDate = localJudgeDate;
        this.provinceJudgeDate = provinceJudgeDate;
        this.judgeStatus = judgeStatus;
        this.diseasePreRevised = diseasePreRevised;
        this.revisedReportDate = revisedReportDate;
        this.revisedFinalJudgeDate = revisedFinalJudgeDate;
        this.revisedUserId = revisedUserId;
        this.delDate = delDate;
        this.delUserId = delUserId;
        this.delReason = delReason;
        this.notes = notes;
    }

    public Card() {
        super();
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus == null ? null : cardStatus.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Date getIllDate() {
        return illDate;
    }

    public void setIllDate(Date illDate) {
        this.illDate = illDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Date getFillCardDate() {
        return fillCardDate;
    }

    public void setFillCardDate(Date fillCardDate) {
        this.fillCardDate = fillCardDate;
    }

    public Integer getFillCardDocId() {
        return fillCardDocId;
    }

    public void setFillCardDocId(Integer fillCardDocId) {
        this.fillCardDocId = fillCardDocId;
    }

    public Integer getReportUnitId() {
        return reportUnitId;
    }

    public void setReportUnitId(Integer reportUnitId) {
        this.reportUnitId = reportUnitId;
    }

    public Date getReportInputDate() {
        return reportInputDate;
    }

    public void setReportInputDate(Date reportInputDate) {
        this.reportInputDate = reportInputDate;
    }

    public Integer getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(Integer inputUserId) {
        this.inputUserId = inputUserId;
    }

    public String getCountyJudgeDate() {
        return countyJudgeDate;
    }

    public void setCountyJudgeDate(String countyJudgeDate) {
        this.countyJudgeDate = countyJudgeDate == null ? null : countyJudgeDate.trim();
    }

    public String getLocalJudgeDate() {
        return localJudgeDate;
    }

    public void setLocalJudgeDate(String localJudgeDate) {
        this.localJudgeDate = localJudgeDate == null ? null : localJudgeDate.trim();
    }

    public String getProvinceJudgeDate() {
        return provinceJudgeDate;
    }

    public void setProvinceJudgeDate(String provinceJudgeDate) {
        this.provinceJudgeDate = provinceJudgeDate == null ? null : provinceJudgeDate.trim();
    }

    public String getJudgeStatus() {
        return judgeStatus;
    }

    public void setJudgeStatus(String judgeStatus) {
        this.judgeStatus = judgeStatus == null ? null : judgeStatus.trim();
    }

    public String getDiseasePreRevised() {
        return diseasePreRevised;
    }

    public void setDiseasePreRevised(String diseasePreRevised) {
        this.diseasePreRevised = diseasePreRevised == null ? null : diseasePreRevised.trim();
    }

    public Date getRevisedReportDate() {
        return revisedReportDate;
    }

    public void setRevisedReportDate(Date revisedReportDate) {
        this.revisedReportDate = revisedReportDate;
    }

    public Date getRevisedFinalJudgeDate() {
        return revisedFinalJudgeDate;
    }

    public void setRevisedFinalJudgeDate(Date revisedFinalJudgeDate) {
        this.revisedFinalJudgeDate = revisedFinalJudgeDate;
    }

    public Integer getRevisedUserId() {
        return revisedUserId;
    }

    public void setRevisedUserId(Integer revisedUserId) {
        this.revisedUserId = revisedUserId;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public Integer getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(Integer delUserId) {
        this.delUserId = delUserId;
    }

    public String getDelReason() {
        return delReason;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason == null ? null : delReason.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }
}