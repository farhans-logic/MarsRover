package org.marsrover.location;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void testGetXAxis() {
        Coordinates testCoords;
        int expected = 3;

        testCoords = new Coordinates(3, 5);

        assertEquals(expected, testCoords.getxAxis());
    }

    @Test
    void testGetYAxis() {
        Coordinates testCoords;
        int expected = 5;

        testCoords = new Coordinates(3, 5);

        assertEquals(expected, testCoords.getyAxis());
    }
}