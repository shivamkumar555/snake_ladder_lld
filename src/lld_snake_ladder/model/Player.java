package lld_snake_ladder.model;

public class Player {
    String name;
    int position = 1;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
