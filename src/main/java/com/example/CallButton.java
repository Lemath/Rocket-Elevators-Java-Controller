package com.example;

public class CallButton {
    
    public int floor;
    public int ID;
    public String status;
    public String direction;

    public CallButton(int id, int floor, String direction, String status) {
        this.ID = id;
        this.floor = floor;
        this.direction = direction;
        this.status = status;
    }

}
