package application.controller;

import application.ZombieDice;
import application.model.Difficulty;
import application.model.dice.Dice;
import application.model.dice.DiceColor;
import application.model.player.Player;
import application.view.ScreenLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;

    private Difficulty difficulty;
    private final List<Player> players;
    private int playerCount;

    private List<Dice> cup;

    public Game(){
        difficulty = Difficulty.EASY;
        players = new ArrayList<>();
        playerCount = MIN_PLAYERS;
    }

    public void start(){
        fillCup();

        ZombieDice.getInstance().setLayout(ScreenLayout.GAME);
    }

    public void fillCup(){
        cup = new ArrayList<>();

        for(int i = 0; i < difficulty.getGreenDices(); i++){
            cup.add(new Dice(DiceColor.GREEN));
        }

        for(int i = 0; i < difficulty.getYellowDices(); i++){
            cup.add(new Dice(DiceColor.YELLOW));
        }

        for(int i = 0; i < difficulty.getRedDices(); i++){
            cup.add(new Dice(DiceColor.RED));
        }
    }

    public List<Dice> pickDices(){
        List<Dice> dices = new ArrayList<>();

        Collections.shuffle(cup);
        dices.add(cup.get(0));
        dices.add(cup.get(1));
        dices.add(cup.get(2));

        return dices;
    }

    public boolean isFinished(){
        return players.stream().anyMatch(p -> p.getBrains() >= 13);
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

    public List<Dice> getCup() {
        return cup;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}