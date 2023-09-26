package org.marsrover.mission;

import org.marsrover.location.Location;
import org.marsrover.vehicle.Rover;
import org.marsrover.vehicle.Vehicle;

public class MissionControl {

    private Mission mission;

    private MissionData missionData;

    private boolean missionStarted;

    public void createNewMission(MissionData data) {
        this.missionData = data;
        mission = new Mission(missionData.getMissionName());
        missionStarted = false;
    }

    public Mission getMission() {
        return mission;
    }

    public void startMission(MissionData data) {
        this.missionData = data;
        getMission().setSurface(missionData.getSurface());
        missionStarted = true;
    }

    public boolean isMissionStarted() {
        return missionStarted;
    }

    public void addMissionRover() {
        Rover rover = new Rover();
        addMissionVehicle(rover);
    }

    private void addMissionVehicle(Vehicle vehicle) {
        mission.setMissionVehicle(vehicle);
    }

    public Vehicle getCurrentVehicle() {
        int vehicles = mission.getMissionVehicles().size();
        return mission.getMissionVehicle(vehicles - 1);
    }

    public void deployVehicleToLocation() {
        getCurrentVehicle().setLocation(missionData.getLocation());
    }

    public void issueVehicleCommands() {
        getCurrentVehicle().actionCommands(missionData.getMissionCommandList());
    }

    public Location showCurrentVehicleLocation() {
        return getCurrentVehicle().getLocation();
    }


}
