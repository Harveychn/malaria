package com.edupractice.malaria.modules.common.pojo;

public class MeteorologicalStation {
    private Integer stationId;

    private String stationName;

    private String provinces;

    private Integer lat;

    private Integer lng;

    private Integer altitude;

    private Integer startYear;

    private Integer startMonth;

    private Integer endYear;

    private Integer endMonth;

    private String lackMeasurement;

    public MeteorologicalStation(Integer stationId, String stationName, String provinces, Integer lat, Integer lng, Integer altitude, Integer startYear, Integer startMonth, Integer endYear, Integer endMonth, String lackMeasurement) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.provinces = provinces;
        this.lat = lat;
        this.lng = lng;
        this.altitude = altitude;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.lackMeasurement = lackMeasurement;
    }

    public MeteorologicalStation() {
        super();
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces == null ? null : provinces.trim();
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public String getLackMeasurement() {
        return lackMeasurement;
    }

    public void setLackMeasurement(String lackMeasurement) {
        this.lackMeasurement = lackMeasurement == null ? null : lackMeasurement.trim();
    }
}