package lld_snake_ladder.model;

import lld_snake_ladder.enums.ObstacleType;

public abstract class Obstacle {
    int src;
    int dest;

    public Obstacle(int src, int dest){
        this.src = src;
        this.dest = dest;
    }

    public int movePlayer() {
        return dest;
    }

    public abstract ObstacleType getObstacleType();

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }
}
