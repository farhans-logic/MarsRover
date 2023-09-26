package org.marsrover.mission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;
import org.marsrover.location.Location;
import org.marsrover.vehicle.Rover;

import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    private MissionControl missionControl;

    @BeforeEach
    void setUp() {
        missionControl = new MissionControl();
    }

    @Test
    void createNewMission_ShouldCreateMissionWithCorrectName() {
        // Arrange
        String missionName = "Test Mission Name";
        MissionData missionData = new MissionData();
        missionData.setMissionName(missionName);

        // Act
        missionControl.createNewMission(missionData);

        // Assert
        assertEquals(missionName, missionControl.getMission().getMissionName());
    }

    @Test
    void startMission_ShouldSetSurfaceAndMissionStarted() throws Exception {
        // Arrange
        String missionName = "Test Mission Name";
        MissionData missionData = new MissionData();
        missionData.setMissionName(missionName);
        missionData.setMaxSurFaceCoordinates("5 4");

        // Act
        missionControl.createNewMission(missionData);
        missionControl.startMission(missionData);

        // Assert
        assertNotNull(missionControl.getMission().getSurface());
        assertTrue(missionControl.isMissionStarted());
    }

    @Test
    void addMissionRover_ShouldAddRoverToMission() {
        // Arrange
        missionControl.createNewMission(new MissionData());

        // Act
        missionControl.addMissionRover();

        // Assert
        assertEquals(1, missionControl.getMission().getMissionVehicles().size());
        assertTrue(missionControl.getMission().getMissionVehicle(0) instanceof Rover);
    }

    @Test
    void deployVehicleToLocation_ShouldSetLocationForCurrentVehicle() throws Exception {
        // Arrange
        MissionData missionData = new MissionData();
        missionData.setMaxSurFaceCoordinates("5 4");
        missionData.setLocation("3 2 S");
        missionControl.createNewMission(missionData);
        missionControl.addMissionRover();
        missionControl.startMission(missionData);

        // Act
        missionControl.deployVehicleToLocation();

        // Assert
        Location vehicleLocation = missionControl.showCurrentVehicleLocation();
        assertNotNull(vehicleLocation);
        assertEquals(3, vehicleLocation.getCurrentCoordinates().getxAxis());
        assertEquals(2, vehicleLocation.getCurrentCoordinates().getyAxis());
        assertEquals(Heading.SOUTH, vehicleLocation.getCurrentHeading());
    }

    @Test
    void issueVehicleCommands_ShouldExecuteCommandsForCurrentVehicle() throws Exception {
        // Arrange
        MissionData missionData = new MissionData();
        missionData.setMaxSurFaceCoordinates("5 4");
        missionData.setLocation("3 2 S");
        missionData.setMissionCommands("LLMMRRR");
        missionControl.createNewMission(missionData);
        missionControl.addMissionRover();
        missionControl.startMission(missionData);
        missionControl.deployVehicleToLocation();

        // Act
        missionControl.issueVehicleCommands();

        // Assert
        Location vehicleLocation = missionControl.showCurrentVehicleLocation();
        assertNotNull(vehicleLocation);
        assertEquals(3, vehicleLocation.getCurrentCoordinates().getxAxis());
        assertEquals(2, vehicleLocation.getCurrentCoordinates().getyAxis());
        assertEquals(Heading.WEST, vehicleLocation.getCurrentHeading());
    }

    @Test
    void showCurrentVehicleLocation_ShouldReturnCurrentVehicleLocation() throws Exception {
        // Arrange
        MissionData missionData = new MissionData();
        missionData.setMaxSurFaceCoordinates("5 4");
        missionData.setLocation("3 2 S");
        missionControl.createNewMission(missionData);
        missionControl.startMission(missionData);
        missionControl.addMissionRover();
        missionControl.deployVehicleToLocation();

        // Act
        Location vehicleLocation = missionControl.showCurrentVehicleLocation();

        // Assert
        assertNotNull(vehicleLocation);
        assertEquals(3, vehicleLocation.getCurrentCoordinates().getxAxis());
        assertEquals(2, vehicleLocation.getCurrentCoordinates().getyAxis());
        assertEquals(Heading.SOUTH, vehicleLocation.getCurrentHeading());
    }
}
