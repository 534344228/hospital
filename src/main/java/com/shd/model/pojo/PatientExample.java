package com.shd.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientExample() {
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(String value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(String value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(String value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(String value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(String value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(String value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLike(String value) {
            addCriterion("patient_id like", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotLike(String value) {
            addCriterion("patient_id not like", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<String> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<String> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(String value1, String value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(String value1, String value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNull() {
            addCriterion("patient_name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("patient_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("patient_name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("patient_name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("patient_name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("patient_name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("patient_name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("patient_name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("patient_name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("patient_name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("patient_name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("patient_name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("patient_name not between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayIsNull() {
            addCriterion("patient_birthday is null");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayIsNotNull() {
            addCriterion("patient_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday =", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday <>", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("patient_birthday >", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday >=", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("patient_birthday <", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday <=", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("patient_birthday in", values, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("patient_birthday not in", values, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("patient_birthday between", value1, value2, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("patient_birthday not between", value1, value2, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIsNull() {
            addCriterion("patient_age is null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIsNotNull() {
            addCriterion("patient_age is not null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeEqualTo(Integer value) {
            addCriterion("patient_age =", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotEqualTo(Integer value) {
            addCriterion("patient_age <>", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeGreaterThan(Integer value) {
            addCriterion("patient_age >", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_age >=", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeLessThan(Integer value) {
            addCriterion("patient_age <", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeLessThanOrEqualTo(Integer value) {
            addCriterion("patient_age <=", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIn(List<Integer> values) {
            addCriterion("patient_age in", values, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotIn(List<Integer> values) {
            addCriterion("patient_age not in", values, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeBetween(Integer value1, Integer value2) {
            addCriterion("patient_age between", value1, value2, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_age not between", value1, value2, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidIsNull() {
            addCriterion("patient_genderId is null");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidIsNotNull() {
            addCriterion("patient_genderId is not null");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidEqualTo(String value) {
            addCriterion("patient_genderId =", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidNotEqualTo(String value) {
            addCriterion("patient_genderId <>", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidGreaterThan(String value) {
            addCriterion("patient_genderId >", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidGreaterThanOrEqualTo(String value) {
            addCriterion("patient_genderId >=", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidLessThan(String value) {
            addCriterion("patient_genderId <", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidLessThanOrEqualTo(String value) {
            addCriterion("patient_genderId <=", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidLike(String value) {
            addCriterion("patient_genderId like", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidNotLike(String value) {
            addCriterion("patient_genderId not like", value, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidIn(List<String> values) {
            addCriterion("patient_genderId in", values, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidNotIn(List<String> values) {
            addCriterion("patient_genderId not in", values, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidBetween(String value1, String value2) {
            addCriterion("patient_genderId between", value1, value2, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPatientGenderidNotBetween(String value1, String value2) {
            addCriterion("patient_genderId not between", value1, value2, "patientGenderid");
            return (Criteria) this;
        }

        public Criteria andPresIdIsNull() {
            addCriterion("pres_id is null");
            return (Criteria) this;
        }

        public Criteria andPresIdIsNotNull() {
            addCriterion("pres_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresIdEqualTo(String value) {
            addCriterion("pres_id =", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdNotEqualTo(String value) {
            addCriterion("pres_id <>", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdGreaterThan(String value) {
            addCriterion("pres_id >", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdGreaterThanOrEqualTo(String value) {
            addCriterion("pres_id >=", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdLessThan(String value) {
            addCriterion("pres_id <", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdLessThanOrEqualTo(String value) {
            addCriterion("pres_id <=", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdLike(String value) {
            addCriterion("pres_id like", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdNotLike(String value) {
            addCriterion("pres_id not like", value, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdIn(List<String> values) {
            addCriterion("pres_id in", values, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdNotIn(List<String> values) {
            addCriterion("pres_id not in", values, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdBetween(String value1, String value2) {
            addCriterion("pres_id between", value1, value2, "presId");
            return (Criteria) this;
        }

        public Criteria andPresIdNotBetween(String value1, String value2) {
            addCriterion("pres_id not between", value1, value2, "presId");
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