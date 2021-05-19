package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerCountController {
    @FXML
    private Label playerCount;

    public void increment(){
        playerCount.setText(Integer.toString(getCount() + 1));
    }

    public void decrement(){
        playerCount.setText(Integer.toString(getCount() - 1));
    }

    private int getCount(){
        try {
            return Integer.parseInt(playerCount.getText());
        } catch(NumberFormatException ignored){
            return 2;
        }
    }
}