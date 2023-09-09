package org.marsrover.mission;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;

import java.util.List;
import java.util.stream.Collectors;

public class MissionData {

    public final int FIRST_VALUE = 0;
    public final int SECOND_VALUE = 1;
    public final int THIRD_VALUE = 2;


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

    private Coordinates extractCoordsFromData(String data) {
        String[] values = transformStringDataInputToArray(data);
        int xAxis = Integer.parseInt(values[FIRST_VALUE]);
        int yAxis = Integer.parseInt(values[SECOND_VALUE]);
        return new Coordinates(xAxis, yAxis);
    }

    private char extractHeadingCharFromData(String data) {
        String[] values = transformStringDataInputToArray(data);
        return values[THIRD_VALUE].charAt(FIRST_VALUE);
    }

    private String[] transformStringDataInputToArray(String data) {
        return data.trim()
                .replace(" ", "")
                .split("");
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
