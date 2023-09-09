package org.marsrover.vehicle;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;
import org.marsrover.location.Location;
import org.marsrover.surface.Surface;

import java.util.List;

// TODO Refactor common behaviours from subclasses when new vehicle subtypes added
public abstract class Vehicle {
    private String vehicleName;

    private Location location;

    private Surface navigableSurface;

    private boolean moving;

    public Vehicle(String vehicleName) {
        setVehicleName(vehicleName);
    }

    public String getVehicleName() {
        return vehicleName;
    }

    protected void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Surface getNavigableSurface() {
        return navigableSurface;
    }

    public void setNavigableSurface(Surface navigableSurface) {
        this.navigableSurface = navigableSurface;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public abstract void actionCommands(List<Character> commands);

    public abstract void deploy(Coordinates initialCoords, Heading initialHeading) throws Exception;

    public abstract void move(Heading heading) throws Exception;

    public abstract void rotate(Command command);

    public void turnLeft() {
        switch (getLocation().getCurrentHeading()) {
            case NORTH:
                getLocation().updateCurrentHeading(Heading.WEST);
                break;
            case WEST:
                getLocation().updateCurrentHeading(Heading.SOUTH);
                break;
            case SOUTH:
                getLocation().updateCurrentHeading(Heading.EAST);
                break;
            case EAST:
                getLocation().updateCurrentHeading(Heading.NORTH);
                break;
            default:
                throw new RuntimeException("Invalid left command");
        }
    }

    public void turnRight() {
        switch (getLocation().getCurrentHeading()) {
            case NORTH:
                getLocation().updateCurrentHeading(Heading.EAST);
                break;
            case EAST:
                getLocation().updateCurrentHeading(Heading.SOUTH);
                break;
            case SOUTH:
                getLocation().updateCurrentHeading(Heading.WEST);
                break;
            case WEST:
                getLocation().updateCurrentHeading(Heading.NORTH);
                break;
            default:
                throw new RuntimeException("Invalid right command");
        }
    }

}
