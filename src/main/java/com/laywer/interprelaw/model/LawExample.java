package com.laywer.interprelaw.model;

import java.util.ArrayList;
import java.util.List;

public class LawExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LawExample() {
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

        public Criteria andLawidIsNull() {
            addCriterion("lawId is null");
            return (Criteria) this;
        }

        public Criteria andLawidIsNotNull() {
            addCriterion("lawId is not null");
            return (Criteria) this;
        }

        public Criteria andLawidEqualTo(Integer value) {
            addCriterion("lawId =", value, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidNotEqualTo(Integer value) {
            addCriterion("lawId <>", value, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidGreaterThan(Integer value) {
            addCriterion("lawId >", value, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lawId >=", value, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidLessThan(Integer value) {
            addCriterion("lawId <", value, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidLessThanOrEqualTo(Integer value) {
            addCriterion("lawId <=", value, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidIn(List<Integer> values) {
            addCriterion("lawId in", values, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidNotIn(List<Integer> values) {
            addCriterion("lawId not in", values, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidBetween(Integer value1, Integer value2) {
            addCriterion("lawId between", value1, value2, "lawid");
            return (Criteria) this;
        }

        public Criteria andLawidNotBetween(Integer value1, Integer value2) {
            addCriterion("lawId not between", value1, value2, "lawid");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsIsNull() {
            addCriterion("legalProvisions is null");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsIsNotNull() {
            addCriterion("legalProvisions is not null");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsEqualTo(String value) {
            addCriterion("legalProvisions =", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsNotEqualTo(String value) {
            addCriterion("legalProvisions <>", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsGreaterThan(String value) {
            addCriterion("legalProvisions >", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsGreaterThanOrEqualTo(String value) {
            addCriterion("legalProvisions >=", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsLessThan(String value) {
            addCriterion("legalProvisions <", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsLessThanOrEqualTo(String value) {
            addCriterion("legalProvisions <=", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsLike(String value) {
            addCriterion("legalProvisions like", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsNotLike(String value) {
            addCriterion("legalProvisions not like", value, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsIn(List<String> values) {
            addCriterion("legalProvisions in", values, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsNotIn(List<String> values) {
            addCriterion("legalProvisions not in", values, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsBetween(String value1, String value2) {
            addCriterion("legalProvisions between", value1, value2, "legalprovisions");
            return (Criteria) this;
        }

        public Criteria andLegalprovisionsNotBetween(String value1, String value2) {
            addCriterion("legalProvisions not between", value1, value2, "legalprovisions");
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