package com.hz.cmfz.entity;

import java.io.Serializable;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
public class Manager implements Serializable{
    private String mgrId;
    private String mgrName;
    private String mgrPwd;
    private String salt;
    private String mgrStatus;


    public String getMgrId() {
        return mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public String getMgrPwd() {
        return mgrPwd;
    }

    public String getSalt() {
        return salt;
    }

    public String getMgrStatus() {
        return mgrStatus;
    }

    public void setMgrId(String mgrId) {
        this.mgrId = mgrId;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public void setMgrPwd(String mgrPwd) {
        this.mgrPwd = mgrPwd;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setMgrStatus(String mgrStatus) {
        this.mgrStatus = mgrStatus;
    }

    public Manager() {
    }

    public Manager(String mgrId, String mgrName, String mgrPwd, String salt, String mgrStatus) {
        this.mgrId = mgrId;
        this.mgrName = mgrName;
        this.mgrPwd = mgrPwd;
        this.salt = salt;
        this.mgrStatus = mgrStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mgrId='" + mgrId + '\'' +
                ", mgrName='" + mgrName + '\'' +
                ", mgrPwd='" + mgrPwd + '\'' +
                ", salt='" + salt + '\'' +
                ", mgrStatus='" + mgrStatus + '\'' +
                '}';
    }
}
