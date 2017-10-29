package com.edupractice.malaria.modules.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class MedicalUnitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedicalUnitExample() {
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

        public Criteria andMedicalUnitIdIsNull() {
            addCriterion("medical_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdIsNotNull() {
            addCriterion("medical_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdEqualTo(Integer value) {
            addCriterion("medical_unit_id =", value, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdNotEqualTo(Integer value) {
            addCriterion("medical_unit_id <>", value, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdGreaterThan(Integer value) {
            addCriterion("medical_unit_id >", value, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("medical_unit_id >=", value, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdLessThan(Integer value) {
            addCriterion("medical_unit_id <", value, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdLessThanOrEqualTo(Integer value) {
            addCriterion("medical_unit_id <=", value, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdIn(List<Integer> values) {
            addCriterion("medical_unit_id in", values, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdNotIn(List<Integer> values) {
            addCriterion("medical_unit_id not in", values, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdBetween(Integer value1, Integer value2) {
            addCriterion("medical_unit_id between", value1, value2, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andMedicalUnitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("medical_unit_id not between", value1, value2, "medicalUnitId");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUniteTypeIsNull() {
            addCriterion("unite_type is null");
            return (Criteria) this;
        }

        public Criteria andUniteTypeIsNotNull() {
            addCriterion("unite_type is not null");
            return (Criteria) this;
        }

        public Criteria andUniteTypeEqualTo(String value) {
            addCriterion("unite_type =", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeNotEqualTo(String value) {
            addCriterion("unite_type <>", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeGreaterThan(String value) {
            addCriterion("unite_type >", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("unite_type >=", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeLessThan(String value) {
            addCriterion("unite_type <", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeLessThanOrEqualTo(String value) {
            addCriterion("unite_type <=", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeLike(String value) {
            addCriterion("unite_type like", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeNotLike(String value) {
            addCriterion("unite_type not like", value, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeIn(List<String> values) {
            addCriterion("unite_type in", values, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeNotIn(List<String> values) {
            addCriterion("unite_type not in", values, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeBetween(String value1, String value2) {
            addCriterion("unite_type between", value1, value2, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteTypeNotBetween(String value1, String value2) {
            addCriterion("unite_type not between", value1, value2, "uniteType");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeIsNull() {
            addCriterion("unite_area_code is null");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeIsNotNull() {
            addCriterion("unite_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeEqualTo(String value) {
            addCriterion("unite_area_code =", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeNotEqualTo(String value) {
            addCriterion("unite_area_code <>", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeGreaterThan(String value) {
            addCriterion("unite_area_code >", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("unite_area_code >=", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeLessThan(String value) {
            addCriterion("unite_area_code <", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("unite_area_code <=", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeLike(String value) {
            addCriterion("unite_area_code like", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeNotLike(String value) {
            addCriterion("unite_area_code not like", value, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeIn(List<String> values) {
            addCriterion("unite_area_code in", values, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeNotIn(List<String> values) {
            addCriterion("unite_area_code not in", values, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeBetween(String value1, String value2) {
            addCriterion("unite_area_code between", value1, value2, "uniteAreaCode");
            return (Criteria) this;
        }

        public Criteria andUniteAreaCodeNotBetween(String value1, String value2) {
            addCriterion("unite_area_code not between", value1, value2, "uniteAreaCode");
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