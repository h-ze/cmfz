package com.hz.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
public class Sideshow implements Serializable{
    private String id;
    private String picName;
    private String description;
    private String picStatus;
    private Date picDate;

    public Sideshow() {
    }

    public Sideshow(String id, String picName, String description, String picStatus, Date picDate) {
        this.id = id;
        this.picName = picName;
        this.description = description;
        this.picStatus = picStatus;
        this.picDate = picDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(String picStatus) {
        this.picStatus = picStatus;
    }

    public Date getPicDate() {
        return picDate;
    }

    public void setPicDate(Date picDate) {
        this.picDate = picDate;
    }

    @Override
    public String toString() {
        return "SideshowDAO{" +
                "id='" + id + '\'' +
                ", picName='" + picName + '\'' +
                ", description='" + description + '\'' +
                ", picStatus='" + picStatus + '\'' +
                ", picDate=" + picDate +
                '}';
    }
}
