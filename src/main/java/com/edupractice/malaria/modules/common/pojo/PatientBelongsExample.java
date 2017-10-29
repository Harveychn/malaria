package com.edupractice.malaria.modules.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class PatientBelongsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientBelongsExample() {
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

        public Criteria andBelongsIdIsNull() {
            addCriterion("belongs_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongsIdIsNotNull() {
            addCriterion("belongs_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongsIdEqualTo(Integer value) {
            addCriterion("belongs_id =", value, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdNotEqualTo(Integer value) {
            addCriterion("belongs_id <>", value, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdGreaterThan(Integer value) {
            addCriterion("belongs_id >", value, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("belongs_id >=", value, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdLessThan(Integer value) {
            addCriterion("belongs_id <", value, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdLessThanOrEqualTo(Integer value) {
            addCriterion("belongs_id <=", value, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdIn(List<Integer> values) {
            addCriterion("belongs_id in", values, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdNotIn(List<Integer> values) {
            addCriterion("belongs_id not in", values, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdBetween(Integer value1, Integer value2) {
            addCriterion("belongs_id between", value1, value2, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("belongs_id not between", value1, value2, "belongsId");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelIsNull() {
            addCriterion("belongs_level is null");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelIsNotNull() {
            addCriterion("belongs_level is not null");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelEqualTo(String value) {
            addCriterion("belongs_level =", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelNotEqualTo(String value) {
            addCriterion("belongs_level <>", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelGreaterThan(String value) {
            addCriterion("belongs_level >", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelGreaterThanOrEqualTo(String value) {
            addCriterion("belongs_level >=", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelLessThan(String value) {
            addCriterion("belongs_level <", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelLessThanOrEqualTo(String value) {
            addCriterion("belongs_level <=", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelLike(String value) {
            addCriterion("belongs_level like", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelNotLike(String value) {
            addCriterion("belongs_level not like", value, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelIn(List<String> values) {
            addCriterion("belongs_level in", values, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelNotIn(List<String> values) {
            addCriterion("belongs_level not in", values, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelBetween(String value1, String value2) {
            addCriterion("belongs_level between", value1, value2, "belongsLevel");
            return (Criteria) this;
        }

        public Criteria andBelongsLevelNotBetween(String value1, String value2) {
            addCriterion("belongs_level not between", value1, value2, "belongsLevel");
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