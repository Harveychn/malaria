package com.edupractice.malaria.modules.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class CaseCategory1Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseCategory1Example() {
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

        public Criteria andCategory1NameIsNull() {
            addCriterion("category1_name is null");
            return (Criteria) this;
        }

        public Criteria andCategory1NameIsNotNull() {
            addCriterion("category1_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategory1NameEqualTo(String value) {
            addCriterion("category1_name =", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameNotEqualTo(String value) {
            addCriterion("category1_name <>", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameGreaterThan(String value) {
            addCriterion("category1_name >", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameGreaterThanOrEqualTo(String value) {
            addCriterion("category1_name >=", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameLessThan(String value) {
            addCriterion("category1_name <", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameLessThanOrEqualTo(String value) {
            addCriterion("category1_name <=", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameLike(String value) {
            addCriterion("category1_name like", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameNotLike(String value) {
            addCriterion("category1_name not like", value, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameIn(List<String> values) {
            addCriterion("category1_name in", values, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameNotIn(List<String> values) {
            addCriterion("category1_name not in", values, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameBetween(String value1, String value2) {
            addCriterion("category1_name between", value1, value2, "category1Name");
            return (Criteria) this;
        }

        public Criteria andCategory1NameNotBetween(String value1, String value2) {
            addCriterion("category1_name not between", value1, value2, "category1Name");
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