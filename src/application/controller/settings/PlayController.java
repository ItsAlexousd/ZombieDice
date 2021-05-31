package application.controller.settings;

import application.ZombieDice;
import application.controller.Game;
import application.view.ScreenLayout;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayController implements Initializable {
    @FXML
    private Pane pane;

    @FXML
    private Label playerCount;
    @FXML
    private Label difficulty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game game = ZombieDice.getInstance().getGame();
        playerCount.setText(game.getPlayerCount() + " Joueurs");
        difficulty.setText("Difficulté : " + game.getDifficulty().getName());

        addEvents(pane);
    }

    @FXML
    public void play(){
        ZombieDice.getInstance().getGame().start();
    }

    @FXML
    public void back(){
        ZombieDice.getInstance().setLayout(ScreenLayout.DIFFICULTY);
    }

    private void addEvents(Node node){
        node.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if(e.getCode() == KeyCode.ENTER){
                play();
                e.consume();
            }

            if(e.getCode() == KeyCode.BACK_SPACE){
                back();
                e.consume();
            }
        });
    }
}