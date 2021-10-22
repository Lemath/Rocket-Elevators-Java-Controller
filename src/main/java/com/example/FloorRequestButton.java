package com.example;

public class FloorRequestButton {

    public int ID;
    public int floor;
    public String status;
    public String direction;

    public FloorRequestButton(int id, int floor, String direction, String status) {
        this.ID = id;
        this.floor = floor;
        this.status = status;
        this.direction = direction;
    }
}