package com.example;

public class Scenarios {

    Battery battery = new Battery(1, 4, 60, 6, 5);

    public Column moveAllElevators(Column column) {
        for (int i = 0; i < column.elevatorsList.size(); i++) {
            while (column.elevatorsList.get(i).floorRequestsList.size() != 0) {
                column.elevatorsList.get(i).move();
            }
        }
        return column;
    }

    public Pair scenario1() {

        Column column = battery.columnsList.get(1);

        column.elevatorsList.get(0).currentFloor = 20;
        column.elevatorsList.get(0).direction = "down";
        column.elevatorsList.get(0).status = "moving";
        column.elevatorsList.get(0).floorRequestsList.add(5);

        column.elevatorsList.get(1).currentFloor = 3;
        column.elevatorsList.get(1).direction = "up";
        column.elevatorsList.get(1).status = "moving";
        column.elevatorsList.get(1).floorRequestsList.add(15);

        column.elevatorsList.get(2).currentFloor = 13;
        column.elevatorsList.get(2).direction = "down";
        column.elevatorsList.get(2).status = "moving";
        column.elevatorsList.get(2).floorRequestsList.add(1);

        column.elevatorsList.get(3).currentFloor = 15;
        column.elevatorsList.get(3).direction = "down";
        column.elevatorsList.get(3).status = "moving";
        column.elevatorsList.get(3).floorRequestsList.add(2);

        column.elevatorsList.get(4).currentFloor = 6;
        column.elevatorsList.get(4).direction = "down";
        column.elevatorsList.get(4).status = "moving";
        column.elevatorsList.get(4).floorRequestsList.add(2);

        Pair chosenColumnAndElevator = battery.assignElevator(20, "up");
        chosenColumnAndElevator.column = moveAllElevators(chosenColumnAndElevator.column);
        return chosenColumnAndElevator;
    }

    public Pair scenario2() {

        Column column = battery.columnsList.get(2);

        column.elevatorsList.get(0).currentFloor = 1;
        column.elevatorsList.get(0).direction = "up";
        column.elevatorsList.get(0).status = "stopped";
        column.elevatorsList.get(0).floorRequestsList.add(21);

        column.elevatorsList.get(1).currentFloor = 23;
        column.elevatorsList.get(1).direction = "up";
        column.elevatorsList.get(1).status = "moving";
        column.elevatorsList.get(1).floorRequestsList.add(28);

        column.elevatorsList.get(2).currentFloor = 33;
        column.elevatorsList.get(2).direction = "down";
        column.elevatorsList.get(2).status = "moving";
        column.elevatorsList.get(2).floorRequestsList.add(1);

        column.elevatorsList.get(3).currentFloor = 40;
        column.elevatorsList.get(3).direction = "down";
        column.elevatorsList.get(3).status = "moving";
        column.elevatorsList.get(3).floorRequestsList.add(24);

        column.elevatorsList.get(4).currentFloor = 39;
        column.elevatorsList.get(4).direction = "down";
        column.elevatorsList.get(4).status = "moving";
        column.elevatorsList.get(4).floorRequestsList.add(1);

        Pair chosenColumnAndElevator = battery.assignElevator(36, "up");
        chosenColumnAndElevator.column = moveAllElevators(chosenColumnAndElevator.column);
        return chosenColumnAndElevator;
    }

    public Pair scenario3() {

        Column column = battery.columnsList.get(3);

        column.elevatorsList.get(0).currentFloor = 58;
        column.elevatorsList.get(0).direction = "down";
        column.elevatorsList.get(0).status = "moving";
        column.elevatorsList.get(0).floorRequestsList.add(1);

        column.elevatorsList.get(1).currentFloor = 50;
        column.elevatorsList.get(1).direction = "up";
        column.elevatorsList.get(1).status = "moving";
        column.elevatorsList.get(1).floorRequestsList.add(60);

        column.elevatorsList.get(2).currentFloor = 46;
        column.elevatorsList.get(2).direction = "up";
        column.elevatorsList.get(2).status = "moving";
        column.elevatorsList.get(2).floorRequestsList.add(58);

        column.elevatorsList.get(3).currentFloor = 1;
        column.elevatorsList.get(3).direction = "up";
        column.elevatorsList.get(3).status = "moving";
        column.elevatorsList.get(3).floorRequestsList.add(54);

        column.elevatorsList.get(4).currentFloor = 60;
        column.elevatorsList.get(4).direction = "down";
        column.elevatorsList.get(4).status = "moving";
        column.elevatorsList.get(4).floorRequestsList.add(1);

        Pair chosenColumnAndElevator = new Pair(column, null);
        chosenColumnAndElevator.elevator = column.requestElevator(54, "down");
        chosenColumnAndElevator.column = moveAllElevators(chosenColumnAndElevator.column);
        return chosenColumnAndElevator;
    }

    public Pair scenario4() {

        Column column = battery.columnsList.get(0);

        column.elevatorsList.get(0).currentFloor = -4;
        
        column.elevatorsList.get(1).currentFloor = 1;
        
        column.elevatorsList.get(2).currentFloor = -3;
        column.elevatorsList.get(2).direction = "down";
        column.elevatorsList.get(2).status = "moving";
        column.elevatorsList.get(2).floorRequestsList.add(-5);

        column.elevatorsList.get(3).currentFloor = -6;
        column.elevatorsList.get(3).direction = "up";
        column.elevatorsList.get(3).status = "moving";
        column.elevatorsList.get(3).floorRequestsList.add(1);

        column.elevatorsList.get(4).currentFloor = -1;
        column.elevatorsList.get(4).direction = "down";
        column.elevatorsList.get(4).status = "moving";
        column.elevatorsList.get(4).floorRequestsList.add(-6);

        Pair chosenColumnAndElevator = new Pair(column, null);
        chosenColumnAndElevator.elevator = column.requestElevator(-3, "up");
        column = moveAllElevators(column);
        return chosenColumnAndElevator;
    }

    public void run(int scenarioNumber) {
        switch (scenarioNumber) {
            case 1:
                scenario1();
                break;
            case 2:
                scenario2();
                break;
            case 3:
                scenario3();
                break;
            case 4:
                scenario4();
                break;
            default:
                System.out.println("Invalid scenario number");
                break;
        }
    }
}
