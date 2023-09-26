package org.marsrover.mission;

import org.marsrover.surface.Surface;
import org.marsrover.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Mission {

    private final String missionName;

    private Surface surface;

    private final List<Vehicle> missionVehicles;

    public Mission(String missionName) {
        this.missionName = missionName;
        missionVehicles = new ArrayList<>();
    }

    public String getMissionName() {
        return missionName;
    }

    public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public Vehicle getMissionVehicle(int vehicleId) {
        return missionVehicles.get(vehicleId);
    }

    public void setMissionVehicle(Vehicle vehicle) {
        if (surface != null) {
            vehicle.setNavigableSurface(surface);
        }
        missionVehicles.add(vehicle);
    }

    public List<Vehicle> getMissionVehicles() {
        return missionVehicles;
    }

}
