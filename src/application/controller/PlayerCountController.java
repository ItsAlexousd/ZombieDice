package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerCountController implements Initializable {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 10;

    private int count;

    @FXML
    private Label playerCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count = MIN_PLAYERS;
        setText(count);
    }

    @FXML
    public void increment(){
        if(count < MAX_PLAYERS){
            setText(++count);
        }
    }

    @FXML
    public void decrement(){
        if(count > MIN_PLAYERS){
            setText(--count);
        }
    }

    @FXML
    public void next(){

    }

    private void setText(int count){
        playerCount.setText(Integer.toString(count));
    }
}