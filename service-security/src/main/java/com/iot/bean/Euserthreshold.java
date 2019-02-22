package com.iot.bean;

import java.io.Serializable;

public class Euserthreshold implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer thresholdid;

    private String note;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getThresholdid() {
        return thresholdid;
    }

    public void setThresholdid(Integer thresholdid) {
        this.thresholdid = thresholdid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}