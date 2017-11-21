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

        public Criteria andUnitTypeIsNull() {
            addCriterion("unit_type is null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNotNull() {
            addCriterion("unit_type is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeEqualTo(String value) {
            addCriterion("unit_type =", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotEqualTo(String value) {
            addCriterion("unit_type <>", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThan(String value) {
            addCriterion("unit_type >", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_type >=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThan(String value) {
            addCriterion("unit_type <", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("unit_type <=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLike(String value) {
            addCriterion("unit_type like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotLike(String value) {
            addCriterion("unit_type not like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIn(List<String> values) {
            addCriterion("unit_type in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotIn(List<String> values) {
            addCriterion("unit_type not in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeBetween(String value1, String value2) {
            addCriterion("unit_type between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotBetween(String value1, String value2) {
            addCriterion("unit_type not between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeIsNull() {
            addCriterion("unit_area_code is null");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeIsNotNull() {
            addCriterion("unit_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeEqualTo(String value) {
            addCriterion("unit_area_code =", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeNotEqualTo(String value) {
            addCriterion("unit_area_code <>", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeGreaterThan(String value) {
            addCriterion("unit_area_code >", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_area_code >=", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeLessThan(String value) {
            addCriterion("unit_area_code <", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("unit_area_code <=", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeLike(String value) {
            addCriterion("unit_area_code like", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeNotLike(String value) {
            addCriterion("unit_area_code not like", value, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeIn(List<String> values) {
            addCriterion("unit_area_code in", values, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeNotIn(List<String> values) {
            addCriterion("unit_area_code not in", values, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeBetween(String value1, String value2) {
            addCriterion("unit_area_code between", value1, value2, "unitAreaCode");
            return (Criteria) this;
        }

        public Criteria andUnitAreaCodeNotBetween(String value1, String value2) {
            addCriterion("unit_area_code not between", value1, value2, "unitAreaCode");
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