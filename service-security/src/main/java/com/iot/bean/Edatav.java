package com.iot.bean;

public class Edatav extends Edata{
    private Edevicev device;

    private Eattrv attr;

    public Edevicev getDevice() {
        return device;
    }

    public void setDevice(Edevicev device) {
        this.device = device;
    }

    public Eattrv getAttr() {
        return attr;
    }

    public void setAttr(Eattrv attr) {
        this.attr = attr;
    }
}
