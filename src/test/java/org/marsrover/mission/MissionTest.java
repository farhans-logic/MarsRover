package org.marsrover.mission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marsrover.location.Coordinates;
import org.marsrover.surface.Surface;
import org.marsrover.vehicle.Rover;
import org.marsrover.vehicle.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

public class MissionTest {

    private Mission mission;

    @BeforeEach
    public void setUp() {
        mission = new Mission("TestMission");
    }

    @Test
    public void testGetMissionName() {
        assertEquals("TestMission", mission.getMissionName());
    }

    @Test
    public void testSetAndGetSurface() {
        Surface surface = new Surface(new Coordinates(10, 10));
        mission.setSurface(surface);
        assertEquals(surface, mission.getSurface());
    }

    @Test
    public void testSetAndGetMissionVehicle() {
        Vehicle vehicle = new Rover();
        mission.setMissionVehicle(vehicle);
        assertEquals(vehicle, mission.getMissionVehicle(0));
    }

    @Test
    public void testSetMissionVehicleWithSurface() {
        Surface surface = new Surface(new Coordinates(10, 10));
        mission.setSurface(surface);
        Vehicle vehicle = new Rover();
        mission.setMissionVehicle(vehicle);
        assertEquals(surface, vehicle.getNavigableSurface());
    }

    @Test
    public void testGetMissionVehicles() {
        Vehicle vehicle1 = new Rover();
        Vehicle vehicle2 = new Rover();
        mission.setMissionVehicle(vehicle1);
        mission.setMissionVehicle(vehicle2);

        assertEquals(2, mission.getMissionVehicles().size());
        assertTrue(mission.getMissionVehicles().contains(vehicle1));
        assertTrue(mission.getMissionVehicles().contains(vehicle2));
    }
}