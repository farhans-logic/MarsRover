package org.marsrover.location;

import java.util.ArrayList;
import java.util.List;

// TODO Refactor class to create subtypes for geo locations with 3 axis and longitude, latitude
public class Location {
    private Coordinates currentCoordinates;

    private Heading currentHeading;

    private final List<Coordinates> locationHistory;

    public Location(Coordinates coordinates, Heading heading) {
        this.currentCoordinates = coordinates;
        this.currentHeading = heading;
        locationHistory = new ArrayList<>();
        locationHistory.add(coordinates);
    }

    public Coordinates getCurrentCoordinates() {
        return currentCoordinates;
    }

    public void updateCurrentCoordinates(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
        updateLocationHistory(currentCoordinates);
    }

    public Heading getCurrentHeading() {
        return currentHeading;
    }

    public void updateCurrentHeading(Heading currentHeading) {
        this.currentHeading = currentHeading;
    }

    public List<Coordinates> getLocationHistory() {
        return locationHistory;
    }

    private void updateLocationHistory(Coordinates currentCoordinates) {
        this.locationHistory.add(currentCoordinates);
    }

    @Override
    public String toString() {
        return currentCoordinates.getxAxis() + " "
                + currentCoordinates.getyAxis() + " "
                + currentHeading.value;
    }
}
