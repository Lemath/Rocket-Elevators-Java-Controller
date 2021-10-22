package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevator {

    public String ID;
    public String status;
    public int currentFloor;
    public Door door;
    public List<Integer> floorRequestsList;
    public List<Integer> completedRequestsList;
    public int screenDisplay;
    public String direction;
    public Boolean overweight;
    public Boolean overweightAlarm;

    public Elevator(String id, String status, int currentFloor) {

        this.ID = id;
        this.status = status;
        this.currentFloor = currentFloor;
        this.door = new Door(1, "closed");
        this.floorRequestsList = new ArrayList<Integer>();
        this.completedRequestsList = new ArrayList<Integer>();
        this.direction = "any";
        this.overweight = false;
        this.overweightAlarm = false;
        this.screenDisplay = this.currentFloor;
    }

    public void move() {

        while (this.floorRequestsList.size() > 0) {
            int destination = this.floorRequestsList.get(0);
            this.status = "moving";
            if (this.currentFloor < destination) {
                this.direction = "up";
                sortFloorList();
                while (this.currentFloor < destination) {
                    this.currentFloor += 1;
                    this.screenDisplay = this.currentFloor;
                }
            } 
            else if (this.currentFloor > destination) {
                this.direction = "down";
                sortFloorList();
                while (this.currentFloor > destination) {
                    this.currentFloor -= 1;
                    this.screenDisplay = this.currentFloor;
                }
            }
            this.status = "stopped";
            operateDoors();
            if (!this.completedRequestsList.contains(destination)) {
                this.completedRequestsList.add(0, destination);
            }
            this.floorRequestsList.remove(0);
        }
        this.status = "idle";
    }

    public void sortFloorList() {
        if (this.floorRequestsList.size() > 1) {
            Collections.sort(this.floorRequestsList);
            if (this.direction.equals("down")) {
                Collections.reverse(this.floorRequestsList);
            }
        }
    }

    public void operateDoors() {
        this.door.status = "opening";
        //wait 5 sec
        if (!isOverweight()) {
            this.door.status = "closing";
            if (!this.door.isObstructed()) {
                this.door.status = "closed";

            }
            else {
                while (isOverweight()) {
                    this.overweightAlarm = true;
                }
                this.overweightAlarm = false;
                operateDoors();
            }
        }
    }

    public void addNewRequest(int requestedFloor) {
        if (!this.floorRequestsList.contains(requestedFloor)) {
            this.floorRequestsList.add(0, requestedFloor);
        }
        if (this.currentFloor < requestedFloor) {
            this.direction = "up";
        }
        if (this.currentFloor > requestedFloor) {
            this.direction = "down";
        }
    }

    public Boolean isOverweight() {
        return this.overweight;
    }
}
