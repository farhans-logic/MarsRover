package org.marsrover.location;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testNewLocationHasCoordsAndHeading() {
        Coordinates testCoords = new Coordinates(0, 0);
        Heading testHeading = Heading.NORTH;
        Location expected = new Location(new Coordinates(0, 0), Heading.NORTH);

        Location testLocation = new Location(testCoords, testHeading);

        assertEquals(expected.toString(), testLocation.toString());
    }

    @Test
    void testUpdateCurrentCoordinates() {
        Coordinates testCoordsInitial = new Coordinates(0, 0);
        Heading testHeading = Heading.NORTH;
        Location testLocation = new Location(testCoordsInitial, testHeading);
        Location expected = new Location(new Coordinates(1, 2), Heading.NORTH);

        Coordinates testCoordsUpdate = new Coordinates(1, 2);
        testLocation.updateCurrentCoordinates(testCoordsUpdate);

        assertEquals(expected.getCurrentCoordinates().toString(), testLocation.getCurrentCoordinates().toString());
    }

    @Test
    void testLocationHistoryRecordsAllCoordinates() {
        Coordinates testCoordsFirst = new Coordinates(0, 0);
        Coordinates testCoordsSecond = new Coordinates(1, 1);
        Coordinates testCoordsThird = new Coordinates(2, 1);
        Coordinates testCoordsForth = new Coordinates(2, 2);
        Heading testHeading = Heading.NORTH;
        int expected = 4;
        Coordinates expectedCoords = new Coordinates(2, 1);

        Location testLocation = new Location(testCoordsFirst, testHeading);
        testLocation.updateCurrentCoordinates(testCoordsSecond);
        testLocation.updateCurrentCoordinates(testCoordsThird);
        testLocation.updateCurrentCoordinates(testCoordsForth);

        assertEquals(expected, testLocation.getLocationHistory().size());
        assertEquals(expectedCoords.toString(), testLocation.getLocationHistory().get(2).toString());

    }
}