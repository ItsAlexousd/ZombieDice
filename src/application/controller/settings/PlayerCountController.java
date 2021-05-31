package application.controller.settings;

import application.ZombieDice;
import application.controller.Game;
import application.view.ScreenLayout;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerCountController implements Initializable {
    private int count;

    @FXML
    private Pane pane;

    @FXML
    private Label playerCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count = Game.MIN_PLAYERS;
        setText(count);

        pane.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if(e.getCode() == KeyCode.ENTER){
                next();
                e.consume();
            }
        });
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