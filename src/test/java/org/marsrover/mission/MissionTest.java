package org.marsrover.mission;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissionTest {

    @Test
    void testNewMissionSsCreated() {
        String testMissionName = "Test Mission";
        String expected = "Test Mission";

        Mission mission = new Mission(testMissionName);

        assertEquals(expected, mission.getMissionName());
    }

    @Test
    void testNewMissionHasNoVehicles() {
        String testMissionName = "Test Mission";
        int expected = 0;

        Mission mission = new Mission(testMissionName);

        assertEquals(expected, mission.getMissionVehicles().size());
    }

    @Test
    void testNewMissionHasNoMissionData() {
        String testMissionName = "Test Mission";
        int expected = 0;

        Mission mission = new Mission(testMissionName);

        assertEquals(expected, mission.getMissionDataList().size());
    }
}