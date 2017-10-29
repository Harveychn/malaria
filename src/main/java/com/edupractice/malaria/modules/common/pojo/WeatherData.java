package com.edupractice.malaria.modules.common.pojo;

public class WeatherData {
    private Integer weatherId;

    private Integer stationId;

    private Integer weatherYear;

    private Integer weatherMonth;

    private Integer weatherDay;

    private String precipitation2020;

    private Integer maximumWindSpeed;

    private String directionMaximumWindSpeed;

    private Integer avePressure;

    private Integer aveWindSpeed;

    private Integer aveTemperature;

    private Integer aveVaporPressure;

    private Integer aveRelativeHumidity;

    private Integer sunshineTime;

    private Integer dailyMinPressure;

    private Integer dailyMinTemperature;

    private Integer dailyMaxPressure;

    private Integer dailyMaxTemperature;

    private Integer maxWindSpeed;

    private String directionMaxWindspeed;

    private Integer minRelativeHumidity;

    public WeatherData(Integer weatherId, Integer stationId, Integer weatherYear, Integer weatherMonth, Integer weatherDay, String precipitation2020, Integer maximumWindSpeed, String directionMaximumWindSpeed, Integer avePressure, Integer aveWindSpeed, Integer aveTemperature, Integer aveVaporPressure, Integer aveRelativeHumidity, Integer sunshineTime, Integer dailyMinPressure, Integer dailyMinTemperature, Integer dailyMaxPressure, Integer dailyMaxTemperature, Integer maxWindSpeed, String directionMaxWindspeed, Integer minRelativeHumidity) {
        this.weatherId = weatherId;
        this.stationId = stationId;
        this.weatherYear = weatherYear;
        this.weatherMonth = weatherMonth;
        this.weatherDay = weatherDay;
        this.precipitation2020 = precipitation2020;
        this.maximumWindSpeed = maximumWindSpeed;
        this.directionMaximumWindSpeed = directionMaximumWindSpeed;
        this.avePressure = avePressure;
        this.aveWindSpeed = aveWindSpeed;
        this.aveTemperature = aveTemperature;
        this.aveVaporPressure = aveVaporPressure;
        this.aveRelativeHumidity = aveRelativeHumidity;
        this.sunshineTime = sunshineTime;
        this.dailyMinPressure = dailyMinPressure;
        this.dailyMinTemperature = dailyMinTemperature;
        this.dailyMaxPressure = dailyMaxPressure;
        this.dailyMaxTemperature = dailyMaxTemperature;
        this.maxWindSpeed = maxWindSpeed;
        this.directionMaxWindspeed = directionMaxWindspeed;
        this.minRelativeHumidity = minRelativeHumidity;
    }

    public WeatherData() {
        super();
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getWeatherYear() {
        return weatherYear;
    }

    public void setWeatherYear(Integer weatherYear) {
        this.weatherYear = weatherYear;
    }

    public Integer getWeatherMonth() {
        return weatherMonth;
    }

    public void setWeatherMonth(Integer weatherMonth) {
        this.weatherMonth = weatherMonth;
    }

    public Integer getWeatherDay() {
        return weatherDay;
    }

    public void setWeatherDay(Integer weatherDay) {
        this.weatherDay = weatherDay;
    }

    public String getPrecipitation2020() {
        return precipitation2020;
    }

    public void setPrecipitation2020(String precipitation2020) {
        this.precipitation2020 = precipitation2020 == null ? null : precipitation2020.trim();
    }

    public Integer getMaximumWindSpeed() {
        return maximumWindSpeed;
    }

    public void setMaximumWindSpeed(Integer maximumWindSpeed) {
        this.maximumWindSpeed = maximumWindSpeed;
    }

    public String getDirectionMaximumWindSpeed() {
        return directionMaximumWindSpeed;
    }

    public void setDirectionMaximumWindSpeed(String directionMaximumWindSpeed) {
        this.directionMaximumWindSpeed = directionMaximumWindSpeed == null ? null : directionMaximumWindSpeed.trim();
    }

    public Integer getAvePressure() {
        return avePressure;
    }

    public void setAvePressure(Integer avePressure) {
        this.avePressure = avePressure;
    }

    public Integer getAveWindSpeed() {
        return aveWindSpeed;
    }

    public void setAveWindSpeed(Integer aveWindSpeed) {
        this.aveWindSpeed = aveWindSpeed;
    }

    public Integer getAveTemperature() {
        return aveTemperature;
    }

    public void setAveTemperature(Integer aveTemperature) {
        this.aveTemperature = aveTemperature;
    }

    public Integer getAveVaporPressure() {
        return aveVaporPressure;
    }

    public void setAveVaporPressure(Integer aveVaporPressure) {
        this.aveVaporPressure = aveVaporPressure;
    }

    public Integer getAveRelativeHumidity() {
        return aveRelativeHumidity;
    }

    public void setAveRelativeHumidity(Integer aveRelativeHumidity) {
        this.aveRelativeHumidity = aveRelativeHumidity;
    }

    public Integer getSunshineTime() {
        return sunshineTime;
    }

    public void setSunshineTime(Integer sunshineTime) {
        this.sunshineTime = sunshineTime;
    }

    public Integer getDailyMinPressure() {
        return dailyMinPressure;
    }

    public void setDailyMinPressure(Integer dailyMinPressure) {
        this.dailyMinPressure = dailyMinPressure;
    }

    public Integer getDailyMinTemperature() {
        return dailyMinTemperature;
    }

    public void setDailyMinTemperature(Integer dailyMinTemperature) {
        this.dailyMinTemperature = dailyMinTemperature;
    }

    public Integer getDailyMaxPressure() {
        return dailyMaxPressure;
    }

    public void setDailyMaxPressure(Integer dailyMaxPressure) {
        this.dailyMaxPressure = dailyMaxPressure;
    }

    public Integer getDailyMaxTemperature() {
        return dailyMaxTemperature;
    }

    public void setDailyMaxTemperature(Integer dailyMaxTemperature) {
        this.dailyMaxTemperature = dailyMaxTemperature;
    }

    public Integer getMaxWindSpeed() {
        return maxWindSpeed;
    }

    public void setMaxWindSpeed(Integer maxWindSpeed) {
        this.maxWindSpeed = maxWindSpeed;
    }

    public String getDirectionMaxWindspeed() {
        return directionMaxWindspeed;
    }

    public void setDirectionMaxWindspeed(String directionMaxWindspeed) {
        this.directionMaxWindspeed = directionMaxWindspeed == null ? null : directionMaxWindspeed.trim();
    }

    public Integer getMinRelativeHumidity() {
        return minRelativeHumidity;
    }

    public void setMinRelativeHumidity(Integer minRelativeHumidity) {
        this.minRelativeHumidity = minRelativeHumidity;
    }
}