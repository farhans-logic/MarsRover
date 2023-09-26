package org.marsrover.vehicle;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;

import java.util.List;

public interface Movable {
    public void actionCommands(List<Character> actionCommands);

    public void deploy(Coordinates initialCoords, Heading initialheading) throws Exception;

    public void move(Heading heading) throws Exception;

    public void rotate(Command command);

    public void turnLeft();

    public void turnRight();
}
