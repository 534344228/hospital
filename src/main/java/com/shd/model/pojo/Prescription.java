package com.shd.model.pojo;

import java.util.Date;

public class Prescription extends MybatisObject {
    private String prescriptionId;

    private Integer visits;

    private String iusage;

    private String pyAbb;

    private String treatmentCycle;

    private Date visitTime;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private String delState;

    private String prescriptionIntroduce;

    private String westernDiagnosis;

    private String pname;

    private String disease;

    private String medicalHistory;

    private String equipmentInspection;

    private String physicalExamination;

    private String westMedicines;

    private String medicines;

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public String getIusage() {
        return iusage;
    }

    public void setIusage(String iusage) {
        this.iusage = iusage;
    }

    public String getPyAbb() {
        return pyAbb;
    }

    public void setPyAbb(String pyAbb) {
        this.pyAbb = pyAbb;
    }

    public String getTreatmentCycle() {
        return treatmentCycle;
    }

    public void setTreatmentCycle(String treatmentCycle) {
        this.treatmentCycle = treatmentCycle;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDelState() {
        return delState;
    }

    public void setDelState(String delState) {
        this.delState = delState;
    }

    public String getPrescriptionIntroduce() {
        return prescriptionIntroduce;
    }

    public void setPrescriptionIntroduce(String prescriptionIntroduce) {
        this.prescriptionIntroduce = prescriptionIntroduce;
    }

    public String getWesternDiagnosis() {
        return westernDiagnosis;
    }

    public void setWesternDiagnosis(String westernDiagnosis) {
        this.westernDiagnosis = westernDiagnosis;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getEquipmentInspection() {
        return equipmentInspection;
    }

    public void setEquipmentInspection(String equipmentInspection) {
        this.equipmentInspection = equipmentInspection;
    }

    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination;
    }

    public String getWestMedicines() {
        return westMedicines;
    }

    public void setWestMedicines(String westMedicines) {
        this.westMedicines = westMedicines;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
}