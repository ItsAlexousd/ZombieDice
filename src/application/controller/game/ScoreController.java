package application.controller.game;

import application.ZombieDice;
import application.view.Interface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {
    private final ZombieDice instance = ZombieDice.getInstance();

    @FXML
    private Label playerName;
    @FXML
    private Label score;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance.getGame().getWinner().ifPresent(winner -> {
            playerName.setText(winner.getName());
            score.setText("Score : " + winner.getBrains());
        });
    }

    @FXML
    public void replay(){
        instance.newGame();
        instance.setInterface(Interface.LOADING);
    }

    @FXML
    public void leaderboard(){
        // TODO Leaderboard in json
        // Not yet implemented
    }
}