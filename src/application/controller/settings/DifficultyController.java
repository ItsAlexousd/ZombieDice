package application.controller.settings;

import application.ZombieDice;
import application.model.Difficulty;
import application.view.ScreenLayout;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class DifficultyController implements Initializable {
    private Difficulty difficulty;

    @FXML
    private Pane pane;

    @FXML
    private CheckBox easy;
    @FXML
    private CheckBox medium;
    @FXML
    private CheckBox hard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setNewDifficulty(ZombieDice.getInstance().getGame().getDifficulty());
        addEvents(pane);
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

    private void addEvents(Node node){
        node.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if(e.getCode() == KeyCode.ENTER){
                next();
                e.consume();
            }

            if(e.getCode() == KeyCode.BACK_SPACE){
                back();
                e.consume();
            }
        });
    }
}