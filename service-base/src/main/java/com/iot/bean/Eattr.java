package com.iot.bean;

import java.io.Serializable;

public class Eattr implements Serializable {
    private Integer id;

    private String item;

    private Integer sensorid;

    private String protocol;

    private String type;

    private String unit;

    private String thresholdl;

    private String thresholdm;

    private String thresholdh;

    private String note;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public Integer getSensorid() {
        return sensorid;
    }

    public void setSensorid(Integer sensorid) {
        this.sensorid = sensorid;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getThresholdl() {
        return thresholdl;
    }

    public void setThresholdl(String thresholdl) {
        this.thresholdl = thresholdl == null ? null : thresholdl.trim();
    }

    public String getThresholdm() {
        return thresholdm;
    }

    public void setThresholdm(String thresholdm) {
        this.thresholdm = thresholdm == null ? null : thresholdm.trim();
    }

    public String getThresholdh() {
        return thresholdh;
    }

    public void setThresholdh(String thresholdh) {
        this.thresholdh = thresholdh == null ? null : thresholdh.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}