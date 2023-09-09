package org.marsrover.surface;

import org.marsrover.location.Coordinates;

// TODO Incomplete New Feature Obstacles
// TODO Add Subtypes
public abstract class Obstacle {

    private String obstacleName;

    private String obstacleDescription;

    Coordinates obstacleCoordinates;

    public Obstacle(String obstacleName, Coordinates obstacleCoordinates) {
        this.obstacleName = obstacleName;
        this.obstacleCoordinates = obstacleCoordinates;
    }

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public Coordinates getObsticleCoordinates() {
        return obstacleCoordinates;
    }

    public void setObstacleCoordinates(Coordinates obstacleCoordinates) {
        this.obstacleCoordinates = obstacleCoordinates;
    }

    public String getObstacleDescription() {
        return obstacleDescription;
    }

    public void setObstacleDescription(String obstacleDescription) {
        this.obstacleDescription = obstacleDescription;
    }
}
