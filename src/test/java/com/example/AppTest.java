package com.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestScenario1()
    {
        Battery battery = new Battery(1, 4, 60, 6, 5);
        Scenarios scenarios = new Scenarios();

        Column expectedColumn = battery.columnsList.get(1);
        Elevator expectedElevator = expectedColumn.elevatorsList.get(4);
        int userPosition = 1;
        int destination = 20;
        int[] expectedFinalPositions = new int[] { 5, 15, 1, 2, 20 };

        Pair chosenColumnAndElevator = scenarios.scenario1();
        Column chosenColumn = chosenColumnAndElevator.column;
        Elevator chosenElevator = chosenColumnAndElevator.elevator;

        Assert.assertEquals("Wrong column selected, expected Column " + expectedColumn.ID + ", got Column " + chosenColumn.ID, expectedColumn.ID, chosenColumn.ID);

        Assert.assertEquals("Wrong elevator selected, expected Elevator " + expectedElevator.ID + ", got Elevator " + expectedElevator.ID, expectedElevator.ID, chosenElevator.ID);

        Assert.assertTrue("No elevator was sent to pick up the user", chosenElevator.completedRequestsList.contains(userPosition));

        Assert.assertTrue("The user didn't reach its destination", chosenElevator.completedRequestsList.contains(userPosition) && chosenElevator.currentFloor == destination);

        for (int i = 0; i < chosenColumn.elevatorsList.size(); i++) {

            Assert.assertEquals("Elevator " + chosenColumn.elevatorsList.get(i).ID + " didn't finish at the correct floor, expected " + expectedFinalPositions[i] + ", got " + chosenColumn.elevatorsList.get(i).currentFloor, expectedFinalPositions[i], chosenColumn.elevatorsList.get(i).currentFloor);
        }
    }

    @Test
    public void TestScenario2()
    {
        Battery battery = new Battery(1, 4, 60, 6, 5);
        Scenarios scenarios = new Scenarios();

        Column expectedColumn = battery.columnsList.get(2);
        Elevator expectedElevator = expectedColumn.elevatorsList.get(0);
        int userPosition = 1;
        int destination = 36;
        int[] expectedFinalPositions = new int[] { 36, 28, 1, 24, 1 };

        Pair chosenColumnAndElevator = scenarios.scenario2();
        Column chosenColumn = chosenColumnAndElevator.column;
        Elevator chosenElevator = chosenColumnAndElevator.elevator;

        Assert.assertEquals("Wrong column selected, expected Column " + expectedColumn.ID + ", got Column " + chosenColumn.ID, expectedColumn.ID, chosenColumn.ID);

        Assert.assertEquals("Wrong elevator selected, expected Elevator " + expectedElevator.ID + ", got Elevator " + expectedElevator.ID, expectedElevator.ID, chosenElevator.ID);

        Assert.assertTrue("No elevator was sent to pick up the user", chosenElevator.completedRequestsList.contains(userPosition));

        Assert.assertTrue("The user didn't reach its destination", chosenElevator.completedRequestsList.contains(userPosition) && chosenElevator.currentFloor == destination);

        for (int i = 0; i < chosenColumn.elevatorsList.size(); i++) {

            Assert.assertEquals("Elevator " + chosenColumn.elevatorsList.get(i).ID + " didn't finish at the correct floor, expected " + expectedFinalPositions[i] + ", got " + chosenColumn.elevatorsList.get(i).currentFloor, expectedFinalPositions[i], chosenColumn.elevatorsList.get(i).currentFloor);
        }
    }

    @Test
    public void TestScenario3()
    {
        Scenarios scenarios = new Scenarios();

        Pair chosenColumnAndElevator = scenarios.scenario3();
        Column chosenColumn = chosenColumnAndElevator.column;
        Elevator chosenElevator = chosenColumnAndElevator.elevator;

        Elevator expectedElevator = chosenColumn.elevatorsList.get(0);
        int userPosition = 54;
        int destination = 1;
        int[] expectedFinalPositions = new int[] { 1, 60, 58, 54, 1 };

        Assert.assertEquals("Wrong elevator selected, expected Elevator " + expectedElevator.ID + ", got Elevator " + expectedElevator.ID, expectedElevator.ID, chosenElevator.ID);

        Assert.assertTrue("No elevator was sent to pick up the user", chosenElevator.completedRequestsList.contains(userPosition));

        Assert.assertTrue("The user didn't reach its destination", chosenElevator.completedRequestsList.contains(userPosition) && chosenElevator.currentFloor == destination);

        for (int i = 0; i < chosenColumn.elevatorsList.size(); i++) {

            Assert.assertEquals("Elevator " + chosenColumn.elevatorsList.get(i).ID + " didn't finish at the correct floor, expected " + expectedFinalPositions[i] + ", got " + chosenColumn.elevatorsList.get(i).currentFloor, expectedFinalPositions[i], chosenColumn.elevatorsList.get(i).currentFloor);
        }
    }

    @Test
    public void TestScenario4()
    {
        Scenarios scenarios = new Scenarios();

        Pair chosenColumnAndElevator = scenarios.scenario4();
        Column chosenColumn = chosenColumnAndElevator.column;
        Elevator chosenElevator = chosenColumnAndElevator.elevator;

        Elevator expectedElevator = chosenColumn.elevatorsList.get(3);
        int userPosition = -3;
        int destination = 1;
        int[] expectedFinalPositions = new int[] { -4, 1, -5, 1, -6 };

        Assert.assertEquals("Wrong elevator selected, expected Elevator " + expectedElevator.ID + ", got Elevator " + expectedElevator.ID, expectedElevator.ID, chosenElevator.ID);

        Assert.assertTrue("No elevator was sent to pick up the user", chosenElevator.completedRequestsList.contains(userPosition));

        Assert.assertTrue("The user didn't reach its destination", chosenElevator.completedRequestsList.contains(userPosition) && chosenElevator.currentFloor == destination);

        for (int i = 0; i < chosenColumn.elevatorsList.size(); i++) {

            Assert.assertEquals("Elevator " + chosenColumn.elevatorsList.get(i).ID + " didn't finish at the correct floor, expected " + expectedFinalPositions[i] + ", got " + chosenColumn.elevatorsList.get(i).currentFloor, expectedFinalPositions[i], chosenColumn.elevatorsList.get(i).currentFloor);
        }
    }


}
