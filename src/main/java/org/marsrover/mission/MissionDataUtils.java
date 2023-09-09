package org.marsrover.mission;

import org.marsrover.location.Coordinates;

public final class MissionDataUtils {

    public static final int MAX_COORDS_INPUT_SIZE = 2;
    public static final int MAX_COORDS_HEADING_INPUT_SIZE = 3;
    public static final String ALLOWABLE_COMMANDS = "^(?i)[LRM]+$";

    public static final String SPACE = " ";
    public static final String NO_SPACE = "";

    public static final int FIRST_VALUE = 0;
    public static final int SECOND_VALUE = 1;
    public static int THIRD_VALUE = 2;

    public static final String DEFAULT_ROVER_NAME = "Rover";

    private MissionDataUtils() {
    }

    public static String sanitiseSpaceChars(String data) {
        return data.trim().replace(SPACE, NO_SPACE);
    }

    public static Coordinates extractCoordsFromData(String data) {
        String[] values = transformStringDataInputToArray(data);
        int xAxis = Integer.parseInt(values[FIRST_VALUE]);
        int yAxis = Integer.parseInt(values[SECOND_VALUE]);
        return new Coordinates(xAxis, yAxis);
    }

    public static char extractHeadingCharFromData(String data) {
        String[] values = transformStringDataInputToArray(data);
        return values[THIRD_VALUE].charAt(FIRST_VALUE);
    }

    public static String[] transformStringDataInputToArray(String data) {
        return sanitiseSpaceChars(data).split(NO_SPACE);
    }

    public static boolean invalidCoordsInputSize(String data) {
        return sanitiseSpaceChars(data).length() != MAX_COORDS_INPUT_SIZE;
    }

    public static boolean invalidCoordsHeadingInputSize(String data) {
        return sanitiseSpaceChars(data).length() != MAX_COORDS_HEADING_INPUT_SIZE;
    }

    public static boolean invalidCommands(String data) {
        return !sanitiseSpaceChars(data).matches(ALLOWABLE_COMMANDS);
    }

    public static void validateMissionDataInput(
            String maxSurfaceCoords,
            String vehicleStartLocation,
            String vehicleCommands) throws Exception {
        if (MissionDataUtils.invalidCoordsInputSize(maxSurfaceCoords)) {
            throw new Exception(
                    "Invalid Max surface coordinates input, acceptable: 1 1");
        } else if (MissionDataUtils.invalidCoordsHeadingInputSize(vehicleStartLocation)) {
            throw new Exception(
                    "Invalid vehicle start Location values, the data format should be: 1 1 N");
        } else if (MissionDataUtils.invalidCommands(vehicleCommands)) {
            throw new Exception(
                    "Invalid vehicle commands, the commands should only consist letters: LRM");
        }
    }
}
