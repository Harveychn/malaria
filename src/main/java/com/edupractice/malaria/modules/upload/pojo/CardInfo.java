package com.edupractice.malaria.modules.upload.pojo;

import java.util.Date;

//上传的疟疾信息Excel表格拥有的表项
public class CardInfo {
    private int year;
    // 卡片ID
    private int cardID;
    // 卡片编号
    private String cardNum;
    // 卡片状态
    private char cardStatus;
    // 患者姓名
    private String patientName;
    // 性别
    private char sex;
    // 出生日期
    private Date birthday;
    // 年龄
    private String age;
    // 患者工作单位
    private String workUnit;
    // 联系电话
    private String tel;
    // 病人属于
    private String belongsLevel;
    // 现住地址国标
    private int addressNationID;
    // 现住详细地址
    private String address;
    // 职业
    private String career;
    // 病例分类
    private String caseCategory1Name;
    // 病例分类2
    private String caseCategory2Name;
    // 发病日期
    private Date illDate;
    // 诊断时间
    private Date confirmDate;
    // 死亡日期
    private Date deathDate;
    // 疾病名称
    private String diseaseName;
    // 订正前病种
    private String diseasePreRevised;
    // 填卡医生
    private String fillCardDoc;
    // 医生填卡日期
    private Date fillCardDate;
    // 报告单位地区编码
    private String reportUnitAreaCode;
    // 报告单位
    private String reportUnit;
    // 单位类型
    private String unitType;
    // 报告卡录入时间
    private Date reportInputDate;
    // 录卡用户
    private String inputUser;
    // 录卡用户所属单位
    private String inputUserUnit;
    // 县区审核时间
    private String countyJudgeDate;
    // 地市审核时间
    private String localJudgeDate;
    // 省市审核时间
    private String provinceJudgeDate;
    // 审核状态
    private char judgeStatus;
    // 订正报告时间
    private Date revisedReportDate;
    // 订正终审时间
    private Date revisedFinalJudgeDate;
    // 终审死亡时间
    private Date deathFinalJudgeDate;
    // 订正用户
    private String revisedUser;
    // 订正用户所属单位
    private String revisedUserUnit;
    // 删除时间
    private Date delDate;
    // 删除用户
    private String delUser;
    // 删除用户所属单位
    private String delUserUnit;
    // 删除原因
    private String delReason;
    // 备注
    private String notes;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public char getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(char cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBelongsLevel() {
        return belongsLevel;
    }

    public void setBelongsLevel(String belongsLevel) {
        this.belongsLevel = belongsLevel;
    }

    public int getAddressNationID() {
        return addressNationID;
    }

    public void setAddressNationID(int addressNationID) {
        this.addressNationID = addressNationID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getCaseCategory1Name() {
        return caseCategory1Name;
    }

    public void setCaseCategory1Name(String caseCategory1Name) {
        this.caseCategory1Name = caseCategory1Name;
    }

    public String getCaseCategory2Name() {
        return caseCategory2Name;
    }

    public void setCaseCategory2Name(String caseCategory2Name) {
        this.caseCategory2Name = caseCategory2Name;
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

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseasePreRevised() {
        return diseasePreRevised;
    }

    public void setDiseasePreRevised(String diseasePreRevised) {
        this.diseasePreRevised = diseasePreRevised;
    }

    public String getFillCardDoc() {
        return fillCardDoc;
    }

    public void setFillCardDoc(String fillCardDoc) {
        this.fillCardDoc = fillCardDoc;
    }

    public Date getFillCardDate() {
        return fillCardDate;
    }

    public void setFillCardDate(Date fillCardDate) {
        this.fillCardDate = fillCardDate;
    }

    public String getReportUnitAreaCode() {
        return reportUnitAreaCode;
    }

    public void setReportUnitAreaCode(String reportUnitAreaCode) {
        this.reportUnitAreaCode = reportUnitAreaCode;
    }

    public String getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(String reportUnit) {
        this.reportUnit = reportUnit;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Date getReportInputDate() {
        return reportInputDate;
    }

    public void setReportInputDate(Date reportInputDate) {
        this.reportInputDate = reportInputDate;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public String getInputUserUnit() {
        return inputUserUnit;
    }

    public void setInputUserUnit(String inputUserUnit) {
        this.inputUserUnit = inputUserUnit;
    }

    public String getCountyJudgeDate() {
        return countyJudgeDate;
    }

    public void setCountyJudgeDate(String countyJudgeDate) {
        this.countyJudgeDate = countyJudgeDate;
    }

    public String getLocalJudgeDate() {
        return localJudgeDate;
    }

    public void setLocalJudgeDate(String localJudgeDate) {
        this.localJudgeDate = localJudgeDate;
    }

    public String getProvinceJudgeDate() {
        return provinceJudgeDate;
    }

    public void setProvinceJudgeDate(String provinceJudgeDate) {
        this.provinceJudgeDate = provinceJudgeDate;
    }

    public char getJudgeStatus() {
        return judgeStatus;
    }

    public void setJudgeStatus(char judgeStatus) {
        this.judgeStatus = judgeStatus;
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

    public Date getDeathFinalJudgeDate() {
        return deathFinalJudgeDate;
    }

    public void setDeathFinalJudgeDate(Date deathFinalJudgeDate) {
        this.deathFinalJudgeDate = deathFinalJudgeDate;
    }

    public String getRevisedUser() {
        return revisedUser;
    }

    public void setRevisedUser(String revisedUser) {
        this.revisedUser = revisedUser;
    }

    public String getRevisedUserUnit() {
        return revisedUserUnit;
    }

    public void setRevisedUserUnit(String revisedUserUnit) {
        this.revisedUserUnit = revisedUserUnit;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public String getDelUser() {
        return delUser;
    }

    public void setDelUser(String delUser) {
        this.delUser = delUser;
    }

    public String getDelUserUnit() {
        return delUserUnit;
    }

    public void setDelUserUnit(String delUserUnit) {
        this.delUserUnit = delUserUnit;
    }

    public String getDelReason() {
        return delReason;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
