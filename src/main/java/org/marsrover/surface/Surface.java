package org.marsrover.surface;

import org.marsrover.location.Coordinates;

import java.util.List;

public class Surface {
    private final Coordinates minSurfaceCoords;

    private final Coordinates maxSurfaceCoords;

    private List<Coordinates> obstacles;

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

    public List<Coordinates> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Coordinates> obstacles) {
        this.obstacles = obstacles;
    }

    public void updateObstacles(Coordinates obstacle) {
        this.obstacles.add(obstacle);
    }

    public void removeObstacle(Coordinates obstacle) {
        this.obstacles.remove(obstacle);
    }
}
