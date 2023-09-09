package org.marsrover.mission;

import org.marsrover.surface.Surface;
import org.marsrover.vehicle.Rover;
import org.marsrover.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissionControl {

    public static final String DEFAULT_ROVER_NAME = "Rover";
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

    // TODO Create parameter validation annotations, remove exceptions
    // TODO Validate vehicle start position within surface
    public void setMissionData(String missionName, String maxSurfaceCoords,
                               String vehicleStartLocation, String vehicleCommands) throws Exception {

        if (maxSurfaceCoords.trim().replace(" ", "").length() != 2) {
            throw new Exception("Invalid Max surface coordinates input, acceptable: 1 1");
        } else if (vehicleStartLocation.trim().replace(" ", "").length() != 3) {
            throw new Exception("Invalid vehicle start Location values, the data format should be: 1 1 N");
        } else if (!vehicleCommands.matches("^(?i)[LRM]+$")) {
            throw new Exception("Invalid vehicle commands, the commands should only consist letters: LRM");
        }
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

        if (!missionDataList.isEmpty())
            mission.getMissionDataList().forEach(d -> {
                String roverName = DEFAULT_ROVER_NAME + (missionDataList.indexOf(d) + 1);
                addMissionRover(missionName, roverName);
                Rover rover = (Rover) mission.getMissionVehicle(roverName);
                rover.setNavigableSurface(new Surface(d.getMaxSurFaceCoordinates()));
                try {
                    rover.deploy(d.getVehicleDeployCoordinates(), d.getVehicleDeployHeading());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("This mission vehicle has been lost");
                    return;
                }
                rover.actionCommands(d.getMissionCommandList());
                displayVehicleEndLocation(rover);
            });
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
