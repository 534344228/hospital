package com.shd.model.pojo;

import java.util.Date;

public class Chinese extends MybatisObject {
    private String chineseId;

    private String chineseName;

    private String pyAbb;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private String delState;

    public String getChineseId() {
        return chineseId;
    }

    public void setChineseId(String chineseId) {
        this.chineseId = chineseId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getPyAbb() {
        return pyAbb;
    }

    public void setPyAbb(String pyAbb) {
        this.pyAbb = pyAbb;
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
}