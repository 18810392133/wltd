package com.iot.bean;

public class Euserthresholdv extends Euserthreshold{
    private Euserv user;
    private Ethresholdv threshold;

    public Euserv getUser() {
        return user;
    }

    public void setUser(Euserv user) {
        this.user = user;
    }

    public Ethresholdv getThreshold() {
        return threshold;
    }

    public void setThreshold(Ethresholdv threshold) {
        this.threshold = threshold;
    }
}
