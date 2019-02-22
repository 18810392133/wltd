package com.iot.bean;

public class Eorderv extends Eorder{
    private Edatav data;

    private Euserv user;

    public Edatav getData() {
        return data;
    }

    public void setData(Edatav data) {
        this.data = data;
    }

    public Euserv getUser() {
        return user;
    }

    public void setUser(Euserv user) {
        this.user = user;
    }
}
