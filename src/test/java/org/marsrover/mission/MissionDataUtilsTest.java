package org.marsrover.mission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.marsrover.exception.InvalidCommandsException;
import org.marsrover.exception.InvalidCoordinatesException;
import org.marsrover.exception.InvalidLocationException;
import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;
import org.marsrover.location.Location;

import java.util.List;

public class MissionDataUtilsTest {

    @Test
    public void testValidateCoordinates_ValidCoordinates() throws Exception {
        String validCoordinates = "10 13";
        Coordinates coordinates = MissionDataUtils.validateCoordinates(validCoordinates);
        assertNotNull(coordinates);
        assertEquals(10, coordinates.getxAxis());
        assertEquals(13, coordinates.getyAxis());
    }

    @Test
    public void testValidateCoordinates_InvalidCoordinates() {
        String invalidCoordinates = "invalid";
        assertThrows(InvalidCoordinatesException.class, () -> {
            MissionDataUtils.validateCoordinates(invalidCoordinates);
        });
    }

    @Test
    public void testValidateLocation_ValidLocation() throws InvalidLocationException {
        String validLocation = "1 1 N";
        Location location = MissionDataUtils.validateLocation(validLocation);
        assertNotNull(location);
        assertEquals(1, location.getCurrentCoordinates().getxAxis());
        assertEquals(1, location.getCurrentCoordinates().getyAxis());
        assertEquals(Heading.NORTH, location.getCurrentHeading());
    }

    @Test
    public void testValidateLocation_InvalidLocation() {
        String invalidLocation = "invalid";
        assertThrows(InvalidLocationException.class, () -> {
            MissionDataUtils.validateLocation(invalidLocation);
        });
    }

    @Test
    public void testValidateVehicleCommands_ValidCommands() throws InvalidCommandsException {
        String validCommands = "LRM";
        List<Character> commandList = MissionDataUtils.validateVehicleCommands(validCommands);
        assertNotNull(commandList);
        assertEquals(3, commandList.size());
        assertEquals('L', commandList.get(0));
        assertEquals('R', commandList.get(1));
        assertEquals('M', commandList.get(2));
    }

    @Test
    public void testValidateVehicleCommands_InvalidCommands() {
        String invalidCommands = "invalid";
        assertThrows(InvalidCommandsException.class, () -> {
            MissionDataUtils.validateVehicleCommands(invalidCommands);
        });
    }
}
