package org.marsrover.surface;

import org.marsrover.location.Coordinates;

import java.util.List;

// TODO Refactor class into extendable class to create surface types
// TODO Add child surface types for Plateaus, Plains, Terrains, Spheroids
// TODO Add Obstacles including other vehicles on the surface
public class Surface {
    private final Coordinates minSurfaceCoords;

    private final Coordinates maxSurfaceCoords;

    private List<Obstacle> obstacles;

    public Surface(Coordinates maxSurfaceCoords) {
        this.minSurfaceCoords = new Coordinates(0, 0);
        this.maxSurfaceCoords = maxSurfaceCoords;
    }

    public Coordinates getMinSurfaceCoords() {
        return minSurfaceCoords;
    }

    public Coordinates getMaxSurfaceCoords() {
        return maxSurfaceCoords;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void updateObstacles(Obstacle obstacle) {
        this.obstacles.add(obstacle);
    }
}
