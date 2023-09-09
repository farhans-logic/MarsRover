package org.marsrover.vehicle;

public abstract class AerialVehicle extends Vehicle {

    public AerialVehicle(String aerialVehicleName) {
        super(aerialVehicleName);
    }

    public abstract void fly();

    public abstract void land();

    public abstract void ascend();

    public abstract void descend();
}
