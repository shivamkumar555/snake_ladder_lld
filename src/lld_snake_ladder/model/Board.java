package lld_snake_ladder.model;

import lld_snake_ladder.enums.ObstacleType;

import java.util.*;

public class Board {

    private final int size;
    private final int sideLength;
    private final Cell[][] grid;

    public Board(int size) {
        this.size = size;
        this.sideLength = (int) Math.sqrt(size);
        this.grid = new Cell[sideLength][sideLength];

        int position = 1;
        boolean leftToRight = true;

        for(int i = sideLength - 1; i >= 0; i--){
            if(leftToRight) {
                for(int j = 0; j < sideLength; j++){
                    grid[i][j] = new Cell(position++);
                }
            } else {
                for(int j = sideLength - 1; j >= 0; j--){
                    grid[i][j] = new Cell(position++);
                }
            }
            leftToRight = !leftToRight;
        }


    }

    private int getRow(int position) {
        int row = (position - 1) / sideLength;
        return sideLength - 1 - row;
    }

    private int getCol(int position) {
        int row = getRow(position);
        int col = (position - 1) % sideLength;
        return (row % 2 == 0) ? sideLength - 1 - col : col;
    }

    private Cell getCell(int position){
        return grid[getRow(position)][getCol(position)];
    }

    public boolean addObstacle(Obstacle obstacle){
        Cell srcCell = getCell(obstacle.getSrc());
        Cell destCell = getCell(obstacle.getDest());

        if(srcCell.hasObstacle() || destCell.hasObstacle()){
            return false; //prevents overlapping obstacles
        }

        srcCell.setObstacle(obstacle);
        return true;
    }

    public int getNewPosition(Player player, int offset){
        int newPosition = player.getPosition() + offset;

        if(newPosition > size) {
            System.out.println("You are going out of the board! Better Luck next Time");
            return player.getPosition();
        }

        Cell cell = grid[getRow(newPosition)][getCol(newPosition)];
        int finalPosition = cell.getFinalPosition();

        if(finalPosition < newPosition){
            System.out.println("Oops! Snake has bitten " + player.getName());
        } else if(finalPosition > newPosition) {
            System.out.println("Congratulations! " + player.getName() + " moved up through a ladder");
        } else {
            System.out.println(player.getName() + " moved from " + player.getPosition() + " to "+newPosition);
        }

        return finalPosition;
    }

    public void printBoard(Queue<Player> players) {
        System.out.println("\nCurrent Board State:\n");

        // Map position -> player  names
        Map<Integer, List<String>> playerMap = new HashMap<>();
        for (Player p : players) {
            playerMap
                    .computeIfAbsent(p.getPosition(), k -> new ArrayList<>())
                    .add(p.getName());
        }

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {

                Cell cell = grid[i][j];
                int pos = cell.getPosition();
                String cellText;

                // 🎯 Priority: Player > Obstacle > Number

                if (playerMap.containsKey(pos)) {
                    cellText = String.join(",", playerMap.get(pos));
                } else if (cell.hasObstacle()) {
                    if (cell.getObstacle().getObstacleType() == ObstacleType.SNAKE) {
                        cellText = "🐍" + pos;
                    } else {
                        cellText = "🪜" + pos;
                    }
                } else {
                    cellText = String.valueOf(pos);
                }

                // fixed width for alignment
                System.out.printf("%-8s", cellText);
            }
            System.out.println("\n");
        }
    }

    public int getSize() {
        return size;
    }
}
