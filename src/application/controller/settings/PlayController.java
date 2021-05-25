package application.controller.settings;

import application.ZombieDice;
import application.controller.Game;
import application.view.ScreenLayout;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayController implements Initializable {
    @FXML
    private Label playerCount;
    @FXML
    private Label difficulty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game game = ZombieDice.getInstance().getGame();
        playerCount.setText(game.getPlayerCount() + " Joueurs");
        difficulty.setText("Difficulté : " + game.getDifficulty().getName());
    }

    @FXML
    public void play(){
        ZombieDice.getInstance().getGame().start();
    }

    @FXML
    public void back(){
        ZombieDice.getInstance().setLayout(ScreenLayout.DIFFICULTY);
    }
}