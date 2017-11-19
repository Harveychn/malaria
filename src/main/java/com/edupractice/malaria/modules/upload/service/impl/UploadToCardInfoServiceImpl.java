package com.edupractice.malaria.modules.upload.service.impl;

import com.edupractice.malaria.modules.common.dao.*;
import com.edupractice.malaria.modules.common.pojo.*;
import com.edupractice.malaria.modules.upload.pojo.CardInfo;
import com.edupractice.malaria.modules.upload.pojo.ErrorCardInfo;
import com.edupractice.malaria.modules.upload.pojo.RowDataSorted;
import com.edupractice.malaria.modules.upload.pojo.Upload2DBInfo;
import com.edupractice.malaria.modules.upload.service.UploadToCardInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class UploadToCardInfoServiceImpl implements UploadToCardInfoService {
    @Resource
    private CardMapper cardInformationMapper;
    @Resource
    private CaseCategory1Mapper caseCategory1Mapper;
    @Resource
    private CaseCategory2Mapper caseCategory2Mapper;
    @Resource
    private DiseaseMapper diseaseMapper;
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private PatientBelongsMapper patientBelongsMapper;
    @Resource
    private CareerMapper careerMapper;
    @Resource
    private AddressGeocodeMapper addressGeocodeMapper;
    @Resource
    private MedicalUnitMapper medicalUnitMapper;
    @Resource
    private DoctorMapper doctorMapper;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UploadToCardInfoServiceImpl.class);

    /**
     * 对Card表中行数据，每个单元数据进行读取处理，返回正确或错误信息
     *
     * @param cellValues
     * @param fileName
     * @return
     * @throws Exception
     */
    public RowDataSorted<CardInfo, ErrorCardInfo> cardInformationCellData(Map<String, String> cellValues, String fileName) throws Exception {
        RowDataSorted<CardInfo, ErrorCardInfo> rowDataSorted = new RowDataSorted<>();
        DateFormat df = DateFormat.getDateInstance();
        Date nullDate = df.parse("0000-00-00");
        try {
            CardInfo cardInfo = new CardInfo();
            cardInfo.setYear(Integer.parseInt(fileName));
            cardInfo.setCardID(Integer.parseInt(cellValues.get(CARDCONSTANT.getCardId())));
            cardInfo.setCardNum(cellValues.get(CARDCONSTANT.getCardNum()));
            if(cellValues.get(CARDCONSTANT.getCardStatus()).equals("原始卡")){
                cardInfo.setCardStatus(CONSTANT.getOriginCardstatus());
            }else if (cellValues.get(CARDCONSTANT.getCardStatus()).equals("订正卡")){
                cardInfo.setCardStatus(CONSTANT.getRevisedCardstatus());
            }else{
                cardInfo.setCardStatus(CONSTANT.getUnknownCardstatus());
            }
            cardInfo.setPatientName(cellValues.get(CARDCONSTANT.getPatientName()));
            if (cellValues.get(CARDCONSTANT.getSEX()).equals("男")) {
                cardInfo.setSex(CONSTANT.getSexMale());
            } else if (cellValues.get(CARDCONSTANT.getSEX()).equals("女")) {
                cardInfo.setSex(CONSTANT.getSexFemale());
            } else {
                cardInfo.setSex(CONSTANT.getSexUnknown());
            }
            if (!cellValues.get(CARDCONSTANT.getBIRTHDAY()).trim().equals(".")) {
                cardInfo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get(CARDCONSTANT.getBIRTHDAY())));
            } else {
                cardInfo.setBirthday(nullDate);
            }
            cardInfo.setAge(cellValues.get(CARDCONSTANT.getAGE()));
            cardInfo.setWorkUnit(cellValues.get(CARDCONSTANT.getWorkUnit()).trim());

            cardInfo.setTel(cellValues.get(CARDCONSTANT.getTEL()).trim());

            cardInfo.setBelongsLevel(cellValues.get(CARDCONSTANT.getBelongsLevel()));
            cardInfo.setAddressNationID(Integer.parseInt(cellValues.get(CARDCONSTANT.getAddressNationId())));
            cardInfo.setAddress(cellValues.get(CARDCONSTANT.getADDRESS()));
            cardInfo.setCareer(cellValues.get(CARDCONSTANT.getCAREER()));
            cardInfo.setCaseCategory1Name(cellValues.get(CARDCONSTANT.getCasecategory1Name()));
            cardInfo.setCaseCategory2Name(cellValues.get(CARDCONSTANT.getCasecategory2Name()));
            if (!cellValues.get(CARDCONSTANT.getIllDate()).trim().equals(".")) {
                cardInfo.setIllDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get(CARDCONSTANT.getIllDate())));
            } else {
                cardInfo.setIllDate(nullDate);
            }
            if (!cellValues.get(CARDCONSTANT.getConfirmDate()).trim().equals(".")) {
                cardInfo.setConfirmDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get(CARDCONSTANT.getConfirmDate())));
            } else {
                cardInfo.setConfirmDate(nullDate);
            }
            if (!cellValues.get(CARDCONSTANT.getDeathDate()).equals(".")) {
                cardInfo.setDeathDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get(CARDCONSTANT.getDeathDate())));
            } else {
                cardInfo.setDeathDate(nullDate);
            }
            cardInfo.setDiseaseName(cellValues.get(CARDCONSTANT.getDiseaseName()));
            cardInfo.setDiseasePreRevised(cellValues.get(CARDCONSTANT.getDiseasePreRevised()));
            cardInfo.setFillCardDoc(cellValues.get(CARDCONSTANT.getFillCardDoc()));
            if (!cellValues.get(CARDCONSTANT.getFillCardDate()).equals(".")) {
                cardInfo.setFillCardDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get(CARDCONSTANT.getFillCardDate())));
            } else {
                cardInfo.setFillCardDate(nullDate);
            }
            cardInfo.setReportUnitAreaCode(cellValues.get(CARDCONSTANT.getReportUnitAreaCode()));
            cardInfo.setReportUnit(cellValues.get(CARDCONSTANT.getReportUnit()));
            cardInfo.setUnitType(cellValues.get(CARDCONSTANT.getUnitType()));
            if (!cellValues.get(CARDCONSTANT.getReportInputDate()).equals(".")) {
                cardInfo.setReportInputDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get(CARDCONSTANT.getReportInputDate())));
            } else {
                cardInfo.setReportInputDate(nullDate);
            }
            cardInfo.setInputUser(cellValues.get(CARDCONSTANT.getInputUser()));
            cardInfo.setInputUserUnit(cellValues.get(CARDCONSTANT.getInputUserUnit()));
            cardInfo.setCountyJudgeDate(cellValues.get(CARDCONSTANT.getCountyJudgeDate()));
            cardInfo.setLocalJudgeDate(cellValues.get(CARDCONSTANT.getLocalJudgeDate()));
            cardInfo.setProvinceJudgeDate(cellValues.get(CARDCONSTANT.getProvinceJudgeDate()));
            if (cellValues.get(CARDCONSTANT.getJudgeStatus()).equals("已终审卡")) {
                cardInfo.setJudgeStatus(CONSTANT.getPassJudgestatus());
            } else {
                cardInfo.setJudgeStatus(CONSTANT.getOtherJudgestatus());
            }
            if (!cellValues.get(CARDCONSTANT.getRevisedReportDate()).equals(".")) {
                cardInfo.setRevisedReportDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get(CARDCONSTANT.getRevisedReportDate())));
            } else {
                cardInfo.setRevisedReportDate(nullDate);
            }
            if (!cellValues.get(CARDCONSTANT.getRevisedFinalJudgeDate()).equals(".")) {
                cardInfo.setRevisedFinalJudgeDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get(CARDCONSTANT.getRevisedFinalJudgeDate())));
            } else {
                cardInfo.setRevisedFinalJudgeDate(nullDate);
            }
            if (!cellValues.get(CARDCONSTANT.getRevisedFinalJudgeDate()).equals(".")) {
                cardInfo.setDeathFinalJudgeDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get(CARDCONSTANT.getRevisedFinalJudgeDate())));
            } else {
                cardInfo.setDeathFinalJudgeDate(nullDate);
            }
            cardInfo.setRevisedUser(cellValues.get(CARDCONSTANT.getRevisedUser()));
            cardInfo.setRevisedUserUnit(cellValues.get(CARDCONSTANT.getRevisedUserUnit()));
            if (!cellValues.get(CARDCONSTANT.getDelDate()).equals(".")) {
                cardInfo.setDelDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get(CARDCONSTANT.getDelDate())));
            } else {
                cardInfo.setDelDate(nullDate);
            }
            cardInfo.setDelUser(cellValues.get(CARDCONSTANT.getDelUser()));
            cardInfo.setDelUserUnit(cellValues.get(CARDCONSTANT.getDelUserUnit()));
            cardInfo.setDelReason(cellValues.get(CARDCONSTANT.getDelReason()));
            cardInfo.setNotes(cellValues.get(CARDCONSTANT.getNOTES()));

            rowDataSorted.setHasError(Boolean.FALSE);
            rowDataSorted.setCorrectData(cardInfo);
        } catch (NumberFormatException e) {
            logger.error("NumberFormatException: " + e.getMessage());
            ErrorCardInfo errorCardInform = dealCardError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        } catch (ParseException e) {
            logger.error("ParseException: " + e.getMessage());
            ErrorCardInfo errorCardInform = dealCardError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            ErrorCardInfo errorCardInform = dealCardError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        }
        return rowDataSorted;
    }


    /**
     * 用于提取Card不符合格式的、错误的数据
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private ErrorCardInfo dealCardError(Map<String, String> cellValues) {
        ErrorCardInfo errorCardInfo = new ErrorCardInfo();
        errorCardInfo.setYear(cellValues.get("数据年份"));
        errorCardInfo.setCardID(cellValues.get("卡片ID"));
        errorCardInfo.setCardNum(cellValues.get("卡片编号"));
        errorCardInfo.setCardStatus(cellValues.get("卡片状态"));
        errorCardInfo.setPatientName(cellValues.get("患者姓名"));
        errorCardInfo.setSex(cellValues.get("性别"));
        errorCardInfo.setBirthday(cellValues.get("出生日期"));
        errorCardInfo.setAge(cellValues.get("年龄"));
        errorCardInfo.setWorkUnit(cellValues.get("患者工作单位"));
        errorCardInfo.setTel(cellValues.get("联系电话"));
        errorCardInfo.setBelongsLevel(cellValues.get("病人属于"));
        errorCardInfo.setAddressNationID(cellValues.get("现住地址国标"));
        errorCardInfo.setAddress(cellValues.get("现住详细地址"));
        errorCardInfo.setCareer(cellValues.get("职业"));
        errorCardInfo.setCaseCategory1Name(cellValues.get("病例分类"));
        errorCardInfo.setCaseCategory2Name(cellValues.get("病例分类2"));
        errorCardInfo.setIllDate(cellValues.get("发病日期"));
        errorCardInfo.setConfirmDate(cellValues.get("诊断时间"));
        errorCardInfo.setDeathDate(cellValues.get("死亡日期"));
        errorCardInfo.setDiseaseName(cellValues.get("疾病名称"));
        errorCardInfo.setDiseasePreRevised(cellValues.get("订正前病种"));
        errorCardInfo.setFillCardDoc(cellValues.get("填卡医生"));
        errorCardInfo.setFillCardDate(cellValues.get("医生填卡日期"));
        errorCardInfo.setReportUnitAreaCode(cellValues.get("报告单位地区编码"));
        errorCardInfo.setReportUnit(cellValues.get("报告单位"));
        errorCardInfo.setUnitType(cellValues.get("单位类型"));
        errorCardInfo.setReportInputDate(cellValues.get("报告卡录入时间"));
        errorCardInfo.setInputUser(cellValues.get("录卡用户"));
        errorCardInfo.setInputUserUnit(cellValues.get("录卡用户所属单位"));
        errorCardInfo.setCountyJudgeDate(cellValues.get("县区审核时间"));
        errorCardInfo.setLocalJudgeDate(cellValues.get("地市审核时间"));
        errorCardInfo.setProvinceJudgeDate(cellValues.get("省市审核时间"));
        errorCardInfo.setJudgeStatus(cellValues.get("审核状态"));
        errorCardInfo.setRevisedReportDate(cellValues.get("订正报告时间"));
        errorCardInfo.setRevisedFinalJudgeDate(cellValues.get("订正终审时间"));
        errorCardInfo.setDeathFinalJudgeDate(cellValues.get("终审死亡时间"));
        errorCardInfo.setRevisedUser(cellValues.get("订正用户"));
        errorCardInfo.setRevisedUserUnit(cellValues.get("订正用户所属单位"));
        errorCardInfo.setDelDate(cellValues.get("删除时间"));
        errorCardInfo.setDelUser(cellValues.get("删除用户"));
        errorCardInfo.setDelUserUnit(cellValues.get("删除用户所属单位"));
        errorCardInfo.setDelReason(cellValues.get("删除原因"));
        errorCardInfo.setNotes(cellValues.get("备注"));

        return errorCardInfo;

    }

    /**
     * 保存正确的行数据到数据库Card中
     *
     * @param rowData
     * @throws Exception
     */
    public Upload2DBInfo saveDataToCardDB(CardInfo rowData) throws Exception {
        Upload2DBInfo upload2DBInfo = new Upload2DBInfo();
        //判断数据库中是否有当前cardID对应的Card记录行
        if (null != cardInformationMapper.selectByPrimaryKey(rowData.getCardID())) {
            upload2DBInfo.setNeedUpdate(true);
            upload2DBInfo.setNeedInsert(false);
        } else {
            upload2DBInfo.setNeedInsert(true);
            upload2DBInfo.setNeedUpdate(false);
        }
        try {
            Card card = new Card();
            card.setCardId(rowData.getCardID());
            card.setCardNum(rowData.getCardNum());
            card.setCardStatus(rowData.getCardStatus() + "");
            card.setYear(rowData.getYear());
            //外键
            // card.setPatientId();
            //card.setDiseaseId();
            // card.setCategoryId1();
            // card.setCategoryId2();
            card.setIllDate(rowData.getIllDate());
            card.setConfirmDate(rowData.getConfirmDate());
            card.setDeathDate(rowData.getDeathDate());
            card.setFillCardDate(rowData.getFillCardDate());
            //card.setFillCardDocId();
            //card.setReportUnitId();
            card.setReportInputDate(rowData.getReportInputDate());
            //card.setInputUserId();
            card.setCountyJudgeDate(rowData.getCountyJudgeDate());
            card.setLocalJudgeDate(rowData.getLocalJudgeDate());
            card.setProvinceJudgeDate(rowData.getProvinceJudgeDate());
            card.setJudgeStatus(rowData.getJudgeStatus() + "");
            card.setDiseasePreRevised(rowData.getDiseasePreRevised());
            card.setRevisedReportDate(rowData.getRevisedReportDate());
            card.setRevisedFinalJudgeDate(rowData.getRevisedFinalJudgeDate());
            //card.setRevisedUserId();
            card.setDelDate(rowData.getDelDate());
            //card.setDelUserId();
            card.setDelReason(rowData.getDelReason());
            card.setNotes(rowData.getNotes());

            //外键
            //patient_id
            PatientExample patientExample = new PatientExample();
            //patient外键address_id
            int addressID = 0;
            AddressGeocodeExample addressGeocodeExample = new AddressGeocodeExample();
            addressGeocodeExample.createCriteria().andAddressEqualTo(rowData.getAddress());
            List<AddressGeocode> addressGeocodeList = addressGeocodeMapper.selectByExample(addressGeocodeExample);
            if (addressGeocodeList.size() > 0) {
                addressID = addressGeocodeList.get(0).getAddressId();
            } else {
                AddressGeocode addressGeocode = new AddressGeocode();
                addressGeocode.setAddress(rowData.getAddress());
                addressGeocode.setAddrNationId(rowData.getAddressNationID());
                if (1 == addressGeocodeMapper.insertSelective(addressGeocode)) {
                    addressID = addressGeocode.getAddressId();
                } else {
                    logger.error("addressGeocodeMapper.insertSelective(addressGeocode) 失败!");
                }
            }
            //patient外键belongs_id
            int belongsID = 0;
            PatientBelongsExample patientBelongsExample = new PatientBelongsExample();
            patientBelongsExample.createCriteria().andBelongsLevelEqualTo(rowData.getBelongsLevel());
            List<PatientBelongs> patientBelongsList = patientBelongsMapper.selectByExample(patientBelongsExample);
            if (0 < patientBelongsList.size()) {
                belongsID = patientBelongsList.get(0).getBelongsId();
            } else {
                PatientBelongs patientBelongs = new PatientBelongs();
                patientBelongs.setBelongsLevel(rowData.getBelongsLevel());
                if (1 == patientBelongsMapper.insertSelective(patientBelongs)) {
                    belongsID = patientBelongs.getBelongsId();
                } else {
                    logger.error("patientBelongsMapper.insertSelective(patientBelongs) 失败!");
                }
            }
            //patient外键career_id
            int careerID = 0;
            CareerExample careerExample = new CareerExample();
            careerExample.createCriteria().andCareerEqualTo(rowData.getCareer());
            List<Career> careerList = careerMapper.selectByExample(careerExample);
            if (0 < careerList.size()) {
                careerID = careerList.get(0).getCareerId();
            } else {
                Career career = new Career();
                career.setCareer(rowData.getCareer());
                if (1 == careerMapper.insertSelective(career)) {
                    careerID = career.getCareerId();
                } else {
                    logger.error("careerMapper.insertSelective(career) 失败!");
                }
            }

            patientExample.createCriteria().andPatientNameEqualTo(rowData.getPatientName())
                    .andSexEqualTo(rowData.getSex() + "")
                    .andAgeEqualTo(rowData.getAge())
                    .andBirthdayEqualTo(rowData.getBirthday())
                    .andWorkUnitEqualTo(rowData.getWorkUnit())
                    .andTelEqualTo(rowData.getTel())
                    .andAddressIdEqualTo(addressID)
                    .andCareerIdEqualTo(careerID)
                    .andBelongsIdEqualTo(belongsID);
            List<Patient> patientList = patientMapper.selectByExample(patientExample);
            if (0 < patientList.size()) {
                card.setPatientId(patientList.get(0).getPatientId());
            } else {
                Patient patient = new Patient();
                patient.setPatientName(rowData.getPatientName());
                patient.setSex(rowData.getSex() + "");
                patient.setAge(rowData.getAge());
                patient.setBirthday(rowData.getBirthday());
                patient.setWorkUnit(rowData.getWorkUnit());
                patient.setTel(rowData.getTel());
                patient.setAddressId(addressID);
                patient.setCareerId(careerID);
                patient.setBelongsId(belongsID);
                if (1 == patientMapper.insertSelective(patient)) {
                    card.setPatientId(patient.getPatientId());
                } else {
                    logger.error("patientMapper.insertSelective(patient) 失败!");
                }
            }

            //disease_id
            DiseaseExample diseaseExample = new DiseaseExample();
            diseaseExample.createCriteria().andDiseaseNameEqualTo(rowData.getDiseaseName());
            List<Disease> diseaseList = diseaseMapper.selectByExample(diseaseExample);
            if (0 < diseaseList.size()) {
                card.setDiseaseId(diseaseList.get(0).getDiseaseId());
            } else {
                Disease inserted = new Disease();
                inserted.setDiseaseName(rowData.getDiseaseName());
                if (1 == diseaseMapper.insertSelective(inserted)) {
                    card.setDiseaseId(inserted.getDiseaseId());
                } else {
                    logger.error("diseaseMapper.insertSelective(inserted) 失败!");
                }
            }

            //category_id1
            CaseCategory1Example caseCategory1Example = new CaseCategory1Example();
            caseCategory1Example.createCriteria().andCategory1NameEqualTo(rowData.getCaseCategory1Name());
            List<CaseCategory1> caseCategory1 = caseCategory1Mapper.selectByExample(caseCategory1Example);
            //若现有数据库中存在，则直接将数据库中的结果插入到card表中
            if (0 < caseCategory1.size()) {
                card.setCategoryId1(caseCategory1.get(0).getCategoryId1());
            } else {
                //数据库中不存在，则将CaseCategory1Name插入到Case_Category1表中
                CaseCategory1 insertCase = new CaseCategory1();
                insertCase.setCategory1Name(rowData.getCaseCategory1Name());
                if (1 == caseCategory1Mapper.insertSelective(insertCase)) {
                    card.setCategoryId1(insertCase.getCategoryId1());
                } else {
                    logger.error("caseCategory1Mapper.insertSelective(insertCase) 失败！");
                }
            }

            //category_id2
            CaseCategory2Example caseCategory2Example = new CaseCategory2Example();
            caseCategory2Example.createCriteria().andCategory2NameEqualTo(rowData.getCaseCategory2Name());
            List<CaseCategory2> caseCategory2List = caseCategory2Mapper.selectByExample(caseCategory2Example);
            if (0 < caseCategory2List.size()) {
                card.setCategoryId2(caseCategory2List.get(0).getCategoryId2());
            } else {
                CaseCategory2 insertCase = new CaseCategory2();
                insertCase.setCategory2Name(rowData.getCaseCategory1Name());
                if (1 == caseCategory2Mapper.insertSelective(insertCase)) {
                    card.setCategoryId2(insertCase.getCategoryId2());
                } else {
                    logger.error("caseCategory2Mapper.insertSelective(insertCase) 失败!");
                }
            }

            //fill_card_doc_id
            MedicalUnit fillCardUnit = new MedicalUnit();
            fillCardUnit.setUnitName(rowData.getReportUnit());
            int fillCardUniteID = getMedicalUniteID(fillCardUnit);
            card.setReportUnitId(fillCardUniteID);
            Doctor fillCardDoc = new Doctor();
            fillCardDoc.setDoctorName(rowData.getFillCardDoc());
            fillCardDoc.setMedicalUnitId(fillCardUniteID);
            card.setFillCardDocId(dealDoctorID(fillCardDoc));

            //input_user_id
            MedicalUnit inputUnite = new MedicalUnit();
            inputUnite.setUnitName(rowData.getInputUserUnit());
            int inputUniteID = getMedicalUniteID(inputUnite);
            Doctor inputDoc = new Doctor();
            inputDoc.setDoctorName(rowData.getInputUser());
            inputDoc.setMedicalUnitId(inputUniteID);
            card.setInputUserId(dealDoctorID(inputDoc));

            //revised_user_id
            MedicalUnit revisedUnite = new MedicalUnit();
            revisedUnite.setUnitName(rowData.getRevisedUserUnit());
            int revisedUniteID = getMedicalUniteID(revisedUnite);
            Doctor revisedDoc = new Doctor();
            revisedDoc.setDoctorName(rowData.getRevisedUser());
            revisedDoc.setMedicalUnitId(revisedUniteID);
            card.setRevisedUserId(dealDoctorID(revisedDoc));

            //del_user_id
            MedicalUnit delUnite = new MedicalUnit();
            delUnite.setUnitName(rowData.getDelUserUnit());
            int delUniteID = getMedicalUniteID(delUnite);
            Doctor delDoc = new Doctor();
            delDoc.setDoctorName(rowData.getDelUser());
            delDoc.setMedicalUnitId(delUniteID);
            card.setDelUserId(dealDoctorID(delDoc));

            if (upload2DBInfo.isNeedUpdate()) {
                CardExample cardInformationExample = new CardExample();
                cardInformationExample.createCriteria().andCardIdEqualTo(rowData.getCardID());
                if (1 == cardInformationMapper.updateByExampleSelective(card, cardInformationExample)) {
                    logger.trace("cardInformation更新cardID为的" + card.getCardId() + "记录  成功 ");
                } else {
                    logger.error("cardInformation更新cardID为的" + card.getCardId() + "记录  失败 ");
                }
            }

            if (upload2DBInfo.isNeedInsert()) {
                if (1 == cardInformationMapper.insert(card)) {
                    logger.trace("cardInformation插入cardID为的" + card.getCardId() + "记录  成功 ");
                } else {
                    logger.error("cardInformation插入cardID为的" + card.getCardId() + "记录  失败 ");
                }
            }
            upload2DBInfo.setSuccessOp(true);
        } catch (SQLException s) {
            upload2DBInfo.setSuccessOp(false);
            logger.error("saveDataToCardDB(CardInform rowData) 数据库操作失败");
            s.printStackTrace();
            return upload2DBInfo;
        } catch (Exception e) {
            upload2DBInfo.setSuccessOp(false);
            e.printStackTrace();
            logger.error("saveDataToCardDB(CardInform rowData)失败 Exception信息：" + e.getMessage());
            return upload2DBInfo;
        }
        return upload2DBInfo;
    }

    /**
     * 获取medical_unite ID值
     *
     * @param medicalUnit
     * @return
     * @throws Exception
     */
    private int getMedicalUniteID(MedicalUnit medicalUnit) throws Exception {
        MedicalUnitExample medicalUnitExample = new MedicalUnitExample();
        //uniteName为unique
        medicalUnitExample.createCriteria().andUnitNameEqualTo(medicalUnit.getUnitName());
        List<MedicalUnit> medicalUnitList = medicalUnitMapper.selectByExample(medicalUnitExample);
        try {
            if (0 < medicalUnitList.size()) {
                return medicalUnitList.get(0).getMedicalUnitId();
            } else {//medical_Unit表没有该记录,此时插入记录
                MedicalUnit insertMedicalUnit = new MedicalUnit();
                insertMedicalUnit.setUnitName(medicalUnit.getUnitName());
                if (1 == medicalUnitMapper.insertSelective(insertMedicalUnit)) {
                    return insertMedicalUnit.getMedicalUnitId();
                } else {
                    logger.error("medicalUnitMapper.insertSelective(insertMedicalUnit) 失败!");
                }
            }
        } catch (Exception e) {
            logger.error("medical_unite插入数据时出现Exception 错误信息：" + e.getMessage());
        }
        return 0;
    }

    /**
     * 获取医生ID
     *
     * @param doctor
     * @return
     * @throws Exception
     */
    private int dealDoctorID(Doctor doctor) throws Exception {
        DoctorExample fillCardDoctorExample = new DoctorExample();
        fillCardDoctorExample.createCriteria().andDoctorNameEqualTo(doctor.getDoctorName())
                .andMedicalUnitIdEqualTo(doctor.getMedicalUnitId());
        List<Doctor> fillCardDocList = doctorMapper.selectByExample(fillCardDoctorExample);
        if (0 < fillCardDocList.size()) {
            return fillCardDocList.get(0).getDoctorId();
        } else {
            Doctor insertDoctor = new Doctor();
            insertDoctor.setDoctorName(doctor.getDoctorName());
            try {
                insertDoctor.setMedicalUnitId(doctor.getMedicalUnitId());
            } catch (Exception e) {
                logger.error("doctor.setMedicalunitid(fillCardUnitID) 错误");
            }
            if (1 == doctorMapper.insertSelective(insertDoctor)) {
                return insertDoctor.getDoctorId();
            } else {
                logger.error("doctorMapper.insert(insertDoctor) 失败!");
            }
        }
        return 0;
    }
}