package com.shd.model.pojo;

import java.util.Date;

public class Zybm extends MybatisObject {
    private String zybmId;

    private String zybmName;

    private String pyAbb;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private String delState;

    public String getZybmId() {
        return zybmId;
    }

    public void setZybmId(String zybmId) {
        this.zybmId = zybmId;
    }

    public String getZybmName() {
        return zybmName;
    }

    public void setZybmName(String zybmName) {
        this.zybmName = zybmName;
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