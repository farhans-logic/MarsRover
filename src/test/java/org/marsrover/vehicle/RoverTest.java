//package org.marsrover.vehicle;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.marsrover.location.Coordinates;
//import org.marsrover.location.Heading;
//import org.marsrover.location.Location;
//import org.marsrover.surface.Surface;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RoverTest {
//
//    Rover testRover;
//
//    String roverName = "TestRover";
//
//    @BeforeEach
//    void createRover() {
//        testRover = new Rover();
//    }
//
//    @AfterEach
//    void destroyRover() {
//        testRover = null;
//    }
//
//
//    @Test
//    void testRoverHeadingWestFromNorthWithLeftCommand() {
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.NORTH);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('L');
//        Heading expected = Heading.WEST;
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected, testRover.getLocation().getCurrentHeading());
//    }
//
//    @Test
//    void testRoverHeadingSouthFromWestWithLeftCommand() {
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.WEST);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('L');
//        Heading expected = Heading.SOUTH;
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected, testRover.getLocation().getCurrentHeading());
//    }
//
//    @Test
//    void testRoverHeadingEastFromNorthWithRightCommand() {
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.NORTH);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('R');
//        Heading expected = Heading.EAST;
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected, testRover.getLocation().getCurrentHeading());
//    }
//
//    @Test
//    void testRoverHeadingWestFromNorthWith3RightCommands() {
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.NORTH);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('R');
//        testCommands.add('R');
//        testCommands.add('R');
//        Heading expected = Heading.WEST;
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected, testRover.getLocation().getCurrentHeading());
//    }
//
//    @Test
//    void testRoverMovesByOneOnYAxisWhenHeadingNorthWithMoveCommand() {
//        Surface testSurface = new Surface(new Coordinates(9, 9));
//        testRover.setNavigableSurface(testSurface);
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.NORTH);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('M');
//        Coordinates expected = new Coordinates(5, 6);
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected.toString(), testRover.getLocation().getCurrentCoordinates().toString());
//    }
//
//    @Test
//    void testRoverMovesByOneOnXAxisWhenHeadingEastWithMoveCommand() {
//        Surface testSurface = new Surface(new Coordinates(9, 9));
//        testRover.setNavigableSurface(testSurface);
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.EAST);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('M');
//        Coordinates expected = new Coordinates(6, 5);
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected.toString(), testRover.getLocation().getCurrentCoordinates().toString());
//    }
//
//    @Test
//    void testRoverMovesByOneOnXAxisWhenHeadingWestWithMoveCommand() {
//        Surface testSurface = new Surface(new Coordinates(9, 9));
//        testRover.setNavigableSurface(testSurface);
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.WEST);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('M');
//        Coordinates expected = new Coordinates(4, 5);
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected.toString(), testRover.getLocation().getCurrentCoordinates().toString());
//    }
//
//    @Test
//    void testRoverMovesByOneOnYAxisWhenHeadingWestWithMoveCommand() {
//        Surface testSurface = new Surface(new Coordinates(9, 9));
//        testRover.setNavigableSurface(testSurface);
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.SOUTH);
//        testRover.setLocation(testLocation);
//        List<Character> testCommands = new ArrayList<>();
//        testCommands.add('M');
//        Coordinates expected = new Coordinates(5, 4);
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected.toString(), testRover.getLocation().getCurrentCoordinates().toString());
//    }
//
//    @Test
//    void testRoverMovesAndRotatesCorrectlyWithMultipleCommands() {
//        Surface testSurface = new Surface(new Coordinates(9, 9));
//        testRover.setNavigableSurface(testSurface);
//        Coordinates testCoords = new Coordinates(5, 5);
//        Location testLocation = new Location(testCoords, Heading.SOUTH);
//        testRover.setLocation(testLocation);
//        Character[] commands = {'L', 'L', 'M', 'R', 'R', 'M', 'M', 'M', 'R', 'M'};
//        List<Character> testCommands = Arrays.asList(commands);
//        Coordinates expected = new Coordinates(4, 3);
//        Heading expectedHeading = Heading.WEST;
//
//        testRover.actionCommands(testCommands);
//
//        assertEquals(expected.toString(), testRover.getLocation().getCurrentCoordinates().toString());
//        assertEquals(expectedHeading, testRover.getLocation().getCurrentHeading());
//    }}