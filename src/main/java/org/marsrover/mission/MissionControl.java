package org.marsrover.mission;

import org.marsrover.surface.Surface;
import org.marsrover.vehicle.Rover;
import org.marsrover.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.marsrover.mission.MissionDataUtils.DEFAULT_ROVER_NAME;
import static org.marsrover.mission.MissionDataUtils.validateMissionDataInput;

public class MissionControl {

    private final Map<String, Mission> missions;

    public MissionControl() {
        missions = new HashMap<>();
    }

    public void createMission(String missionName) {
        Mission mission = new Mission(missionName);
        missions.put(missionName, mission);
    }

    public Mission getMission(String missionName) {
        return missions.get(missionName);
    }

    public void setMissionData(
            String missionName,
            String maxSurfaceCoords,
            String vehicleStartLocation,
            String vehicleCommands) throws Exception {

        validateMissionDataInput(
                maxSurfaceCoords,
                vehicleStartLocation,
                vehicleCommands);

        MissionData data = new MissionData();
        data.setMaxSurFaceCoordinates(maxSurfaceCoords);
        data.setVehicleDeployCoordsAndHeading(vehicleStartLocation);
        data.setMissionCommands(vehicleCommands);

        getMission(missionName).updateMissionDataList(data);
    }

    public void startMission(String missionName) {
        Mission mission = missions.get(missionName);
        List<MissionData> missionDataList =
                mission.getMissionDataList();

        if (!missionDataList.isEmpty()) {
            for (MissionData d : mission.getMissionDataList()) {
                String roverName = DEFAULT_ROVER_NAME + (missionDataList.indexOf(d) + 1);
                addMissionRover(missionName, roverName);
                Rover rover = (Rover) mission.getMissionVehicle(roverName);
                rover.setNavigableSurface(new Surface(d.getMaxSurFaceCoordinates()));

                try {
                    rover.deploy(d.getVehicleDeployCoordinates(), d.getVehicleDeployHeading());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("This mission vehicle has been lost");
                    continue;
                }

                rover.actionCommands(d.getMissionCommandList());
                displayVehicleEndLocation(rover);
            }
        }
    }

    public void addMissionRover(String missionName, String roverName) {
        Rover rover = new Rover(roverName);
        addMissionVehicle(missionName, rover);
    }

    private void addMissionVehicle(String missionName, Vehicle vehicle) {
        Mission mission = missions.get(missionName);
        mission.updateMissionVehicles(vehicle);
    }

    public void displayVehicleEndLocation(Vehicle vehicle) {
        System.out.println(vehicle.getVehicleName() + " Mission End Location:");
        System.out.println(vehicle.getLocation().toString());
        System.out.println(vehicle.getVehicleName() + " Mission Complete");
    }

}
