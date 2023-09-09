package org.marsrover.mission;

import org.marsrover.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mission {

    private String missionName;

    private List<MissionData> missionDataList;

    private Map<String, Vehicle> missionVehicles;

    public List<MissionData> getMissionDataList() {
        return missionDataList;
    }

    public void setMissionDataList(List<MissionData> missionDataList) {
        this.missionDataList = missionDataList;
    }

    public void updateMissionDataList(MissionData missionData) {
        this.missionDataList.add(missionData);
    }

    public Map<String, Vehicle> getMissionVehicles() {
        return missionVehicles;
    }

    public Mission(String missionName) {
        this.missionName = missionName;
        missionDataList = new ArrayList<>();
        missionVehicles = new HashMap<>();
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public Vehicle getMissionVehicle(String vehicleName) {
        return missionVehicles.get(vehicleName);
    }

    public void setMissionVehicles(Map<String, Vehicle> missionVehicles) {
        this.missionVehicles = missionVehicles;
    }

    public void updateMissionVehicles(Vehicle vehicle) {
        this.missionVehicles.put(vehicle.getVehicleName(), vehicle);
    }
}
