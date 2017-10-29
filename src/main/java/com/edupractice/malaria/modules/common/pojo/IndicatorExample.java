package com.edupractice.malaria.modules.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class IndicatorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndicatorExample() {
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

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andBelongTableIsNull() {
            addCriterion("belong_table is null");
            return (Criteria) this;
        }

        public Criteria andBelongTableIsNotNull() {
            addCriterion("belong_table is not null");
            return (Criteria) this;
        }

        public Criteria andBelongTableEqualTo(String value) {
            addCriterion("belong_table =", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableNotEqualTo(String value) {
            addCriterion("belong_table <>", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableGreaterThan(String value) {
            addCriterion("belong_table >", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableGreaterThanOrEqualTo(String value) {
            addCriterion("belong_table >=", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableLessThan(String value) {
            addCriterion("belong_table <", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableLessThanOrEqualTo(String value) {
            addCriterion("belong_table <=", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableLike(String value) {
            addCriterion("belong_table like", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableNotLike(String value) {
            addCriterion("belong_table not like", value, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableIn(List<String> values) {
            addCriterion("belong_table in", values, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableNotIn(List<String> values) {
            addCriterion("belong_table not in", values, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableBetween(String value1, String value2) {
            addCriterion("belong_table between", value1, value2, "belongTable");
            return (Criteria) this;
        }

        public Criteria andBelongTableNotBetween(String value1, String value2) {
            addCriterion("belong_table not between", value1, value2, "belongTable");
            return (Criteria) this;
        }

        public Criteria andTableAliasIsNull() {
            addCriterion("table_alias is null");
            return (Criteria) this;
        }

        public Criteria andTableAliasIsNotNull() {
            addCriterion("table_alias is not null");
            return (Criteria) this;
        }

        public Criteria andTableAliasEqualTo(String value) {
            addCriterion("table_alias =", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasNotEqualTo(String value) {
            addCriterion("table_alias <>", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasGreaterThan(String value) {
            addCriterion("table_alias >", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasGreaterThanOrEqualTo(String value) {
            addCriterion("table_alias >=", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasLessThan(String value) {
            addCriterion("table_alias <", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasLessThanOrEqualTo(String value) {
            addCriterion("table_alias <=", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasLike(String value) {
            addCriterion("table_alias like", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasNotLike(String value) {
            addCriterion("table_alias not like", value, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasIn(List<String> values) {
            addCriterion("table_alias in", values, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasNotIn(List<String> values) {
            addCriterion("table_alias not in", values, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasBetween(String value1, String value2) {
            addCriterion("table_alias between", value1, value2, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andTableAliasNotBetween(String value1, String value2) {
            addCriterion("table_alias not between", value1, value2, "tableAlias");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_name is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_name =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_name <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_name >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_name >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_name <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_name <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_name like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_name not like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("display_name in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("display_name not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_name between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_name not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDownableIsNull() {
            addCriterion("downable is null");
            return (Criteria) this;
        }

        public Criteria andDownableIsNotNull() {
            addCriterion("downable is not null");
            return (Criteria) this;
        }

        public Criteria andDownableEqualTo(Byte value) {
            addCriterion("downable =", value, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableNotEqualTo(Byte value) {
            addCriterion("downable <>", value, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableGreaterThan(Byte value) {
            addCriterion("downable >", value, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableGreaterThanOrEqualTo(Byte value) {
            addCriterion("downable >=", value, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableLessThan(Byte value) {
            addCriterion("downable <", value, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableLessThanOrEqualTo(Byte value) {
            addCriterion("downable <=", value, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableIn(List<Byte> values) {
            addCriterion("downable in", values, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableNotIn(List<Byte> values) {
            addCriterion("downable not in", values, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableBetween(Byte value1, Byte value2) {
            addCriterion("downable between", value1, value2, "downable");
            return (Criteria) this;
        }

        public Criteria andDownableNotBetween(Byte value1, Byte value2) {
            addCriterion("downable not between", value1, value2, "downable");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
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