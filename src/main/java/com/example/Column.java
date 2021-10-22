package com.example;

import java.util.ArrayList;
import java.util.List;

public class Column {
    public char ID;
    public String status;
    public List<Integer> servedFloorsList;;
    public Boolean isBasement;
    public List<Elevator> elevatorsList;
    public List<CallButton> callButtonsList;
    int callButtonID = 1;
    
    public Column(char id, int amountOfElevators, List<Integer> servedFloors, Boolean isBasement, String status, int amountOfFloors) {
        this.ID = id;
        this.status = status;
        this.servedFloorsList = servedFloors;
        this.isBasement = isBasement;
        this.elevatorsList = new ArrayList<Elevator>();
        this.callButtonsList = new ArrayList<CallButton>();
        createElevators(amountOfFloors, amountOfElevators);
        createCallButtons(amountOfFloors, isBasement);
    }

    public void createCallButtons(int amountOfFloors, Boolean isBasement) {
        
        if (this.isBasement) {
            for (int buttonFloor = -1; buttonFloor >= -amountOfFloors ; buttonFloor--) {
                this.callButtonsList.add(new CallButton(callButtonID, buttonFloor, "up", "OFF"));
                callButtonID++;
            }
        }
        else {
            for (int buttonFloor = 1; buttonFloor <= amountOfFloors; buttonFloor++) {
                this.callButtonsList.add(new CallButton(callButtonID, buttonFloor, "down", "OFF"));
                callButtonID++;
            }
        }
    }

    public void createElevators(int amountOfFloors, int amountOfElevators) {
        for (int elevatorID = 1; elevatorID <= amountOfElevators ; elevatorID++) {
            this.elevatorsList.add(new Elevator(Integer.toString(elevatorID), "idle", 1));
        }
    }

    public Elevator requestElevator(int userPosition, String direction) {
        Elevator elevator = findElevator(userPosition, direction);
        elevator.addNewRequest(userPosition);
        elevator.move();
        elevator.addNewRequest(1);
        elevator.move();
        return elevator;
    }

    public Elevator findElevator(int requestedFloor, String requestedDirection) {
        BestElevatorInfo bestElevatorInfo = new BestElevatorInfo();
        if (requestedFloor == 1) {
            for (Elevator elevator : elevatorsList) {
                int score;
                if (elevator.currentFloor == 1 && elevator.status == "stopped") {
                    score = 1;
                }
                else if (elevator.currentFloor == 1 && elevator.status == "idle") {
                    score = 2;
                }
                else if (1 > elevator.currentFloor && elevator.direction == "up") {
                    score = 3;
                }
                else if (1 < elevator.currentFloor && elevator.direction == "down") {
                    score = 3;
                }
                else if (elevator.status == "idle") {
                    score = 4;
                }
                else {
                    score = 5;
                }
                bestElevatorInfo = compareElevator(score, elevator, bestElevatorInfo, requestedFloor);
            }
        }
        else {
            for (Elevator elevator : elevatorsList) {
                int score;
                if (elevator.currentFloor == requestedFloor && elevator.status == "stopped" && elevator.direction == requestedDirection) {
                    score = 1;
                }
                else if (requestedFloor > elevator.currentFloor && elevator.direction == "up" && requestedDirection == "up") {
                    score = 2;
                }
                else if (requestedFloor < elevator.currentFloor && elevator.direction == "down" && requestedDirection == "down") {
                    score = 2;
                }
                else if (elevator.status == "idle") {
                    score = 4;
                }
                else {
                    score = 5;
                }
                bestElevatorInfo = compareElevator(score, elevator, bestElevatorInfo, requestedFloor);
            }
        }
        return bestElevatorInfo.bestElevator;
    }

    public BestElevatorInfo compareElevator(int score, Elevator elevator, BestElevatorInfo bestElevatorInfo, int requestedFloor) {
        if (score < bestElevatorInfo.bestScore) {
            bestElevatorInfo.bestScore = score;
            bestElevatorInfo.bestElevator = elevator;
            bestElevatorInfo.referenceGap = Math.abs(elevator.currentFloor - requestedFloor);
        }
        else if (bestElevatorInfo.bestScore == score) {
            int gap = Math.abs(elevator.currentFloor - requestedFloor);
            if (bestElevatorInfo.referenceGap > gap) {
                bestElevatorInfo.bestElevator = elevator;
                bestElevatorInfo.referenceGap = gap;
            }
        }
        return bestElevatorInfo;
    }
}
