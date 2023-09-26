package org.marsrover.vehicle;

import org.marsrover.location.Location;
import org.marsrover.surface.Surface;

public abstract class Vehicle implements Movable {

    private static long nextId = 0L;

    private final long id;

    private String vehicleName;

    private Location location;

    private Surface navigableSurface;

    public Vehicle() {
        this.id = nextId++;
        this.vehicleName = "Vehicle" + id;
    }

    public long getId() {
        return id;
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

    public void setNavigableSurface(Surface surface) {
        this.navigableSurface = surface;
    }

}
