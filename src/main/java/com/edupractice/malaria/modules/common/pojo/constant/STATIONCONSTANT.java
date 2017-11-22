package com.edupractice.malaria.modules.common.pojo.constant;

public class STATIONCONSTANT {
    private static final String STATION_ID = "区站号";
    private static final String STATION_NAME = "台站名称";
    private static final String PROVINCES = "省份";
    private static final String LAT = "纬度(度分)";
    private static final String LNG = "经度(度分)";
    private static final String ALTITUDE ="海拔高度(0.1米)";
    private static final String START_YEAR = "开始年份";
    private static final String START_MONTH = "开始月份";
    private static final String END_YEAR ="截止年份";
    private static final String END_MONTH ="截止月份";
    private static final String LACK_MEASUREMENT ="缺测情况";

    public static String getStationId() {
        return STATION_ID;
    }

    public static String getStationName() {
        return STATION_NAME;
    }

    public static String getPROVINCES() {
        return PROVINCES;
    }

    public static String getLAT() {
        return LAT;
    }

    public static String getLNG() {
        return LNG;
    }

    public static String getALTITUDE() {
        return ALTITUDE;
    }

    public static String getStartYear() {
        return START_YEAR;
    }

    public static String getStartMonth() {
        return START_MONTH;
    }

    public static String getEndYear() {
        return END_YEAR;
    }

    public static String getEndMonth() {
        return END_MONTH;
    }

    public static String getLackMeasurement() {
        return LACK_MEASUREMENT;
    }
}
