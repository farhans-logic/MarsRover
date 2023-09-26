package org.marsrover.mission;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Location;
import org.marsrover.surface.Surface;

import java.util.List;

import static org.marsrover.mission.MissionDataUtils.validateCoordinates;

public class MissionData {

    private String missionName;

    private Coordinates maxSurFaceCoordinates;

    private Location location;

    private List<Character> missionCommandList;

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public void setMaxSurFaceCoordinates(String data) throws Exception {
        this.maxSurFaceCoordinates = validateCoordinates(data);
    }

    public Surface getSurface() {
        return new Surface(maxSurFaceCoordinates);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(String data) throws Exception {
        this.location = MissionDataUtils.validateLocation(data);
    }

    public void setMissionCommands(String missionCommands) throws Exception {
        this.missionCommandList = MissionDataUtils.validateVehicleCommands(missionCommands);
    }

    public List<Character> getMissionCommandList() {
        return missionCommandList;
    }
}