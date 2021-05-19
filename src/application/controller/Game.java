package application.controller;

import application.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;

    private final List<Player> players;
    private int playerCount;

    public Game(){
        players = new ArrayList<>();
        playerCount = MIN_PLAYERS;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}