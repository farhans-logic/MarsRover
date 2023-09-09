package org.marsrover.mission;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;

import java.util.ArrayList;
import java.util.List;

class MissionDataTest {

    MissionData testMissionDataObj;

    @BeforeEach
    void createMissionDataObj() {
        testMissionDataObj = new MissionData();
    }

    @AfterEach
    void destroyMissionDataObj() {
        testMissionDataObj = null;
    }

    @Test
    void testMaxSurFaceCoordinatesFromStringInput() {
        String testInput = "24";
        Coordinates expected = new Coordinates(2, 4);

        testMissionDataObj.setMaxSurFaceCoordinates(testInput);

        assertEquals(expected.toString(), testMissionDataObj.getMaxSurFaceCoordinates().toString());
    }

    @Test
    void testMaxSurFaceCoordinatesFromStringInputIgnoringSpacingBetweenValues() {
        String testInput = "      3        5               ";
        Coordinates expected = new Coordinates(3, 5);

        testMissionDataObj.setMaxSurFaceCoordinates(testInput);

        assertEquals(expected.toString(), testMissionDataObj.getMaxSurFaceCoordinates().toString());
    }

    @Test
    void testSetVehicleDeployCoordsAndHeading() {
        String testInput = "6 7 W";
        Coordinates expectedCoords = new Coordinates(6, 7);
        Heading expectedHeading = Heading.WEST;

        testMissionDataObj.setVehicleDeployCoordsAndHeading(testInput);

        assertEquals(expectedCoords.toString(), testMissionDataObj.getVehicleDeployCoordinates().toString());
        assertEquals(expectedHeading, testMissionDataObj.getVehicleDeployHeading());
    }

    @Test
    void testMissionCommandsSetToUpperCase() {
        String testCommandInput = "m";
        String expected = "M";

        testMissionDataObj.setMissionCommands(testCommandInput);

        assertEquals(expected, testMissionDataObj.getMissionCommands());
    }

    @Test
    void testMissionCommandsInputStringSetsUpperCaseCharacterList() {
        String testCommandInput = "mlw";
        List<Character> expectedList = new ArrayList<>();
        expectedList.add('M');
        expectedList.add('L');
        expectedList.add('W');

        testMissionDataObj.setMissionCommands(testCommandInput);

        assertEquals(expectedList, testMissionDataObj.getMissionCommandList());
        assertEquals(expectedList.size(), testMissionDataObj.getMissionCommandList().size());
    }

    @Test
    void testTransformStringIntsToCoordsUtilityMethod() {
        String testInputCoords = "2 3";

    }
}