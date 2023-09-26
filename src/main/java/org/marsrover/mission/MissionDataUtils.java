package org.marsrover.mission;

import org.marsrover.exception.InvalidCommandsException;
import org.marsrover.exception.InvalidCoordinatesException;
import org.marsrover.exception.InvalidLocationException;
import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;
import org.marsrover.location.Location;

import java.util.ArrayList;
import java.util.List;

public final class MissionDataUtils {


    public static final String ALLOWABLE_COORDINATES = "\\d+\\s+\\d+";
    public static final String ALLOWABLE_COMMANDS = "^(?i)[LRM]+$";
    public static final String ALLOWABLE_LOCATION = "\\d+ \\d+ [NWSE]";

    public static final int FIRST_VALUE = 0;
    public static final int SECOND_VALUE = 1;
    public static int THIRD_VALUE = 2;

    private MissionDataUtils() {
    }

    public static Coordinates validateCoordinates(String coordinates) throws Exception {
//        String ALLOWABLE_COORDINATES = "\\d+ \\d+";

        if (coordinates.matches(ALLOWABLE_COORDINATES)) {

            String[] parts = coordinates.split(" ");
            int xValue = Integer.parseInt(parts[0]);
            int yValue = Integer.parseInt(parts[1]);

            return new Coordinates(xValue, yValue);
        } else {
            throw new InvalidCoordinatesException(
                    "Invalid Max surface coordinates input, acceptable format example: '10 13'");
        }
    }

    public static Location validateLocation(String location) throws InvalidLocationException {

        if (location.matches(ALLOWABLE_LOCATION)) {

            String[] values = location.split(" ");
            int xValue = Integer.parseInt(values[FIRST_VALUE]);
            int yValue = Integer.parseInt(values[SECOND_VALUE]);
            char headingChar = values[THIRD_VALUE].charAt(FIRST_VALUE);

            Heading heading = Heading.valueOfHeading(headingChar);
            if (heading == null) {
                throw new InvalidLocationException(
                        "Invalid vehicle heading character. Expected N, W, S, or E.");
            }

            Coordinates coordinates = new Coordinates(xValue, yValue);
            return new Location(coordinates, heading);
        } else {
            throw new InvalidLocationException(
                    "Invalid vehicle start Location values, the data format should be: 1 1 N");
        }
    }

    public static List<Character> validateVehicleCommands(String vehicleCommands) throws InvalidCommandsException {

        if (vehicleCommands.matches(ALLOWABLE_COMMANDS)) {

            List<Character> commandList = new ArrayList<>();
            for (char command : vehicleCommands.toCharArray()) {
                commandList.add(command);
            }
            return commandList;
        } else {

            throw new InvalidCommandsException(
                    "Invalid vehicle commands, the commands should only consist of letters: LRM");
        }
    }
}
