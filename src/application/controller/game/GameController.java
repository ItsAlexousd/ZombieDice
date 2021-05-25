package application.controller.game;

import application.ZombieDice;
import application.controller.Game;
import application.model.dice.Die;
import application.model.dice.DieFace;
import application.model.player.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private final Game game = ZombieDice.getInstance().getGame();

    private Player currentPlayer;
    private int index;

    private Map<Die, DieFace> dice;

    @FXML
    private Label text;

    @FXML
    private Label brainsLabel;
    @FXML
    private Label gunsLabel;
    @FXML
    private Label printsLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextPlayer();
    }

    @FXML
    public void roll(){
        game.pickDices().forEach(die -> dice.put(die, die.getRandomFace()));

        System.out.println("---------------------------------------------------------");
        System.out.println("Résultat :");

        for(Die die : dice.keySet()){
            System.out.println("Dé " + die.getColor().getName() + " : " +  dice.get(die).getName());
        }

        if(dice.values().stream().allMatch(face -> face == DieFace.GUN)){
            System.out.println("BANG ! Fin du tour");

            // TODO next player

            game.getCup().addAll(dice.keySet());
        }
    }

    @FXML
    public void nextPlayer(){
        if(index >= game.getPlayers().size()){
            index = 0;
            // TODO next turn : check if finished
        }

        currentPlayer = game.getPlayers().get(index++);
        text.setText("C'est au tour de " + currentPlayer.getName());
        brainsLabel.setText(Integer.toString(currentPlayer.getBrains()));
        dice = new HashMap<>();
    }

    private void setBrains(int brains){
        brainsLabel.setText(Integer.toString(brains));
    }

    private void setGuns(int guns){
        gunsLabel.setText(Integer.toString(guns));
    }

    private void setPrints(int prints){
        printsLabel.setText(Integer.toString(prints));
    }
}