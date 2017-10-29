package com.edupractice.malaria.modules.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(Integer value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(Integer value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(Integer value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(Integer value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(Integer value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<Integer> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<Integer> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(Integer value1, Integer value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNull() {
            addCriterion("card_num is null");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNotNull() {
            addCriterion("card_num is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumEqualTo(String value) {
            addCriterion("card_num =", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotEqualTo(String value) {
            addCriterion("card_num <>", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThan(String value) {
            addCriterion("card_num >", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("card_num >=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThan(String value) {
            addCriterion("card_num <", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThanOrEqualTo(String value) {
            addCriterion("card_num <=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLike(String value) {
            addCriterion("card_num like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotLike(String value) {
            addCriterion("card_num not like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumIn(List<String> values) {
            addCriterion("card_num in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotIn(List<String> values) {
            addCriterion("card_num not in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumBetween(String value1, String value2) {
            addCriterion("card_num between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotBetween(String value1, String value2) {
            addCriterion("card_num not between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardStatusIsNull() {
            addCriterion("card_status is null");
            return (Criteria) this;
        }

        public Criteria andCardStatusIsNotNull() {
            addCriterion("card_status is not null");
            return (Criteria) this;
        }

        public Criteria andCardStatusEqualTo(String value) {
            addCriterion("card_status =", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotEqualTo(String value) {
            addCriterion("card_status <>", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusGreaterThan(String value) {
            addCriterion("card_status >", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusGreaterThanOrEqualTo(String value) {
            addCriterion("card_status >=", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusLessThan(String value) {
            addCriterion("card_status <", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusLessThanOrEqualTo(String value) {
            addCriterion("card_status <=", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusLike(String value) {
            addCriterion("card_status like", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotLike(String value) {
            addCriterion("card_status not like", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusIn(List<String> values) {
            addCriterion("card_status in", values, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotIn(List<String> values) {
            addCriterion("card_status not in", values, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusBetween(String value1, String value2) {
            addCriterion("card_status between", value1, value2, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotBetween(String value1, String value2) {
            addCriterion("card_status not between", value1, value2, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNull() {
            addCriterion("disease_id is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(Integer value) {
            addCriterion("disease_id =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(Integer value) {
            addCriterion("disease_id <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(Integer value) {
            addCriterion("disease_id >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disease_id >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(Integer value) {
            addCriterion("disease_id <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("disease_id <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<Integer> values) {
            addCriterion("disease_id in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<Integer> values) {
            addCriterion("disease_id not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("disease_id between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disease_id not between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andCategoryId1IsNull() {
            addCriterion("category_id1 is null");
            return (Criteria) this;
        }

        public Criteria andCategoryId1IsNotNull() {
            addCriterion("category_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryId1EqualTo(Integer value) {
            addCriterion("category_id1 =", value, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1NotEqualTo(Integer value) {
            addCriterion("category_id1 <>", value, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1GreaterThan(Integer value) {
            addCriterion("category_id1 >", value, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1GreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id1 >=", value, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1LessThan(Integer value) {
            addCriterion("category_id1 <", value, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1LessThanOrEqualTo(Integer value) {
            addCriterion("category_id1 <=", value, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1In(List<Integer> values) {
            addCriterion("category_id1 in", values, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1NotIn(List<Integer> values) {
            addCriterion("category_id1 not in", values, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1Between(Integer value1, Integer value2) {
            addCriterion("category_id1 between", value1, value2, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId1NotBetween(Integer value1, Integer value2) {
            addCriterion("category_id1 not between", value1, value2, "categoryId1");
            return (Criteria) this;
        }

        public Criteria andCategoryId2IsNull() {
            addCriterion("category_id2 is null");
            return (Criteria) this;
        }

        public Criteria andCategoryId2IsNotNull() {
            addCriterion("category_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryId2EqualTo(Integer value) {
            addCriterion("category_id2 =", value, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2NotEqualTo(Integer value) {
            addCriterion("category_id2 <>", value, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2GreaterThan(Integer value) {
            addCriterion("category_id2 >", value, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2GreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id2 >=", value, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2LessThan(Integer value) {
            addCriterion("category_id2 <", value, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2LessThanOrEqualTo(Integer value) {
            addCriterion("category_id2 <=", value, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2In(List<Integer> values) {
            addCriterion("category_id2 in", values, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2NotIn(List<Integer> values) {
            addCriterion("category_id2 not in", values, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2Between(Integer value1, Integer value2) {
            addCriterion("category_id2 between", value1, value2, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andCategoryId2NotBetween(Integer value1, Integer value2) {
            addCriterion("category_id2 not between", value1, value2, "categoryId2");
            return (Criteria) this;
        }

        public Criteria andIllDateIsNull() {
            addCriterion("ill_date is null");
            return (Criteria) this;
        }

        public Criteria andIllDateIsNotNull() {
            addCriterion("ill_date is not null");
            return (Criteria) this;
        }

        public Criteria andIllDateEqualTo(Date value) {
            addCriterionForJDBCDate("ill_date =", value, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ill_date <>", value, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ill_date >", value, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ill_date >=", value, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateLessThan(Date value) {
            addCriterionForJDBCDate("ill_date <", value, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ill_date <=", value, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateIn(List<Date> values) {
            addCriterionForJDBCDate("ill_date in", values, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ill_date not in", values, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ill_date between", value1, value2, "illDate");
            return (Criteria) this;
        }

        public Criteria andIllDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ill_date not between", value1, value2, "illDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNull() {
            addCriterion("confirm_date is null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNotNull() {
            addCriterion("confirm_date is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateEqualTo(Date value) {
            addCriterion("confirm_date =", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotEqualTo(Date value) {
            addCriterion("confirm_date <>", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThan(Date value) {
            addCriterion("confirm_date >", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_date >=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThan(Date value) {
            addCriterion("confirm_date <", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThanOrEqualTo(Date value) {
            addCriterion("confirm_date <=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIn(List<Date> values) {
            addCriterion("confirm_date in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotIn(List<Date> values) {
            addCriterion("confirm_date not in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateBetween(Date value1, Date value2) {
            addCriterion("confirm_date between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotBetween(Date value1, Date value2) {
            addCriterion("confirm_date not between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateIsNull() {
            addCriterion("death_date is null");
            return (Criteria) this;
        }

        public Criteria andDeathDateIsNotNull() {
            addCriterion("death_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeathDateEqualTo(Date value) {
            addCriterion("death_date =", value, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateNotEqualTo(Date value) {
            addCriterion("death_date <>", value, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateGreaterThan(Date value) {
            addCriterion("death_date >", value, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateGreaterThanOrEqualTo(Date value) {
            addCriterion("death_date >=", value, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateLessThan(Date value) {
            addCriterion("death_date <", value, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateLessThanOrEqualTo(Date value) {
            addCriterion("death_date <=", value, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateIn(List<Date> values) {
            addCriterion("death_date in", values, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateNotIn(List<Date> values) {
            addCriterion("death_date not in", values, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateBetween(Date value1, Date value2) {
            addCriterion("death_date between", value1, value2, "deathDate");
            return (Criteria) this;
        }

        public Criteria andDeathDateNotBetween(Date value1, Date value2) {
            addCriterion("death_date not between", value1, value2, "deathDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateIsNull() {
            addCriterion("fill_card_date is null");
            return (Criteria) this;
        }

        public Criteria andFillCardDateIsNotNull() {
            addCriterion("fill_card_date is not null");
            return (Criteria) this;
        }

        public Criteria andFillCardDateEqualTo(Date value) {
            addCriterionForJDBCDate("fill_card_date =", value, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("fill_card_date <>", value, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateGreaterThan(Date value) {
            addCriterionForJDBCDate("fill_card_date >", value, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fill_card_date >=", value, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateLessThan(Date value) {
            addCriterionForJDBCDate("fill_card_date <", value, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fill_card_date <=", value, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateIn(List<Date> values) {
            addCriterionForJDBCDate("fill_card_date in", values, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("fill_card_date not in", values, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fill_card_date between", value1, value2, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fill_card_date not between", value1, value2, "fillCardDate");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdIsNull() {
            addCriterion("fill_card_doc_id is null");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdIsNotNull() {
            addCriterion("fill_card_doc_id is not null");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdEqualTo(Integer value) {
            addCriterion("fill_card_doc_id =", value, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdNotEqualTo(Integer value) {
            addCriterion("fill_card_doc_id <>", value, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdGreaterThan(Integer value) {
            addCriterion("fill_card_doc_id >", value, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fill_card_doc_id >=", value, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdLessThan(Integer value) {
            addCriterion("fill_card_doc_id <", value, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdLessThanOrEqualTo(Integer value) {
            addCriterion("fill_card_doc_id <=", value, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdIn(List<Integer> values) {
            addCriterion("fill_card_doc_id in", values, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdNotIn(List<Integer> values) {
            addCriterion("fill_card_doc_id not in", values, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdBetween(Integer value1, Integer value2) {
            addCriterion("fill_card_doc_id between", value1, value2, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andFillCardDocIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fill_card_doc_id not between", value1, value2, "fillCardDocId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdIsNull() {
            addCriterion("report_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdIsNotNull() {
            addCriterion("report_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdEqualTo(Integer value) {
            addCriterion("report_unit_id =", value, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdNotEqualTo(Integer value) {
            addCriterion("report_unit_id <>", value, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdGreaterThan(Integer value) {
            addCriterion("report_unit_id >", value, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_unit_id >=", value, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdLessThan(Integer value) {
            addCriterion("report_unit_id <", value, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_unit_id <=", value, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdIn(List<Integer> values) {
            addCriterion("report_unit_id in", values, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdNotIn(List<Integer> values) {
            addCriterion("report_unit_id not in", values, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdBetween(Integer value1, Integer value2) {
            addCriterion("report_unit_id between", value1, value2, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportUnitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_unit_id not between", value1, value2, "reportUnitId");
            return (Criteria) this;
        }

        public Criteria andReportInputDateIsNull() {
            addCriterion("report_input_date is null");
            return (Criteria) this;
        }

        public Criteria andReportInputDateIsNotNull() {
            addCriterion("report_input_date is not null");
            return (Criteria) this;
        }

        public Criteria andReportInputDateEqualTo(Date value) {
            addCriterion("report_input_date =", value, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateNotEqualTo(Date value) {
            addCriterion("report_input_date <>", value, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateGreaterThan(Date value) {
            addCriterion("report_input_date >", value, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateGreaterThanOrEqualTo(Date value) {
            addCriterion("report_input_date >=", value, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateLessThan(Date value) {
            addCriterion("report_input_date <", value, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateLessThanOrEqualTo(Date value) {
            addCriterion("report_input_date <=", value, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateIn(List<Date> values) {
            addCriterion("report_input_date in", values, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateNotIn(List<Date> values) {
            addCriterion("report_input_date not in", values, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateBetween(Date value1, Date value2) {
            addCriterion("report_input_date between", value1, value2, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andReportInputDateNotBetween(Date value1, Date value2) {
            addCriterion("report_input_date not between", value1, value2, "reportInputDate");
            return (Criteria) this;
        }

        public Criteria andInputUserIdIsNull() {
            addCriterion("input_user_id is null");
            return (Criteria) this;
        }

        public Criteria andInputUserIdIsNotNull() {
            addCriterion("input_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andInputUserIdEqualTo(Integer value) {
            addCriterion("input_user_id =", value, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdNotEqualTo(Integer value) {
            addCriterion("input_user_id <>", value, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdGreaterThan(Integer value) {
            addCriterion("input_user_id >", value, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("input_user_id >=", value, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdLessThan(Integer value) {
            addCriterion("input_user_id <", value, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("input_user_id <=", value, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdIn(List<Integer> values) {
            addCriterion("input_user_id in", values, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdNotIn(List<Integer> values) {
            addCriterion("input_user_id not in", values, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdBetween(Integer value1, Integer value2) {
            addCriterion("input_user_id between", value1, value2, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andInputUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("input_user_id not between", value1, value2, "inputUserId");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateIsNull() {
            addCriterion("county_judge_date is null");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateIsNotNull() {
            addCriterion("county_judge_date is not null");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateEqualTo(String value) {
            addCriterion("county_judge_date =", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateNotEqualTo(String value) {
            addCriterion("county_judge_date <>", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateGreaterThan(String value) {
            addCriterion("county_judge_date >", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateGreaterThanOrEqualTo(String value) {
            addCriterion("county_judge_date >=", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateLessThan(String value) {
            addCriterion("county_judge_date <", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateLessThanOrEqualTo(String value) {
            addCriterion("county_judge_date <=", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateLike(String value) {
            addCriterion("county_judge_date like", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateNotLike(String value) {
            addCriterion("county_judge_date not like", value, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateIn(List<String> values) {
            addCriterion("county_judge_date in", values, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateNotIn(List<String> values) {
            addCriterion("county_judge_date not in", values, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateBetween(String value1, String value2) {
            addCriterion("county_judge_date between", value1, value2, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andCountyJudgeDateNotBetween(String value1, String value2) {
            addCriterion("county_judge_date not between", value1, value2, "countyJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateIsNull() {
            addCriterion("local_judge_date is null");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateIsNotNull() {
            addCriterion("local_judge_date is not null");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateEqualTo(String value) {
            addCriterion("local_judge_date =", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateNotEqualTo(String value) {
            addCriterion("local_judge_date <>", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateGreaterThan(String value) {
            addCriterion("local_judge_date >", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateGreaterThanOrEqualTo(String value) {
            addCriterion("local_judge_date >=", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateLessThan(String value) {
            addCriterion("local_judge_date <", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateLessThanOrEqualTo(String value) {
            addCriterion("local_judge_date <=", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateLike(String value) {
            addCriterion("local_judge_date like", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateNotLike(String value) {
            addCriterion("local_judge_date not like", value, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateIn(List<String> values) {
            addCriterion("local_judge_date in", values, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateNotIn(List<String> values) {
            addCriterion("local_judge_date not in", values, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateBetween(String value1, String value2) {
            addCriterion("local_judge_date between", value1, value2, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andLocalJudgeDateNotBetween(String value1, String value2) {
            addCriterion("local_judge_date not between", value1, value2, "localJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateIsNull() {
            addCriterion("province_judge_date is null");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateIsNotNull() {
            addCriterion("province_judge_date is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateEqualTo(String value) {
            addCriterion("province_judge_date =", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateNotEqualTo(String value) {
            addCriterion("province_judge_date <>", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateGreaterThan(String value) {
            addCriterion("province_judge_date >", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateGreaterThanOrEqualTo(String value) {
            addCriterion("province_judge_date >=", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateLessThan(String value) {
            addCriterion("province_judge_date <", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateLessThanOrEqualTo(String value) {
            addCriterion("province_judge_date <=", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateLike(String value) {
            addCriterion("province_judge_date like", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateNotLike(String value) {
            addCriterion("province_judge_date not like", value, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateIn(List<String> values) {
            addCriterion("province_judge_date in", values, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateNotIn(List<String> values) {
            addCriterion("province_judge_date not in", values, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateBetween(String value1, String value2) {
            addCriterion("province_judge_date between", value1, value2, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andProvinceJudgeDateNotBetween(String value1, String value2) {
            addCriterion("province_judge_date not between", value1, value2, "provinceJudgeDate");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusIsNull() {
            addCriterion("judge_status is null");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusIsNotNull() {
            addCriterion("judge_status is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusEqualTo(String value) {
            addCriterion("judge_status =", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusNotEqualTo(String value) {
            addCriterion("judge_status <>", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusGreaterThan(String value) {
            addCriterion("judge_status >", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("judge_status >=", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusLessThan(String value) {
            addCriterion("judge_status <", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusLessThanOrEqualTo(String value) {
            addCriterion("judge_status <=", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusLike(String value) {
            addCriterion("judge_status like", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusNotLike(String value) {
            addCriterion("judge_status not like", value, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusIn(List<String> values) {
            addCriterion("judge_status in", values, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusNotIn(List<String> values) {
            addCriterion("judge_status not in", values, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusBetween(String value1, String value2) {
            addCriterion("judge_status between", value1, value2, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andJudgeStatusNotBetween(String value1, String value2) {
            addCriterion("judge_status not between", value1, value2, "judgeStatus");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedIsNull() {
            addCriterion("disease_pre_revised is null");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedIsNotNull() {
            addCriterion("disease_pre_revised is not null");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedEqualTo(String value) {
            addCriterion("disease_pre_revised =", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedNotEqualTo(String value) {
            addCriterion("disease_pre_revised <>", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedGreaterThan(String value) {
            addCriterion("disease_pre_revised >", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedGreaterThanOrEqualTo(String value) {
            addCriterion("disease_pre_revised >=", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedLessThan(String value) {
            addCriterion("disease_pre_revised <", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedLessThanOrEqualTo(String value) {
            addCriterion("disease_pre_revised <=", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedLike(String value) {
            addCriterion("disease_pre_revised like", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedNotLike(String value) {
            addCriterion("disease_pre_revised not like", value, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedIn(List<String> values) {
            addCriterion("disease_pre_revised in", values, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedNotIn(List<String> values) {
            addCriterion("disease_pre_revised not in", values, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedBetween(String value1, String value2) {
            addCriterion("disease_pre_revised between", value1, value2, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andDiseasePreRevisedNotBetween(String value1, String value2) {
            addCriterion("disease_pre_revised not between", value1, value2, "diseasePreRevised");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateIsNull() {
            addCriterion("revised_report_date is null");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateIsNotNull() {
            addCriterion("revised_report_date is not null");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateEqualTo(Date value) {
            addCriterion("revised_report_date =", value, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateNotEqualTo(Date value) {
            addCriterion("revised_report_date <>", value, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateGreaterThan(Date value) {
            addCriterion("revised_report_date >", value, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateGreaterThanOrEqualTo(Date value) {
            addCriterion("revised_report_date >=", value, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateLessThan(Date value) {
            addCriterion("revised_report_date <", value, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateLessThanOrEqualTo(Date value) {
            addCriterion("revised_report_date <=", value, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateIn(List<Date> values) {
            addCriterion("revised_report_date in", values, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateNotIn(List<Date> values) {
            addCriterion("revised_report_date not in", values, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateBetween(Date value1, Date value2) {
            addCriterion("revised_report_date between", value1, value2, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedReportDateNotBetween(Date value1, Date value2) {
            addCriterion("revised_report_date not between", value1, value2, "revisedReportDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateIsNull() {
            addCriterion("revised_final_judge_date is null");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateIsNotNull() {
            addCriterion("revised_final_judge_date is not null");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateEqualTo(Date value) {
            addCriterion("revised_final_judge_date =", value, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateNotEqualTo(Date value) {
            addCriterion("revised_final_judge_date <>", value, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateGreaterThan(Date value) {
            addCriterion("revised_final_judge_date >", value, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("revised_final_judge_date >=", value, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateLessThan(Date value) {
            addCriterion("revised_final_judge_date <", value, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateLessThanOrEqualTo(Date value) {
            addCriterion("revised_final_judge_date <=", value, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateIn(List<Date> values) {
            addCriterion("revised_final_judge_date in", values, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateNotIn(List<Date> values) {
            addCriterion("revised_final_judge_date not in", values, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateBetween(Date value1, Date value2) {
            addCriterion("revised_final_judge_date between", value1, value2, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedFinalJudgeDateNotBetween(Date value1, Date value2) {
            addCriterion("revised_final_judge_date not between", value1, value2, "revisedFinalJudgeDate");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdIsNull() {
            addCriterion("revised_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdIsNotNull() {
            addCriterion("revised_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdEqualTo(Integer value) {
            addCriterion("revised_user_id =", value, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdNotEqualTo(Integer value) {
            addCriterion("revised_user_id <>", value, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdGreaterThan(Integer value) {
            addCriterion("revised_user_id >", value, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("revised_user_id >=", value, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdLessThan(Integer value) {
            addCriterion("revised_user_id <", value, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("revised_user_id <=", value, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdIn(List<Integer> values) {
            addCriterion("revised_user_id in", values, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdNotIn(List<Integer> values) {
            addCriterion("revised_user_id not in", values, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdBetween(Integer value1, Integer value2) {
            addCriterion("revised_user_id between", value1, value2, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andRevisedUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("revised_user_id not between", value1, value2, "revisedUserId");
            return (Criteria) this;
        }

        public Criteria andDelDateIsNull() {
            addCriterion("del_date is null");
            return (Criteria) this;
        }

        public Criteria andDelDateIsNotNull() {
            addCriterion("del_date is not null");
            return (Criteria) this;
        }

        public Criteria andDelDateEqualTo(Date value) {
            addCriterion("del_date =", value, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateNotEqualTo(Date value) {
            addCriterion("del_date <>", value, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateGreaterThan(Date value) {
            addCriterion("del_date >", value, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateGreaterThanOrEqualTo(Date value) {
            addCriterion("del_date >=", value, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateLessThan(Date value) {
            addCriterion("del_date <", value, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateLessThanOrEqualTo(Date value) {
            addCriterion("del_date <=", value, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateIn(List<Date> values) {
            addCriterion("del_date in", values, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateNotIn(List<Date> values) {
            addCriterion("del_date not in", values, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateBetween(Date value1, Date value2) {
            addCriterion("del_date between", value1, value2, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelDateNotBetween(Date value1, Date value2) {
            addCriterion("del_date not between", value1, value2, "delDate");
            return (Criteria) this;
        }

        public Criteria andDelUserIdIsNull() {
            addCriterion("del_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDelUserIdIsNotNull() {
            addCriterion("del_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDelUserIdEqualTo(Integer value) {
            addCriterion("del_user_id =", value, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdNotEqualTo(Integer value) {
            addCriterion("del_user_id <>", value, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdGreaterThan(Integer value) {
            addCriterion("del_user_id >", value, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_user_id >=", value, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdLessThan(Integer value) {
            addCriterion("del_user_id <", value, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("del_user_id <=", value, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdIn(List<Integer> values) {
            addCriterion("del_user_id in", values, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdNotIn(List<Integer> values) {
            addCriterion("del_user_id not in", values, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdBetween(Integer value1, Integer value2) {
            addCriterion("del_user_id between", value1, value2, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("del_user_id not between", value1, value2, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelReasonIsNull() {
            addCriterion("del_reason is null");
            return (Criteria) this;
        }

        public Criteria andDelReasonIsNotNull() {
            addCriterion("del_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDelReasonEqualTo(String value) {
            addCriterion("del_reason =", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonNotEqualTo(String value) {
            addCriterion("del_reason <>", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonGreaterThan(String value) {
            addCriterion("del_reason >", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("del_reason >=", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonLessThan(String value) {
            addCriterion("del_reason <", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonLessThanOrEqualTo(String value) {
            addCriterion("del_reason <=", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonLike(String value) {
            addCriterion("del_reason like", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonNotLike(String value) {
            addCriterion("del_reason not like", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonIn(List<String> values) {
            addCriterion("del_reason in", values, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonNotIn(List<String> values) {
            addCriterion("del_reason not in", values, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonBetween(String value1, String value2) {
            addCriterion("del_reason between", value1, value2, "delReason");
            return (Criteria) this;
        }

        public Criteria andDelReasonNotBetween(String value1, String value2) {
            addCriterion("del_reason not between", value1, value2, "delReason");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
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