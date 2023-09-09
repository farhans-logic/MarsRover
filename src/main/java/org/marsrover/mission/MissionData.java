package org.marsrover.mission;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;

import java.util.List;
import java.util.stream.Collectors;

import static org.marsrover.mission.MissionDataUtils.*;

public class MissionData {

    private Coordinates maxSurFaceCoordinates;

    private Coordinates vehicleDeployCoordinates;

    private Heading vehicleDeployHeading;

    private String missionCommands;

    private List<Character> missionCommandList;

    public Coordinates getMaxSurFaceCoordinates() {
        return maxSurFaceCoordinates;
    }

    public void setMaxSurFaceCoordinates(String data) {
        this.maxSurFaceCoordinates = extractCoordsFromData(data);
    }

    public Coordinates getVehicleDeployCoordinates() {
        return vehicleDeployCoordinates;
    }

    public Heading getVehicleDeployHeading() {
        return vehicleDeployHeading;
    }

    public void setVehicleDeployCoordsAndHeading(String data) {
        this.vehicleDeployCoordinates = extractCoordsFromData(data);
        this.vehicleDeployHeading = Heading
                .valueOfHeading(extractHeadingCharFromData(data));
    }

    public String getMissionCommands() {
        return missionCommands;
    }

    public void setMissionCommands(String missionCommands) {
        this.missionCommands = missionCommands.toUpperCase();
        this.missionCommandList = this.missionCommands.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }

    public List<Character> getMissionCommandList() {
        return missionCommandList;
    }

    @Override
    public String toString() {
        return "MissionData{" +
                "maxSurFaceCoordinates=" + maxSurFaceCoordinates +
                ", vehicleDeployCoordinates=" + vehicleDeployCoordinates +
                ", vehicleDeployHeading=" + vehicleDeployHeading +
                ", missionCommands='" + missionCommands + '\'' +
                '}';
    }
}
