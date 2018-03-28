package com.shd.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrescriptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionExample() {
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

        public Criteria andPrescriptionIdIsNull() {
            addCriterion("prescription_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNotNull() {
            addCriterion("prescription_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdEqualTo(String value) {
            addCriterion("prescription_id =", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotEqualTo(String value) {
            addCriterion("prescription_id <>", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThan(String value) {
            addCriterion("prescription_id >", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThanOrEqualTo(String value) {
            addCriterion("prescription_id >=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThan(String value) {
            addCriterion("prescription_id <", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThanOrEqualTo(String value) {
            addCriterion("prescription_id <=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLike(String value) {
            addCriterion("prescription_id like", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotLike(String value) {
            addCriterion("prescription_id not like", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIn(List<String> values) {
            addCriterion("prescription_id in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotIn(List<String> values) {
            addCriterion("prescription_id not in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdBetween(String value1, String value2) {
            addCriterion("prescription_id between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotBetween(String value1, String value2) {
            addCriterion("prescription_id not between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andVisitsIsNull() {
            addCriterion("visits is null");
            return (Criteria) this;
        }

        public Criteria andVisitsIsNotNull() {
            addCriterion("visits is not null");
            return (Criteria) this;
        }

        public Criteria andVisitsEqualTo(Integer value) {
            addCriterion("visits =", value, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsNotEqualTo(Integer value) {
            addCriterion("visits <>", value, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsGreaterThan(Integer value) {
            addCriterion("visits >", value, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("visits >=", value, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsLessThan(Integer value) {
            addCriterion("visits <", value, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsLessThanOrEqualTo(Integer value) {
            addCriterion("visits <=", value, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsIn(List<Integer> values) {
            addCriterion("visits in", values, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsNotIn(List<Integer> values) {
            addCriterion("visits not in", values, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsBetween(Integer value1, Integer value2) {
            addCriterion("visits between", value1, value2, "visits");
            return (Criteria) this;
        }

        public Criteria andVisitsNotBetween(Integer value1, Integer value2) {
            addCriterion("visits not between", value1, value2, "visits");
            return (Criteria) this;
        }

        public Criteria andIusageIsNull() {
            addCriterion("iusage is null");
            return (Criteria) this;
        }

        public Criteria andIusageIsNotNull() {
            addCriterion("iusage is not null");
            return (Criteria) this;
        }

        public Criteria andIusageEqualTo(String value) {
            addCriterion("iusage =", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageNotEqualTo(String value) {
            addCriterion("iusage <>", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageGreaterThan(String value) {
            addCriterion("iusage >", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageGreaterThanOrEqualTo(String value) {
            addCriterion("iusage >=", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageLessThan(String value) {
            addCriterion("iusage <", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageLessThanOrEqualTo(String value) {
            addCriterion("iusage <=", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageLike(String value) {
            addCriterion("iusage like", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageNotLike(String value) {
            addCriterion("iusage not like", value, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageIn(List<String> values) {
            addCriterion("iusage in", values, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageNotIn(List<String> values) {
            addCriterion("iusage not in", values, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageBetween(String value1, String value2) {
            addCriterion("iusage between", value1, value2, "iusage");
            return (Criteria) this;
        }

        public Criteria andIusageNotBetween(String value1, String value2) {
            addCriterion("iusage not between", value1, value2, "iusage");
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

        public Criteria andTreatmentCycleIsNull() {
            addCriterion("Treatment_cycle is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleIsNotNull() {
            addCriterion("Treatment_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleEqualTo(String value) {
            addCriterion("Treatment_cycle =", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleNotEqualTo(String value) {
            addCriterion("Treatment_cycle <>", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleGreaterThan(String value) {
            addCriterion("Treatment_cycle >", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleGreaterThanOrEqualTo(String value) {
            addCriterion("Treatment_cycle >=", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleLessThan(String value) {
            addCriterion("Treatment_cycle <", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleLessThanOrEqualTo(String value) {
            addCriterion("Treatment_cycle <=", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleLike(String value) {
            addCriterion("Treatment_cycle like", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleNotLike(String value) {
            addCriterion("Treatment_cycle not like", value, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleIn(List<String> values) {
            addCriterion("Treatment_cycle in", values, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleNotIn(List<String> values) {
            addCriterion("Treatment_cycle not in", values, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleBetween(String value1, String value2) {
            addCriterion("Treatment_cycle between", value1, value2, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andTreatmentCycleNotBetween(String value1, String value2) {
            addCriterion("Treatment_cycle not between", value1, value2, "treatmentCycle");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNull() {
            addCriterion("visit_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNotNull() {
            addCriterion("visit_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEqualTo(Date value) {
            addCriterion("visit_time =", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotEqualTo(Date value) {
            addCriterion("visit_time <>", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThan(Date value) {
            addCriterion("visit_time >", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_time >=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThan(Date value) {
            addCriterion("visit_time <", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThanOrEqualTo(Date value) {
            addCriterion("visit_time <=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIn(List<Date> values) {
            addCriterion("visit_time in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotIn(List<Date> values) {
            addCriterion("visit_time not in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeBetween(Date value1, Date value2) {
            addCriterion("visit_time between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotBetween(Date value1, Date value2) {
            addCriterion("visit_time not between", value1, value2, "visitTime");
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