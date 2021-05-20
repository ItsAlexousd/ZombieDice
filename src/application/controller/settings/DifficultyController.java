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
        setNewDifficulty(ZombieDice.getInstance().getGame().getDifficulty());
    }

    @FXML
    public void easyClick(){
        setNewDifficulty(Difficulty.EASY);
    }

    @FXML
    public void mediumClick(){
        setNewDifficulty(Difficulty.MEDIUM);
    }

    @FXML
    public void hardClick(){
        setNewDifficulty(Difficulty.HARD);
    }

    @FXML
    public void next(){
        ZombieDice.getInstance().getGame().setDifficulty(difficulty);
        ZombieDice.getInstance().setLayout(ScreenLayout.PLAY);
    }

    @FXML
    public void back(){
        ZombieDice.getInstance().setLayout(ScreenLayout.PLAYER_COUNT);
    }

    private void setNewDifficulty(Difficulty difficulty){
        easy.setSelected(false);
        medium.setSelected(false);
        hard.setSelected(false);

        this.difficulty = difficulty;

        switch(difficulty){
            case EASY:
                easy.setSelected(true);
                break;

            case MEDIUM:
                medium.setSelected(true);
                break;

            case HARD:
                hard.setSelected(true);
                break;

            default:
                break;
        }
    }
}