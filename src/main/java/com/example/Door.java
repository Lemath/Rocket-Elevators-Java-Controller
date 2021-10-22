package com.example;

public class Door {
    
    public int ID;
    public String status;
    public String sensorState;

    public Door(int id, String status) {
        this.ID = id;
        this.status = status;
        this.sensorState = "OFF";
    }

    public Boolean isObstructed() { return sensorState.equals("ON"); }
}
