package application.controller;

import application.model.Difficulty;
import application.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;

    private Difficulty difficulty;
    private final List<Player> players;
    private int playerCount;

    public Game(){
        difficulty = Difficulty.EASY;
        players = new ArrayList<>();
        playerCount = MIN_PLAYERS;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}