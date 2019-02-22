package com.iot.bean;

import java.io.Serializable;

public class Eroom implements Serializable {
    private Integer id;

    private String item;

    private Integer bimid;

    private String status;

    private Integer level;

    private String modelfile;

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

    public Integer getBimid() {
        return bimid;
    }

    public void setBimid(Integer bimid) {
        this.bimid = bimid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getModelfile() {
        return modelfile;
    }

    public void setModelfile(String modelfile) {
        this.modelfile = modelfile == null ? null : modelfile.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}