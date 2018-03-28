package com.shd.model.pojo;

import java.util.Date;

public class Medicine extends MybatisObject {
    private String medicineId;

    private String pinyinAbb;

    private String specs;

    private String unit;

    private String medicineName;

    private String medicineCharacter;

    private String classify;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private String delState;

    private String medicineIntroduce;

    private String notice;

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getPinyinAbb() {
        return pinyinAbb;
    }

    public void setPinyinAbb(String pinyinAbb) {
        this.pinyinAbb = pinyinAbb;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineCharacter() {
        return medicineCharacter;
    }

    public void setMedicineCharacter(String medicineCharacter) {
        this.medicineCharacter = medicineCharacter;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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

    public String getMedicineIntroduce() {
        return medicineIntroduce;
    }

    public void setMedicineIntroduce(String medicineIntroduce) {
        this.medicineIntroduce = medicineIntroduce;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}