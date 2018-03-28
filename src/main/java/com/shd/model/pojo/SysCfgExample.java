package com.shd.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysCfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCfgExample() {
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

        public Criteria andCfgIdIsNull() {
            addCriterion("CFG_ID is null");
            return (Criteria) this;
        }

        public Criteria andCfgIdIsNotNull() {
            addCriterion("CFG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCfgIdEqualTo(String value) {
            addCriterion("CFG_ID =", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdNotEqualTo(String value) {
            addCriterion("CFG_ID <>", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdGreaterThan(String value) {
            addCriterion("CFG_ID >", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdGreaterThanOrEqualTo(String value) {
            addCriterion("CFG_ID >=", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdLessThan(String value) {
            addCriterion("CFG_ID <", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdLessThanOrEqualTo(String value) {
            addCriterion("CFG_ID <=", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdLike(String value) {
            addCriterion("CFG_ID like", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdNotLike(String value) {
            addCriterion("CFG_ID not like", value, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdIn(List<String> values) {
            addCriterion("CFG_ID in", values, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdNotIn(List<String> values) {
            addCriterion("CFG_ID not in", values, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdBetween(String value1, String value2) {
            addCriterion("CFG_ID between", value1, value2, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgIdNotBetween(String value1, String value2) {
            addCriterion("CFG_ID not between", value1, value2, "cfgId");
            return (Criteria) this;
        }

        public Criteria andCfgCodeIsNull() {
            addCriterion("CFG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCfgCodeIsNotNull() {
            addCriterion("CFG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCfgCodeEqualTo(String value) {
            addCriterion("CFG_CODE =", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeNotEqualTo(String value) {
            addCriterion("CFG_CODE <>", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeGreaterThan(String value) {
            addCriterion("CFG_CODE >", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CFG_CODE >=", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeLessThan(String value) {
            addCriterion("CFG_CODE <", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeLessThanOrEqualTo(String value) {
            addCriterion("CFG_CODE <=", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeLike(String value) {
            addCriterion("CFG_CODE like", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeNotLike(String value) {
            addCriterion("CFG_CODE not like", value, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeIn(List<String> values) {
            addCriterion("CFG_CODE in", values, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeNotIn(List<String> values) {
            addCriterion("CFG_CODE not in", values, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeBetween(String value1, String value2) {
            addCriterion("CFG_CODE between", value1, value2, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgCodeNotBetween(String value1, String value2) {
            addCriterion("CFG_CODE not between", value1, value2, "cfgCode");
            return (Criteria) this;
        }

        public Criteria andCfgValueIsNull() {
            addCriterion("CFG_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCfgValueIsNotNull() {
            addCriterion("CFG_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCfgValueEqualTo(String value) {
            addCriterion("CFG_VALUE =", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotEqualTo(String value) {
            addCriterion("CFG_VALUE <>", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueGreaterThan(String value) {
            addCriterion("CFG_VALUE >", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueGreaterThanOrEqualTo(String value) {
            addCriterion("CFG_VALUE >=", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueLessThan(String value) {
            addCriterion("CFG_VALUE <", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueLessThanOrEqualTo(String value) {
            addCriterion("CFG_VALUE <=", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueLike(String value) {
            addCriterion("CFG_VALUE like", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotLike(String value) {
            addCriterion("CFG_VALUE not like", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueIn(List<String> values) {
            addCriterion("CFG_VALUE in", values, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotIn(List<String> values) {
            addCriterion("CFG_VALUE not in", values, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueBetween(String value1, String value2) {
            addCriterion("CFG_VALUE between", value1, value2, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotBetween(String value1, String value2) {
            addCriterion("CFG_VALUE not between", value1, value2, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgDescIsNull() {
            addCriterion("CFG_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCfgDescIsNotNull() {
            addCriterion("CFG_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCfgDescEqualTo(String value) {
            addCriterion("CFG_DESC =", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescNotEqualTo(String value) {
            addCriterion("CFG_DESC <>", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescGreaterThan(String value) {
            addCriterion("CFG_DESC >", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescGreaterThanOrEqualTo(String value) {
            addCriterion("CFG_DESC >=", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescLessThan(String value) {
            addCriterion("CFG_DESC <", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescLessThanOrEqualTo(String value) {
            addCriterion("CFG_DESC <=", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescLike(String value) {
            addCriterion("CFG_DESC like", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescNotLike(String value) {
            addCriterion("CFG_DESC not like", value, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescIn(List<String> values) {
            addCriterion("CFG_DESC in", values, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescNotIn(List<String> values) {
            addCriterion("CFG_DESC not in", values, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescBetween(String value1, String value2) {
            addCriterion("CFG_DESC between", value1, value2, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andCfgDescNotBetween(String value1, String value2) {
            addCriterion("CFG_DESC not between", value1, value2, "cfgDesc");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNull() {
            addCriterion("RECORD_STATE is null");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNotNull() {
            addCriterion("RECORD_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStateEqualTo(String value) {
            addCriterion("RECORD_STATE =", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotEqualTo(String value) {
            addCriterion("RECORD_STATE <>", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThan(String value) {
            addCriterion("RECORD_STATE >", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_STATE >=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThan(String value) {
            addCriterion("RECORD_STATE <", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThanOrEqualTo(String value) {
            addCriterion("RECORD_STATE <=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLike(String value) {
            addCriterion("RECORD_STATE like", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotLike(String value) {
            addCriterion("RECORD_STATE not like", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateIn(List<String> values) {
            addCriterion("RECORD_STATE in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotIn(List<String> values) {
            addCriterion("RECORD_STATE not in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateBetween(String value1, String value2) {
            addCriterion("RECORD_STATE between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotBetween(String value1, String value2) {
            addCriterion("RECORD_STATE not between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("CREATE_USER_ID like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("CREATE_USER_ID not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIsNull() {
            addCriterion("MODIFY_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIsNotNull() {
            addCriterion("MODIFY_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdEqualTo(String value) {
            addCriterion("MODIFY_USER_ID =", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotEqualTo(String value) {
            addCriterion("MODIFY_USER_ID <>", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThan(String value) {
            addCriterion("MODIFY_USER_ID >", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFY_USER_ID >=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThan(String value) {
            addCriterion("MODIFY_USER_ID <", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThanOrEqualTo(String value) {
            addCriterion("MODIFY_USER_ID <=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLike(String value) {
            addCriterion("MODIFY_USER_ID like", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotLike(String value) {
            addCriterion("MODIFY_USER_ID not like", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIn(List<String> values) {
            addCriterion("MODIFY_USER_ID in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotIn(List<String> values) {
            addCriterion("MODIFY_USER_ID not in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdBetween(String value1, String value2) {
            addCriterion("MODIFY_USER_ID between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotBetween(String value1, String value2) {
            addCriterion("MODIFY_USER_ID not between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
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