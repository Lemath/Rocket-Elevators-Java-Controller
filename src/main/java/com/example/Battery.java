package com.example;

import java.util.*;

public class Battery {
    public int ID;
    public String status;
    public List<Column> columnsList;
    public List<FloorRequestButton> floorRequestsButtonsList;
    char columnID;
    int floorRequestButtonID;

    public Battery(int id, int amountOfColumns, int amountOfFloors, int amountOfBasements, int amountOfElevatorPerColumn) {
        ID = id;
        status = "online";
        columnsList = new ArrayList<Column>();
        floorRequestsButtonsList = new ArrayList<FloorRequestButton>();
        columnID = 'A';
        floorRequestButtonID = 1;
        if (amountOfBasements > 0) {
            createBasementFloorRequestButtons(amountOfBasements);
            createBasementcolumn(amountOfBasements, amountOfElevatorPerColumn);
            amountOfColumns -= 1;
        }
        createFloorRequestButtons( amountOfFloors );
        createColumns(amountOfColumns, amountOfFloors, amountOfElevatorPerColumn);
    }

    public void createBasementcolumn(int amountOfBasements, int amountOfElevatorPerColumn) {
        List<Integer> servedFloors = new ArrayList<Integer>();
        int floor = -1;
        while (floor >= -amountOfBasements) {
            servedFloors.add(floor);
            floor -= 1;
        }
        columnsList.add(new Column(columnID, amountOfElevatorPerColumn, servedFloors, true, "online", amountOfBasements));
        columnID++;
    }

    public void createColumns(int amountOfColumns, int amountOfFloors, int amountOfElevatorPerColumn) {
        int amountOfFloorsPerColumn = (int) Math.round(Math.ceil(amountOfFloors / amountOfColumns));
        int floor = 1;
        for (int column = 1; column <= amountOfColumns; column++) {
            List<Integer> servedFloors = new ArrayList<Integer>();
            for (int i = 0; i < amountOfFloorsPerColumn; i++) {
                if (floor <= amountOfFloors) {
                    servedFloors.add(floor);
                    floor++;
                }
            }
            columnsList.add(new Column(columnID, amountOfElevatorPerColumn, servedFloors, false, "online", amountOfFloorsPerColumn));
            columnID++;
        }
    }

    public void createFloorRequestButtons(int amountOfFloors) {
        for (int buttonFloor = 1; buttonFloor <= amountOfFloors; buttonFloor++) {
            floorRequestsButtonsList.add(new FloorRequestButton(floorRequestButtonID, buttonFloor, "up", "OFF"));
            floorRequestButtonID++;
        }
    }

    public void createBasementFloorRequestButtons(int amountOfBasements) {
        for (int buttonFloor = -1; buttonFloor >= -amountOfBasements; buttonFloor--) {
            floorRequestsButtonsList.add(new FloorRequestButton(floorRequestButtonID, buttonFloor, "down", "OFF"));
            floorRequestButtonID++;
        }
    }

    public Column findBestColumn(int requestedFloor) {
        Column bestColumn = null;
        for (Column column : columnsList) {
            if (column.servedFloorsList.contains(requestedFloor)) {
                bestColumn = column;
            }
        }
        return bestColumn;
    }

    public Pair assignElevator(int requestedFloor, String direction) {
        Column column = findBestColumn(requestedFloor);
        Elevator elevator = column.findElevator(1, direction);
        elevator.addNewRequest(1);
        elevator.move();
        elevator.addNewRequest(requestedFloor);
        elevator.move();
        return new Pair(column, elevator);
    }
}
