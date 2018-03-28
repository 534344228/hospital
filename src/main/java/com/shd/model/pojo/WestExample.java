package com.shd.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WestExample() {
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

        public Criteria andWestIdIsNull() {
            addCriterion("west_id is null");
            return (Criteria) this;
        }

        public Criteria andWestIdIsNotNull() {
            addCriterion("west_id is not null");
            return (Criteria) this;
        }

        public Criteria andWestIdEqualTo(String value) {
            addCriterion("west_id =", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdNotEqualTo(String value) {
            addCriterion("west_id <>", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdGreaterThan(String value) {
            addCriterion("west_id >", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdGreaterThanOrEqualTo(String value) {
            addCriterion("west_id >=", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdLessThan(String value) {
            addCriterion("west_id <", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdLessThanOrEqualTo(String value) {
            addCriterion("west_id <=", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdLike(String value) {
            addCriterion("west_id like", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdNotLike(String value) {
            addCriterion("west_id not like", value, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdIn(List<String> values) {
            addCriterion("west_id in", values, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdNotIn(List<String> values) {
            addCriterion("west_id not in", values, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdBetween(String value1, String value2) {
            addCriterion("west_id between", value1, value2, "westId");
            return (Criteria) this;
        }

        public Criteria andWestIdNotBetween(String value1, String value2) {
            addCriterion("west_id not between", value1, value2, "westId");
            return (Criteria) this;
        }

        public Criteria andWestNameIsNull() {
            addCriterion("west_name is null");
            return (Criteria) this;
        }

        public Criteria andWestNameIsNotNull() {
            addCriterion("west_name is not null");
            return (Criteria) this;
        }

        public Criteria andWestNameEqualTo(String value) {
            addCriterion("west_name =", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameNotEqualTo(String value) {
            addCriterion("west_name <>", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameGreaterThan(String value) {
            addCriterion("west_name >", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameGreaterThanOrEqualTo(String value) {
            addCriterion("west_name >=", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameLessThan(String value) {
            addCriterion("west_name <", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameLessThanOrEqualTo(String value) {
            addCriterion("west_name <=", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameLike(String value) {
            addCriterion("west_name like", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameNotLike(String value) {
            addCriterion("west_name not like", value, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameIn(List<String> values) {
            addCriterion("west_name in", values, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameNotIn(List<String> values) {
            addCriterion("west_name not in", values, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameBetween(String value1, String value2) {
            addCriterion("west_name between", value1, value2, "westName");
            return (Criteria) this;
        }

        public Criteria andWestNameNotBetween(String value1, String value2) {
            addCriterion("west_name not between", value1, value2, "westName");
            return (Criteria) this;
        }

        public Criteria andPyAbbIsNull() {
            addCriterion("py_abb is null");
            return (Criteria) this;
        }

        public Criteria andPyAbbIsNotNull() {
            addCriterion("py_abb is not null");
            return (Criteria) this;
        }

        public Criteria andPyAbbEqualTo(String value) {
            addCriterion("py_abb =", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbNotEqualTo(String value) {
            addCriterion("py_abb <>", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbGreaterThan(String value) {
            addCriterion("py_abb >", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbGreaterThanOrEqualTo(String value) {
            addCriterion("py_abb >=", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbLessThan(String value) {
            addCriterion("py_abb <", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbLessThanOrEqualTo(String value) {
            addCriterion("py_abb <=", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbLike(String value) {
            addCriterion("py_abb like", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbNotLike(String value) {
            addCriterion("py_abb not like", value, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbIn(List<String> values) {
            addCriterion("py_abb in", values, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbNotIn(List<String> values) {
            addCriterion("py_abb not in", values, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbBetween(String value1, String value2) {
            addCriterion("py_abb between", value1, value2, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andPyAbbNotBetween(String value1, String value2) {
            addCriterion("py_abb not between", value1, value2, "pyAbb");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNull() {
            addCriterion("modify_user is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("modify_user is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("modify_user =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("modify_user <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("modify_user >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("modify_user <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("modify_user <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLike(String value) {
            addCriterion("modify_user like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion("modify_user not like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("modify_user in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("modify_user not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("modify_user between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("modify_user not between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andDelStateIsNull() {
            addCriterion("del_state is null");
            return (Criteria) this;
        }

        public Criteria andDelStateIsNotNull() {
            addCriterion("del_state is not null");
            return (Criteria) this;
        }

        public Criteria andDelStateEqualTo(String value) {
            addCriterion("del_state =", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateNotEqualTo(String value) {
            addCriterion("del_state <>", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateGreaterThan(String value) {
            addCriterion("del_state >", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateGreaterThanOrEqualTo(String value) {
            addCriterion("del_state >=", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateLessThan(String value) {
            addCriterion("del_state <", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateLessThanOrEqualTo(String value) {
            addCriterion("del_state <=", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateLike(String value) {
            addCriterion("del_state like", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateNotLike(String value) {
            addCriterion("del_state not like", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateIn(List<String> values) {
            addCriterion("del_state in", values, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateNotIn(List<String> values) {
            addCriterion("del_state not in", values, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateBetween(String value1, String value2) {
            addCriterion("del_state between", value1, value2, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateNotBetween(String value1, String value2) {
            addCriterion("del_state not between", value1, value2, "delState");
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