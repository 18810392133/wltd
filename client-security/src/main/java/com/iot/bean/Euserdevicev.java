package com.iot.bean;

public class Euserdevicev extends Euserdevice{
    private Euserv user;
    private Edevicev device;

    public Euserv getUser() {
        return user;
    }

    public void setUser(Euserv user) {
        this.user = user;
    }

    public Edevicev getDevice() {
        return device;
    }

    public void setDevice(Edevicev device) {
        this.device = device;
    }
}
