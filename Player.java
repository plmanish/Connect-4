package models;

public class Player {
    String name;
    int playerId;

    public Player(int id, String name) {
        this.playerId = id;
        this.name = name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }
}
