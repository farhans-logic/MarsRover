package org.marsrover.vehicle;

import org.marsrover.App;

public abstract class Vehicle {
    private final long vehicleId;
    private String vehicleName;

    public Vehicle(String vehicleName) {
        this.vehicleId = App.VEHICLE_ID_GENERATOR.getAndDecrement();
        setVehicleName(vehicleName);
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    protected void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
