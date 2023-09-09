package org.marsrover.location;

public class Coordinates {

    private final int xAxis;

    private final int yAxis;

    public Coordinates(int xValue, int yValue) {
        this.xAxis = xValue;
        this.yAxis = yValue;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    @Override
    public String toString() {
        return "( " + xAxis + ", " + yAxis + " )";
    }
}
