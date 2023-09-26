//package org.marsrover.mission;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.marsrover.location.Coordinates;
//import org.marsrover.location.Heading;
//import org.marsrover.location.Location;
//import org.marsrover.vehicle.Rover;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MissionControlTest {
//
//    MissionControl testMissionControl;
//
//    @BeforeEach
//    void createMissionControl() {
//        testMissionControl = new MissionControl();
//    }
//
//    @AfterEach
//    void destroyMissionControl() {
//        testMissionControl = null;
//    }
//
//    @Test
//    void TestCreateMission() {
//        String testMissionName = "Test Mission Name";
//        String expected = "Test Mission Name";
//
//        testMissionControl.createMission(testMissionName);
//
//        assertEquals(expected, testMissionControl.getMission(testMissionName).getMissionName());
//    }
//
//    @Test
//    void TestMissionDataIsSetMissionDataCorrectly() throws Exception {
//        String testMissionName = "Test Mission Name";
//        String testInputLine1 = "5 4";
//        String testInputLine2 = "3 2 S";
//        String testInputLine3 = "LLMMRRR";
//        MissionData expected = new MissionData();
//        expected.setMaxSurFaceCoordinates("5 4");
//        expected.setVehicleDeployCoordsAndHeading("3 2 S");
//        expected.setMissionCommands("LLMMRRR");
//
//        testMissionControl.createMission(testMissionName);
//        testMissionControl.setMissionData(
//                testMissionName,
//                testInputLine1,
//                testInputLine2,
//                testInputLine3);
//
//        assertEquals(expected.toString(),
//                testMissionControl.getMission(testMissionName).getMissionDataList().get(0).toString());
//    }
//
//    @Test
//    void TestMissionDataIsSetMissionDataThrowsExceptionForInvalidSurfaceCoordsNumber() throws Exception {
//        String testExceptionMessage = null;
//        String testMissionName = "Test Mission Name";
//        String testInputLine1 = "    ";
//        String testInputLine2 = "3 2 S";
//        String testInputLine3 = "LLMMRRR";
//        String expected = "Invalid Max surface coordinates input, acceptable: 1 1";
//
//        try {
//            testMissionControl.createMission(testMissionName);
//            testMissionControl.setMissionData(
//                    testMissionName,
//                    testInputLine1,
//                    testInputLine2,
//                    testInputLine3);
//        } catch (Exception e) {
//            testExceptionMessage = e.getMessage();
//        }
//
//        assertEquals(expected, testExceptionMessage);
//    }
//
//    @Test
//    void TestMissionDataIsSetMissionDataThrowsExceptionForInvalidVehicleCoordsHeadingInput() throws Exception {
//        String testExceptionMessage = null;
//        String testMissionName = "Test Mission Name";
//        String testInputLine1 = "5 5";
//        String testInputLine2 = "3 2";
//        String testInputLine3 = "LLMMRRR";
//        String expected = "Invalid vehicle start Location values, the data format should be: 1 1 N";
//
//        try {
//            testMissionControl.createMission(testMissionName);
//            testMissionControl.setMissionData(
//                    testMissionName,
//                    testInputLine1,
//                    testInputLine2,
//                    testInputLine3);
//        } catch (Exception e) {
//            testExceptionMessage = e.getMessage();
//        }
//
//        assertEquals(expected, testExceptionMessage);
//    }
//
//    @Test
//    void TestMissionDataIsSetMissionDataThrowsExceptionForInvalidCommandsCharacters() throws Exception {
//        String testExceptionMessage = null;
//        String testMissionName = "Test Mission Name";
//        String testInputLine1 = "5 5";
//        String testInputLine2 = "3 2 E";
//        String testInputLine3 = "LLMMR0RR";
//        String expected = "Invalid vehicle commands, the commands should only consist letters: LRM";
//
//        try {
//            testMissionControl.createMission(testMissionName);
//            testMissionControl.setMissionData(
//                    testMissionName,
//                    testInputLine1,
//                    testInputLine2,
//                    testInputLine3);
//        } catch (Exception e) {
//            testExceptionMessage = e.getMessage();
//        }
//
//        assertEquals(expected, testExceptionMessage);
//    }
//
//    @Test
//    void testMissionStartsAndEndsWithExpectedCoordinates() throws Exception {
//        String testMissionName = "Test Mission Name";
//        String testInputLine1 = "5 4";
//        String testInputLine2 = "3 2 S";
//        String testInputLine3 = "LLMMRRR";
//        testMissionControl.createMission(testMissionName);
//        testMissionControl.setMissionData(
//                testMissionName,
//                testInputLine1,
//                testInputLine2,
//                testInputLine3);
//        Location expected = new Location(new Coordinates(3, 0), Heading.EAST);
//
//        testMissionControl.startMission(testMissionName);
//        Rover result = (Rover) testMissionControl.getMission(testMissionName).getMissionVehicle(DEFAULT_ROVER_NAME + 1);
//
//        assertEquals(expected.toString(), result.getLocation().toString());
//    }
//
//    @Test
//    void testMissionStartsButDeploysVehicleOutsideNavigableSurfaceAndVehicleHasNoLocation() throws Exception {
//        String testMissionName = "Test Mission Name";
//        String testInputLine1 = "5 4";
//        String testInputLine2 = "6 6 S";
//        String testInputLine3 = "LLMMRRR";
//        testMissionControl.createMission(testMissionName);
//        testMissionControl.setMissionData(
//                testMissionName,
//                testInputLine1,
//                testInputLine2,
//                testInputLine3);
//
//        testMissionControl.startMission(testMissionName);
//        Rover result = (Rover) testMissionControl.getMission(testMissionName).getMissionVehicle(DEFAULT_ROVER_NAME + 1);
//
//        assertNull(result.getLocation());
//    }
//
//}