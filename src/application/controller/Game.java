package application.controller;

import application.ZombieDice;
import application.model.Difficulty;
import application.model.dice.Die;
import application.model.dice.DieColor;
import application.model.player.Player;
import application.view.Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Game {
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;
    public static final int DICE_PER_ROLL = 3;
    public static final int BRAINS_TO_WIN = 13;

    private Difficulty difficulty;
    private final List<Player> players;
    private int playerCount;

    private List<Die> cup;

    private Player winner;

    public Game(){
        difficulty = Difficulty.EASY;
        players = new ArrayList<>();
        playerCount = MIN_PLAYERS;
    }

    public void start(){
        fillCup();

        ZombieDice.getInstance().setInterface(Interface.GAME);
    }

    public void fillCup(){
        cup = new ArrayList<>();

        for(int i = 0; i < difficulty.getGreenDices(); i++){
            cup.add(new Die(DieColor.GREEN));
        }

        for(int i = 0; i < difficulty.getYellowDices(); i++){
            cup.add(new Die(DieColor.YELLOW));
        }

        for(int i = 0; i < difficulty.getRedDices(); i++){
            cup.add(new Die(DieColor.RED));
        }
    }

    public List<Die> pickDice(int count){
        List<Die> dice = new ArrayList<>();

        if(count <= cup.size()){
            Collections.shuffle(cup);

            for(int i = 0; i < count; i++){
                dice.add(cup.remove(0));
            }
        }

        return dice;
    }

    public boolean hasEnoughDice(int count){
        return cup.size() >= count;
    }

    public boolean isFinished(){
        return players.stream().anyMatch(p -> p.getBrains() >= BRAINS_TO_WIN);
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

    public List<Die> getCup() {
        return cup;
    }

    public Optional<Player> getWinner() {
        return Optional.ofNullable(winner);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}