package application.controller.settings;

import application.ZombieDice;
import application.controller.Game;
import application.view.ScreenLayout;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerCountController implements Initializable {
    @FXML
    private Label playerCount;

    private int count;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count = Game.MIN_PLAYERS;
        setText(count);
    }

    @FXML
    public void increment(){
        if(count < Game.MAX_PLAYERS){
            setText(++count);
        }
    }

    @FXML
    public void decrement(){
        if(count > Game.MIN_PLAYERS){
            setText(--count);
        }
    }

    @FXML
    public void next(){
        ZombieDice.getInstance().getGame().setPlayerCount(count);
        ZombieDice.getInstance().setLayout(ScreenLayout.PLAYER_NAME);
    }

    private void setText(int count){
        playerCount.setText(Integer.toString(count));
    }
}