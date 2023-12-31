package org.marsrover.vehicle;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;
import org.marsrover.location.Location;

import java.util.List;

public class Rover extends Vehicle implements Movable {

    @Override
    public void actionCommands(List<Character> actionCommands) {
        actionCommands.forEach(ac -> {
            switch (Command.valueOfCommand(ac)) {
                case LEFT:
                    rotate(Command.LEFT);
                    break;
                case RIGHT:
                    rotate(Command.RIGHT);
                    break;
                case MOVE:
                    try {
                        move(getLocation().getCurrentHeading());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        });
    }

    @Override
    public void deploy(Coordinates initialCoords, Heading initialheading) throws Exception {
        if (isNavigableCoordinates(initialCoords)) {
            setLocation(new Location(initialCoords, initialheading));
        } else {
            throw new Exception("Mayday: " + getVehicleName()
                    + " has been deployed outside navigable surface.");
        }
    }

    @Override
    public void move(Heading heading) throws Exception {
        Location location = getLocation();
        Coordinates current = location.getCurrentCoordinates();
        Coordinates next;
        switch (heading) {
            case NORTH:
            case SOUTH:
                next = new Coordinates(
                        current.getxAxis(),
                        current.getyAxis() + heading.coordAxisMovementValue);
                break;
            case EAST:
            case WEST:
                next = new Coordinates(
                        current.getxAxis() + heading.coordAxisMovementValue,
                        current.getyAxis());
                break;
            default:
                next = null;
        }

        if (next != null && isNavigableCoordinates(next)) {
            location.updateCurrentCoordinates(next);
        } else {
            throw new Exception("Invalid coordinates "
                    + "(" + next.getxAxis() + ", "
                    + next.getyAxis() + ")"
                    + ", " + getVehicleName()
                    + ", cannot move outside the navigable surface");
        }
    }

    @Override
    public void rotate(Command command) {
        switch (command) {
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
        }
    }

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

    public boolean isNavigableCoordinates(Coordinates coordinates) {
        Coordinates surFaceMin = getNavigableSurface().getMinSurfaceCoords();
        Coordinates surFaceMax = getNavigableSurface().getMaxSurfaceCoords();

        return coordinates.getxAxis() >= surFaceMin.getxAxis() &&
                coordinates.getxAxis() <= surFaceMax.getxAxis() &&
                coordinates.getyAxis() >= surFaceMin.getyAxis() &&
                coordinates.getyAxis() <= surFaceMax.getyAxis();
    }

}
