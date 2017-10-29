package com.edupractice.malaria.modules.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeatherDataExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWeatherIdIsNull() {
            addCriterion("weather_id is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIdIsNotNull() {
            addCriterion("weather_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherIdEqualTo(Integer value) {
            addCriterion("weather_id =", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotEqualTo(Integer value) {
            addCriterion("weather_id <>", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdGreaterThan(Integer value) {
            addCriterion("weather_id >", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("weather_id >=", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdLessThan(Integer value) {
            addCriterion("weather_id <", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdLessThanOrEqualTo(Integer value) {
            addCriterion("weather_id <=", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdIn(List<Integer> values) {
            addCriterion("weather_id in", values, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotIn(List<Integer> values) {
            addCriterion("weather_id not in", values, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdBetween(Integer value1, Integer value2) {
            addCriterion("weather_id between", value1, value2, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("weather_id not between", value1, value2, "weatherId");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(Integer value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(Integer value) {
            addCriterion("station_id <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(Integer value) {
            addCriterion("station_id >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_id >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(Integer value) {
            addCriterion("station_id <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("station_id <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<Integer> values) {
            addCriterion("station_id in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<Integer> values) {
            addCriterion("station_id not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(Integer value1, Integer value2) {
            addCriterion("station_id between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("station_id not between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andWeatherYearIsNull() {
            addCriterion("weather_year is null");
            return (Criteria) this;
        }

        public Criteria andWeatherYearIsNotNull() {
            addCriterion("weather_year is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherYearEqualTo(Integer value) {
            addCriterion("weather_year =", value, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearNotEqualTo(Integer value) {
            addCriterion("weather_year <>", value, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearGreaterThan(Integer value) {
            addCriterion("weather_year >", value, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("weather_year >=", value, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearLessThan(Integer value) {
            addCriterion("weather_year <", value, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearLessThanOrEqualTo(Integer value) {
            addCriterion("weather_year <=", value, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearIn(List<Integer> values) {
            addCriterion("weather_year in", values, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearNotIn(List<Integer> values) {
            addCriterion("weather_year not in", values, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearBetween(Integer value1, Integer value2) {
            addCriterion("weather_year between", value1, value2, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherYearNotBetween(Integer value1, Integer value2) {
            addCriterion("weather_year not between", value1, value2, "weatherYear");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthIsNull() {
            addCriterion("weather_month is null");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthIsNotNull() {
            addCriterion("weather_month is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthEqualTo(Integer value) {
            addCriterion("weather_month =", value, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthNotEqualTo(Integer value) {
            addCriterion("weather_month <>", value, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthGreaterThan(Integer value) {
            addCriterion("weather_month >", value, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("weather_month >=", value, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthLessThan(Integer value) {
            addCriterion("weather_month <", value, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthLessThanOrEqualTo(Integer value) {
            addCriterion("weather_month <=", value, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthIn(List<Integer> values) {
            addCriterion("weather_month in", values, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthNotIn(List<Integer> values) {
            addCriterion("weather_month not in", values, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthBetween(Integer value1, Integer value2) {
            addCriterion("weather_month between", value1, value2, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("weather_month not between", value1, value2, "weatherMonth");
            return (Criteria) this;
        }

        public Criteria andWeatherDayIsNull() {
            addCriterion("weather_day is null");
            return (Criteria) this;
        }

        public Criteria andWeatherDayIsNotNull() {
            addCriterion("weather_day is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherDayEqualTo(Integer value) {
            addCriterion("weather_day =", value, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayNotEqualTo(Integer value) {
            addCriterion("weather_day <>", value, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayGreaterThan(Integer value) {
            addCriterion("weather_day >", value, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("weather_day >=", value, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayLessThan(Integer value) {
            addCriterion("weather_day <", value, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayLessThanOrEqualTo(Integer value) {
            addCriterion("weather_day <=", value, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayIn(List<Integer> values) {
            addCriterion("weather_day in", values, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayNotIn(List<Integer> values) {
            addCriterion("weather_day not in", values, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayBetween(Integer value1, Integer value2) {
            addCriterion("weather_day between", value1, value2, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andWeatherDayNotBetween(Integer value1, Integer value2) {
            addCriterion("weather_day not between", value1, value2, "weatherDay");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020IsNull() {
            addCriterion("precipitation2020 is null");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020IsNotNull() {
            addCriterion("precipitation2020 is not null");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020EqualTo(String value) {
            addCriterion("precipitation2020 =", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020NotEqualTo(String value) {
            addCriterion("precipitation2020 <>", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020GreaterThan(String value) {
            addCriterion("precipitation2020 >", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020GreaterThanOrEqualTo(String value) {
            addCriterion("precipitation2020 >=", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020LessThan(String value) {
            addCriterion("precipitation2020 <", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020LessThanOrEqualTo(String value) {
            addCriterion("precipitation2020 <=", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020Like(String value) {
            addCriterion("precipitation2020 like", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020NotLike(String value) {
            addCriterion("precipitation2020 not like", value, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020In(List<String> values) {
            addCriterion("precipitation2020 in", values, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020NotIn(List<String> values) {
            addCriterion("precipitation2020 not in", values, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020Between(String value1, String value2) {
            addCriterion("precipitation2020 between", value1, value2, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andPrecipitation2020NotBetween(String value1, String value2) {
            addCriterion("precipitation2020 not between", value1, value2, "precipitation2020");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedIsNull() {
            addCriterion("maximum_wind_speed is null");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedIsNotNull() {
            addCriterion("maximum_wind_speed is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedEqualTo(Integer value) {
            addCriterion("maximum_wind_speed =", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedNotEqualTo(Integer value) {
            addCriterion("maximum_wind_speed <>", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedGreaterThan(Integer value) {
            addCriterion("maximum_wind_speed >", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("maximum_wind_speed >=", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedLessThan(Integer value) {
            addCriterion("maximum_wind_speed <", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("maximum_wind_speed <=", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedIn(List<Integer> values) {
            addCriterion("maximum_wind_speed in", values, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedNotIn(List<Integer> values) {
            addCriterion("maximum_wind_speed not in", values, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedBetween(Integer value1, Integer value2) {
            addCriterion("maximum_wind_speed between", value1, value2, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("maximum_wind_speed not between", value1, value2, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedIsNull() {
            addCriterion("direction_maximum_wind_speed is null");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedIsNotNull() {
            addCriterion("direction_maximum_wind_speed is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedEqualTo(String value) {
            addCriterion("direction_maximum_wind_speed =", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedNotEqualTo(String value) {
            addCriterion("direction_maximum_wind_speed <>", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedGreaterThan(String value) {
            addCriterion("direction_maximum_wind_speed >", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("direction_maximum_wind_speed >=", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedLessThan(String value) {
            addCriterion("direction_maximum_wind_speed <", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedLessThanOrEqualTo(String value) {
            addCriterion("direction_maximum_wind_speed <=", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedLike(String value) {
            addCriterion("direction_maximum_wind_speed like", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedNotLike(String value) {
            addCriterion("direction_maximum_wind_speed not like", value, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedIn(List<String> values) {
            addCriterion("direction_maximum_wind_speed in", values, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedNotIn(List<String> values) {
            addCriterion("direction_maximum_wind_speed not in", values, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedBetween(String value1, String value2) {
            addCriterion("direction_maximum_wind_speed between", value1, value2, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaximumWindSpeedNotBetween(String value1, String value2) {
            addCriterion("direction_maximum_wind_speed not between", value1, value2, "directionMaximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAvePressureIsNull() {
            addCriterion("ave_pressure is null");
            return (Criteria) this;
        }

        public Criteria andAvePressureIsNotNull() {
            addCriterion("ave_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andAvePressureEqualTo(Integer value) {
            addCriterion("ave_pressure =", value, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureNotEqualTo(Integer value) {
            addCriterion("ave_pressure <>", value, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureGreaterThan(Integer value) {
            addCriterion("ave_pressure >", value, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureGreaterThanOrEqualTo(Integer value) {
            addCriterion("ave_pressure >=", value, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureLessThan(Integer value) {
            addCriterion("ave_pressure <", value, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureLessThanOrEqualTo(Integer value) {
            addCriterion("ave_pressure <=", value, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureIn(List<Integer> values) {
            addCriterion("ave_pressure in", values, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureNotIn(List<Integer> values) {
            addCriterion("ave_pressure not in", values, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureBetween(Integer value1, Integer value2) {
            addCriterion("ave_pressure between", value1, value2, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAvePressureNotBetween(Integer value1, Integer value2) {
            addCriterion("ave_pressure not between", value1, value2, "avePressure");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedIsNull() {
            addCriterion("ave_wind_speed is null");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedIsNotNull() {
            addCriterion("ave_wind_speed is not null");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedEqualTo(Integer value) {
            addCriterion("ave_wind_speed =", value, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedNotEqualTo(Integer value) {
            addCriterion("ave_wind_speed <>", value, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedGreaterThan(Integer value) {
            addCriterion("ave_wind_speed >", value, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("ave_wind_speed >=", value, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedLessThan(Integer value) {
            addCriterion("ave_wind_speed <", value, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("ave_wind_speed <=", value, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedIn(List<Integer> values) {
            addCriterion("ave_wind_speed in", values, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedNotIn(List<Integer> values) {
            addCriterion("ave_wind_speed not in", values, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedBetween(Integer value1, Integer value2) {
            addCriterion("ave_wind_speed between", value1, value2, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveWindSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("ave_wind_speed not between", value1, value2, "aveWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureIsNull() {
            addCriterion("ave_temperature is null");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureIsNotNull() {
            addCriterion("ave_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureEqualTo(Integer value) {
            addCriterion("ave_temperature =", value, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureNotEqualTo(Integer value) {
            addCriterion("ave_temperature <>", value, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureGreaterThan(Integer value) {
            addCriterion("ave_temperature >", value, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("ave_temperature >=", value, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureLessThan(Integer value) {
            addCriterion("ave_temperature <", value, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureLessThanOrEqualTo(Integer value) {
            addCriterion("ave_temperature <=", value, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureIn(List<Integer> values) {
            addCriterion("ave_temperature in", values, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureNotIn(List<Integer> values) {
            addCriterion("ave_temperature not in", values, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureBetween(Integer value1, Integer value2) {
            addCriterion("ave_temperature between", value1, value2, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveTemperatureNotBetween(Integer value1, Integer value2) {
            addCriterion("ave_temperature not between", value1, value2, "aveTemperature");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureIsNull() {
            addCriterion("ave_vapor_pressure is null");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureIsNotNull() {
            addCriterion("ave_vapor_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureEqualTo(Integer value) {
            addCriterion("ave_vapor_pressure =", value, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureNotEqualTo(Integer value) {
            addCriterion("ave_vapor_pressure <>", value, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureGreaterThan(Integer value) {
            addCriterion("ave_vapor_pressure >", value, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureGreaterThanOrEqualTo(Integer value) {
            addCriterion("ave_vapor_pressure >=", value, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureLessThan(Integer value) {
            addCriterion("ave_vapor_pressure <", value, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureLessThanOrEqualTo(Integer value) {
            addCriterion("ave_vapor_pressure <=", value, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureIn(List<Integer> values) {
            addCriterion("ave_vapor_pressure in", values, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureNotIn(List<Integer> values) {
            addCriterion("ave_vapor_pressure not in", values, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureBetween(Integer value1, Integer value2) {
            addCriterion("ave_vapor_pressure between", value1, value2, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveVaporPressureNotBetween(Integer value1, Integer value2) {
            addCriterion("ave_vapor_pressure not between", value1, value2, "aveVaporPressure");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityIsNull() {
            addCriterion("ave_relative_humidity is null");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityIsNotNull() {
            addCriterion("ave_relative_humidity is not null");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityEqualTo(Integer value) {
            addCriterion("ave_relative_humidity =", value, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityNotEqualTo(Integer value) {
            addCriterion("ave_relative_humidity <>", value, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityGreaterThan(Integer value) {
            addCriterion("ave_relative_humidity >", value, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("ave_relative_humidity >=", value, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityLessThan(Integer value) {
            addCriterion("ave_relative_humidity <", value, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityLessThanOrEqualTo(Integer value) {
            addCriterion("ave_relative_humidity <=", value, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityIn(List<Integer> values) {
            addCriterion("ave_relative_humidity in", values, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityNotIn(List<Integer> values) {
            addCriterion("ave_relative_humidity not in", values, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityBetween(Integer value1, Integer value2) {
            addCriterion("ave_relative_humidity between", value1, value2, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andAveRelativeHumidityNotBetween(Integer value1, Integer value2) {
            addCriterion("ave_relative_humidity not between", value1, value2, "aveRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeIsNull() {
            addCriterion("sunshine_time is null");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeIsNotNull() {
            addCriterion("sunshine_time is not null");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeEqualTo(Integer value) {
            addCriterion("sunshine_time =", value, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeNotEqualTo(Integer value) {
            addCriterion("sunshine_time <>", value, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeGreaterThan(Integer value) {
            addCriterion("sunshine_time >", value, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sunshine_time >=", value, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeLessThan(Integer value) {
            addCriterion("sunshine_time <", value, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeLessThanOrEqualTo(Integer value) {
            addCriterion("sunshine_time <=", value, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeIn(List<Integer> values) {
            addCriterion("sunshine_time in", values, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeNotIn(List<Integer> values) {
            addCriterion("sunshine_time not in", values, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeBetween(Integer value1, Integer value2) {
            addCriterion("sunshine_time between", value1, value2, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andSunshineTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("sunshine_time not between", value1, value2, "sunshineTime");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureIsNull() {
            addCriterion("daily_min_pressure is null");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureIsNotNull() {
            addCriterion("daily_min_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureEqualTo(Integer value) {
            addCriterion("daily_min_pressure =", value, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureNotEqualTo(Integer value) {
            addCriterion("daily_min_pressure <>", value, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureGreaterThan(Integer value) {
            addCriterion("daily_min_pressure >", value, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_min_pressure >=", value, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureLessThan(Integer value) {
            addCriterion("daily_min_pressure <", value, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureLessThanOrEqualTo(Integer value) {
            addCriterion("daily_min_pressure <=", value, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureIn(List<Integer> values) {
            addCriterion("daily_min_pressure in", values, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureNotIn(List<Integer> values) {
            addCriterion("daily_min_pressure not in", values, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureBetween(Integer value1, Integer value2) {
            addCriterion("daily_min_pressure between", value1, value2, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinPressureNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_min_pressure not between", value1, value2, "dailyMinPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureIsNull() {
            addCriterion("daily_min_temperature is null");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureIsNotNull() {
            addCriterion("daily_min_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureEqualTo(Integer value) {
            addCriterion("daily_min_temperature =", value, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureNotEqualTo(Integer value) {
            addCriterion("daily_min_temperature <>", value, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureGreaterThan(Integer value) {
            addCriterion("daily_min_temperature >", value, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_min_temperature >=", value, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureLessThan(Integer value) {
            addCriterion("daily_min_temperature <", value, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureLessThanOrEqualTo(Integer value) {
            addCriterion("daily_min_temperature <=", value, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureIn(List<Integer> values) {
            addCriterion("daily_min_temperature in", values, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureNotIn(List<Integer> values) {
            addCriterion("daily_min_temperature not in", values, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureBetween(Integer value1, Integer value2) {
            addCriterion("daily_min_temperature between", value1, value2, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMinTemperatureNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_min_temperature not between", value1, value2, "dailyMinTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureIsNull() {
            addCriterion("daily_max_pressure is null");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureIsNotNull() {
            addCriterion("daily_max_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureEqualTo(Integer value) {
            addCriterion("daily_max_pressure =", value, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureNotEqualTo(Integer value) {
            addCriterion("daily_max_pressure <>", value, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureGreaterThan(Integer value) {
            addCriterion("daily_max_pressure >", value, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_max_pressure >=", value, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureLessThan(Integer value) {
            addCriterion("daily_max_pressure <", value, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureLessThanOrEqualTo(Integer value) {
            addCriterion("daily_max_pressure <=", value, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureIn(List<Integer> values) {
            addCriterion("daily_max_pressure in", values, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureNotIn(List<Integer> values) {
            addCriterion("daily_max_pressure not in", values, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureBetween(Integer value1, Integer value2) {
            addCriterion("daily_max_pressure between", value1, value2, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxPressureNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_max_pressure not between", value1, value2, "dailyMaxPressure");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureIsNull() {
            addCriterion("daily_max_temperature is null");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureIsNotNull() {
            addCriterion("daily_max_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureEqualTo(Integer value) {
            addCriterion("daily_max_temperature =", value, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureNotEqualTo(Integer value) {
            addCriterion("daily_max_temperature <>", value, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureGreaterThan(Integer value) {
            addCriterion("daily_max_temperature >", value, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_max_temperature >=", value, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureLessThan(Integer value) {
            addCriterion("daily_max_temperature <", value, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureLessThanOrEqualTo(Integer value) {
            addCriterion("daily_max_temperature <=", value, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureIn(List<Integer> values) {
            addCriterion("daily_max_temperature in", values, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureNotIn(List<Integer> values) {
            addCriterion("daily_max_temperature not in", values, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureBetween(Integer value1, Integer value2) {
            addCriterion("daily_max_temperature between", value1, value2, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andDailyMaxTemperatureNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_max_temperature not between", value1, value2, "dailyMaxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedIsNull() {
            addCriterion("max_wind_speed is null");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedIsNotNull() {
            addCriterion("max_wind_speed is not null");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedEqualTo(Integer value) {
            addCriterion("max_wind_speed =", value, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedNotEqualTo(Integer value) {
            addCriterion("max_wind_speed <>", value, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedGreaterThan(Integer value) {
            addCriterion("max_wind_speed >", value, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_wind_speed >=", value, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedLessThan(Integer value) {
            addCriterion("max_wind_speed <", value, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("max_wind_speed <=", value, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedIn(List<Integer> values) {
            addCriterion("max_wind_speed in", values, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedNotIn(List<Integer> values) {
            addCriterion("max_wind_speed not in", values, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedBetween(Integer value1, Integer value2) {
            addCriterion("max_wind_speed between", value1, value2, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxWindSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("max_wind_speed not between", value1, value2, "maxWindSpeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedIsNull() {
            addCriterion("direction_max_windspeed is null");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedIsNotNull() {
            addCriterion("direction_max_windspeed is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedEqualTo(String value) {
            addCriterion("direction_max_windspeed =", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedNotEqualTo(String value) {
            addCriterion("direction_max_windspeed <>", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedGreaterThan(String value) {
            addCriterion("direction_max_windspeed >", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedGreaterThanOrEqualTo(String value) {
            addCriterion("direction_max_windspeed >=", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedLessThan(String value) {
            addCriterion("direction_max_windspeed <", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedLessThanOrEqualTo(String value) {
            addCriterion("direction_max_windspeed <=", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedLike(String value) {
            addCriterion("direction_max_windspeed like", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedNotLike(String value) {
            addCriterion("direction_max_windspeed not like", value, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedIn(List<String> values) {
            addCriterion("direction_max_windspeed in", values, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedNotIn(List<String> values) {
            addCriterion("direction_max_windspeed not in", values, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedBetween(String value1, String value2) {
            addCriterion("direction_max_windspeed between", value1, value2, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andDirectionMaxWindspeedNotBetween(String value1, String value2) {
            addCriterion("direction_max_windspeed not between", value1, value2, "directionMaxWindspeed");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityIsNull() {
            addCriterion("min_relative_humidity is null");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityIsNotNull() {
            addCriterion("min_relative_humidity is not null");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityEqualTo(Integer value) {
            addCriterion("min_relative_humidity =", value, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityNotEqualTo(Integer value) {
            addCriterion("min_relative_humidity <>", value, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityGreaterThan(Integer value) {
            addCriterion("min_relative_humidity >", value, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_relative_humidity >=", value, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityLessThan(Integer value) {
            addCriterion("min_relative_humidity <", value, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityLessThanOrEqualTo(Integer value) {
            addCriterion("min_relative_humidity <=", value, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityIn(List<Integer> values) {
            addCriterion("min_relative_humidity in", values, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityNotIn(List<Integer> values) {
            addCriterion("min_relative_humidity not in", values, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityBetween(Integer value1, Integer value2) {
            addCriterion("min_relative_humidity between", value1, value2, "minRelativeHumidity");
            return (Criteria) this;
        }

        public Criteria andMinRelativeHumidityNotBetween(Integer value1, Integer value2) {
            addCriterion("min_relative_humidity not between", value1, value2, "minRelativeHumidity");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}