package lld_snake_ladder.factory;

import lld_snake_ladder.enums.ObstacleType;
import lld_snake_ladder.model.Ladder;
import lld_snake_ladder.model.Obstacle;
import lld_snake_ladder.model.Snake;

public class ObstacleFactory {

    public static Obstacle createObstacle(ObstacleType obstacleType, int up, int down){
        return switch (obstacleType){
            case SNAKE -> new Snake(up, down);
            case LADDER -> new Ladder(up,down);
            default -> throw new IllegalArgumentException("Invalid obstacle");
        };
    }
}
