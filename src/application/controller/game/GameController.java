package application.controller.game;

import application.ZombieDice;
import application.controller.Game;
import application.model.dice.Dice;
import application.model.player.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private final Game game = ZombieDice.getInstance().getGame();

    private Player currentPlayer;
    private int index;

    @FXML
    private Label text;

    @FXML
    private Label brains;
    @FXML
    private Label guns;
    @FXML
    private Label prints;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextPlayer();
    }

    @FXML
    public void roll(){
        List<Dice> dices = game.pickDices();

        System.out.println("---------------------------------------------------------");
        System.out.println("Résultat :");

        for(Dice d : dices){
            System.out.println("Dé " + d.getColor().getName() + " : " +  d.getRandomFace().getName());
        }
    }

    @FXML
    public void nextPlayer(){
        if(index >= game.getPlayers().size()){
            index = 0;
        }

        currentPlayer = game.getPlayers().get(index++);
        text.setText("C'est au tour de " + currentPlayer.getName());
        brains.setText(Integer.toString(currentPlayer.getBrains()));
    }

    private void setBrains(int brains){
        this.brains.setText(Integer.toString(brains));
    }

    private void setGuns(int guns){
        this.guns.setText(Integer.toString(guns));
    }

    private void setPrints(int prints){
        this.prints.setText(Integer.toString(prints));
    }
}