package com.iot.bean;

public class Edevicev extends Edevice{
    private Esensorv sensor;
    private Eroomv room;

    public Esensorv getSensor() {
        return sensor;
    }

    public void setSensor(Esensorv sensor) {
        this.sensor = sensor;
    }

    public Eroomv getRoom() {
        return room;
    }

    public void setRoom(Eroomv room) {
        this.room = room;
    }
}
