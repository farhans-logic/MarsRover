package org.marsrover.location;

import java.util.HashMap;
import java.util.Map;

public enum Heading {
    NORTH('N', 1),
    EAST('E', 1),
    SOUTH('S', -1),
    WEST('W', -1);

    private static final Map<Character, Heading> BY_VALUE = new HashMap<>();

    static {
        for (Heading h : values()) {
            BY_VALUE.put(h.value, h);
        }
    }

    public final char value;
    public final int coordAxisMovementValue;

    Heading(char value, int coordAxisMovementValue) {
        this.value = value;
        this.coordAxisMovementValue = coordAxisMovementValue;
    }

    public static Heading valueOfHeading(char shortHeading) {
        return BY_VALUE.get(shortHeading);
    }

}
