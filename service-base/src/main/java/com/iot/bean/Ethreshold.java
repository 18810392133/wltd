package com.iot.bean;

import java.io.Serializable;

public class Ethreshold implements Serializable {
    private Integer id;

    private String item;

    private Integer attrid;

    private Integer level;

    private Integer overtime;

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

    public Integer getAttrid() {
        return attrid;
    }

    public void setAttrid(Integer attrid) {
        this.attrid = attrid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOvertime() {
        return overtime;
    }

    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}