package com.edupractice.malaria.modules.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class MeteorologicalStationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeteorologicalStationExample() {
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

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andProvincesIsNull() {
            addCriterion("provinces is null");
            return (Criteria) this;
        }

        public Criteria andProvincesIsNotNull() {
            addCriterion("provinces is not null");
            return (Criteria) this;
        }

        public Criteria andProvincesEqualTo(String value) {
            addCriterion("provinces =", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotEqualTo(String value) {
            addCriterion("provinces <>", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesGreaterThan(String value) {
            addCriterion("provinces >", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesGreaterThanOrEqualTo(String value) {
            addCriterion("provinces >=", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesLessThan(String value) {
            addCriterion("provinces <", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesLessThanOrEqualTo(String value) {
            addCriterion("provinces <=", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesLike(String value) {
            addCriterion("provinces like", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotLike(String value) {
            addCriterion("provinces not like", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesIn(List<String> values) {
            addCriterion("provinces in", values, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotIn(List<String> values) {
            addCriterion("provinces not in", values, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesBetween(String value1, String value2) {
            addCriterion("provinces between", value1, value2, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotBetween(String value1, String value2) {
            addCriterion("provinces not between", value1, value2, "provinces");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Integer value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Integer value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Integer value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Integer value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Integer value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Integer value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Integer> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Integer> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Integer value1, Integer value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Integer value1, Integer value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Integer value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Integer value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Integer value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Integer value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Integer value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Integer value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Integer> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Integer> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Integer value1, Integer value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Integer value1, Integer value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNull() {
            addCriterion("altitude is null");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNotNull() {
            addCriterion("altitude is not null");
            return (Criteria) this;
        }

        public Criteria andAltitudeEqualTo(Integer value) {
            addCriterion("altitude =", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotEqualTo(Integer value) {
            addCriterion("altitude <>", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThan(Integer value) {
            addCriterion("altitude >", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("altitude >=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThan(Integer value) {
            addCriterion("altitude <", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThanOrEqualTo(Integer value) {
            addCriterion("altitude <=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeIn(List<Integer> values) {
            addCriterion("altitude in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotIn(List<Integer> values) {
            addCriterion("altitude not in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeBetween(Integer value1, Integer value2) {
            addCriterion("altitude between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("altitude not between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andStartYearIsNull() {
            addCriterion("start_year is null");
            return (Criteria) this;
        }

        public Criteria andStartYearIsNotNull() {
            addCriterion("start_year is not null");
            return (Criteria) this;
        }

        public Criteria andStartYearEqualTo(Integer value) {
            addCriterion("start_year =", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotEqualTo(Integer value) {
            addCriterion("start_year <>", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearGreaterThan(Integer value) {
            addCriterion("start_year >", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_year >=", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLessThan(Integer value) {
            addCriterion("start_year <", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLessThanOrEqualTo(Integer value) {
            addCriterion("start_year <=", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearIn(List<Integer> values) {
            addCriterion("start_year in", values, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotIn(List<Integer> values) {
            addCriterion("start_year not in", values, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearBetween(Integer value1, Integer value2) {
            addCriterion("start_year between", value1, value2, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotBetween(Integer value1, Integer value2) {
            addCriterion("start_year not between", value1, value2, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartMonthIsNull() {
            addCriterion("start_month is null");
            return (Criteria) this;
        }

        public Criteria andStartMonthIsNotNull() {
            addCriterion("start_month is not null");
            return (Criteria) this;
        }

        public Criteria andStartMonthEqualTo(Integer value) {
            addCriterion("start_month =", value, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthNotEqualTo(Integer value) {
            addCriterion("start_month <>", value, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthGreaterThan(Integer value) {
            addCriterion("start_month >", value, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_month >=", value, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthLessThan(Integer value) {
            addCriterion("start_month <", value, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthLessThanOrEqualTo(Integer value) {
            addCriterion("start_month <=", value, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthIn(List<Integer> values) {
            addCriterion("start_month in", values, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthNotIn(List<Integer> values) {
            addCriterion("start_month not in", values, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthBetween(Integer value1, Integer value2) {
            addCriterion("start_month between", value1, value2, "startMonth");
            return (Criteria) this;
        }

        public Criteria andStartMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("start_month not between", value1, value2, "startMonth");
            return (Criteria) this;
        }

        public Criteria andEndYearIsNull() {
            addCriterion("end_year is null");
            return (Criteria) this;
        }

        public Criteria andEndYearIsNotNull() {
            addCriterion("end_year is not null");
            return (Criteria) this;
        }

        public Criteria andEndYearEqualTo(Integer value) {
            addCriterion("end_year =", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotEqualTo(Integer value) {
            addCriterion("end_year <>", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearGreaterThan(Integer value) {
            addCriterion("end_year >", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_year >=", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearLessThan(Integer value) {
            addCriterion("end_year <", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearLessThanOrEqualTo(Integer value) {
            addCriterion("end_year <=", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearIn(List<Integer> values) {
            addCriterion("end_year in", values, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotIn(List<Integer> values) {
            addCriterion("end_year not in", values, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearBetween(Integer value1, Integer value2) {
            addCriterion("end_year between", value1, value2, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotBetween(Integer value1, Integer value2) {
            addCriterion("end_year not between", value1, value2, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndMonthIsNull() {
            addCriterion("end_month is null");
            return (Criteria) this;
        }

        public Criteria andEndMonthIsNotNull() {
            addCriterion("end_month is not null");
            return (Criteria) this;
        }

        public Criteria andEndMonthEqualTo(Integer value) {
            addCriterion("end_month =", value, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthNotEqualTo(Integer value) {
            addCriterion("end_month <>", value, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthGreaterThan(Integer value) {
            addCriterion("end_month >", value, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_month >=", value, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthLessThan(Integer value) {
            addCriterion("end_month <", value, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthLessThanOrEqualTo(Integer value) {
            addCriterion("end_month <=", value, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthIn(List<Integer> values) {
            addCriterion("end_month in", values, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthNotIn(List<Integer> values) {
            addCriterion("end_month not in", values, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthBetween(Integer value1, Integer value2) {
            addCriterion("end_month between", value1, value2, "endMonth");
            return (Criteria) this;
        }

        public Criteria andEndMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("end_month not between", value1, value2, "endMonth");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementIsNull() {
            addCriterion("lack_measurement is null");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementIsNotNull() {
            addCriterion("lack_measurement is not null");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementEqualTo(String value) {
            addCriterion("lack_measurement =", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementNotEqualTo(String value) {
            addCriterion("lack_measurement <>", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementGreaterThan(String value) {
            addCriterion("lack_measurement >", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementGreaterThanOrEqualTo(String value) {
            addCriterion("lack_measurement >=", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementLessThan(String value) {
            addCriterion("lack_measurement <", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementLessThanOrEqualTo(String value) {
            addCriterion("lack_measurement <=", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementLike(String value) {
            addCriterion("lack_measurement like", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementNotLike(String value) {
            addCriterion("lack_measurement not like", value, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementIn(List<String> values) {
            addCriterion("lack_measurement in", values, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementNotIn(List<String> values) {
            addCriterion("lack_measurement not in", values, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementBetween(String value1, String value2) {
            addCriterion("lack_measurement between", value1, value2, "lackMeasurement");
            return (Criteria) this;
        }

        public Criteria andLackMeasurementNotBetween(String value1, String value2) {
            addCriterion("lack_measurement not between", value1, value2, "lackMeasurement");
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