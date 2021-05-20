package application.controller.settings;

import application.ZombieDice;
import application.model.Difficulty;
import application.view.ScreenLayout;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;

public class DifficultyController implements Initializable {
    @FXML
    private CheckBox easy;
    @FXML
    private CheckBox medium;
    @FXML
    private CheckBox hard;

    private Difficulty difficulty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        difficulty = Difficulty.EASY;
        easy.setSelected(true);
    }

    @FXML
    public void easyClick(){
        uncheck();
        easy.setSelected(true);
        difficulty = Difficulty.EASY;
    }

    @FXML
    public void mediumClick(){
        uncheck();
        medium.setSelected(true);
        difficulty = Difficulty.MEDIUM;
    }

    @FXML
    public void hardClick(){
        uncheck();
        hard.setSelected(true);
        difficulty = Difficulty.HARD;
    }

    @FXML
    public void confirm(){
        ZombieDice.getInstance().getGame().setDifficulty(difficulty);
        ZombieDice.getInstance().setLayout(ScreenLayout.PLAY);
    }

    private void uncheck(){
        easy.setSelected(false);
        medium.setSelected(false);
        hard.setSelected(false);
    }
}