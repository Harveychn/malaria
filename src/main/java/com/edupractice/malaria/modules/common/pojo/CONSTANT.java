package com.edupractice.malaria.modules.common.pojo;
/**
 * 一些常量定义
 */
public class CONSTANT {
    private static final String UPLOADFILEPATH = "D:/edu";

    private static final char SEX_MALE = '男';
    private static final char SEX_FEMALE = '女';
    //性别不明
    private static final char SEX_UNKNOWN = ' ';
    //已终审卡
    private static final char PASS_JUDGESTATUS = '1';
    //其他审核状态
    private static final char OTHER_JUDGESTATUS = '0';
    //卡片状态--原始卡
    private static final char ORIGIN_CARDSTATUS = '0';
    //卡片状态--订正卡
    private static final char REVISED_CARDSTATUS = '1';
    //卡片状态--未知
    private static final char UNKNOWN_CARDSTATUS = 'u';

    public static String getUPLOADFILEPATH() {
        return UPLOADFILEPATH;
    }

    public static char getSexMale() {
        return SEX_MALE;
    }

    public static char getSexFemale() {
        return SEX_FEMALE;
    }

    public static char getSexUnknown() {
        return SEX_UNKNOWN;
    }

    public static char getPassJudgestatus() {
        return PASS_JUDGESTATUS;
    }

    public static char getOtherJudgestatus() {
        return OTHER_JUDGESTATUS;
    }

    public static char getOriginCardstatus() {
        return ORIGIN_CARDSTATUS;
    }

    public static char getRevisedCardstatus() {
        return REVISED_CARDSTATUS;
    }

    public static char getUnknownCardstatus() {
        return UNKNOWN_CARDSTATUS;
    }
}
