package org.marsrover.vehicle;

import org.marsrover.location.Coordinates;
import org.marsrover.location.Heading;

import java.util.List;

public class QuadCopter extends AerialVehicle {

    public QuadCopter(String quadCopterName) {
        super(quadCopterName);
    }

    @Override
    public void actionCommands(List<Character> commands) {

    }

    @Override
    public void deploy(Coordinates initialCoords, Heading heading) {

    }

    @Override
    public void move(Heading heading) {

    }

    @Override
    public void rotate(Command command) {

    }

    @Override
    public void fly() {

    }

    @Override
    public void land() {

    }

    @Override
    public void ascend() {

    }

    @Override
    public void descend() {

    }

}
