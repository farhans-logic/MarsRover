package org.marsrover.location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.marsrover.location.Heading.EAST;
import static org.marsrover.location.Heading.NORTH;

class HeadingTest {

    @Test
    void testGetNorthEnumValueFromChar() {
        char testHeadingChar = 'N';
        Heading expected = NORTH;

        assertEquals(expected, Heading.valueOfHeading(testHeadingChar));

    }

    @Test
    void testGetWestEnumValueFromChar() {
        char testHeadingChar = 'W';
        Heading expected = Heading.WEST;

        assertEquals(expected, Heading.valueOfHeading(testHeadingChar));
    }

    @Test
    void testGetSouthEnumValueFromChar() {
        char testHeadingChar = 'S';
        Heading expected = Heading.SOUTH;

        assertEquals(expected, Heading.valueOfHeading(testHeadingChar));
    }

    @Test
    void testGetEastEnumValueFromChar() {
        char testHeadingChar = 'E';
        Heading expected = EAST;

        assertEquals(expected, Heading.valueOfHeading(testHeadingChar));
    }
}