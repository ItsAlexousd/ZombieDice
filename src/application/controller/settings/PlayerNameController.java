package application.controller.settings;

import application.ZombieDice;
import application.model.player.Player;
import application.view.ScreenLayout;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerNameController implements Initializable {
    @FXML
    private Label text;
    @FXML
    private TextField field;

    private int playerId;
    private int playerCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerId = 1;
        playerCount = ZombieDice.getInstance().getGame().getPlayerCount();

        field.setTextFormatter(new TextFormatter<>(change -> {
            if(change.getControlNewText().matches("[a-zA-Z]*")){
                return change;
            }

            return null;
        }));

        field.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if(e.getCode() == KeyCode.ENTER) {
                next();
                e.consume();
            }
        });
    }

    @FXML
    public void next(){
        if(field.getText().isEmpty()){
            return;
        }

        Player player = new Player(field.getText());
        ZombieDice.getInstance().getGame().getPlayers().add(player);

        if(playerId == playerCount){
            ZombieDice.getInstance().setLayout(ScreenLayout.DIFFICULTY);
            return;
        }

        playerId++;
        text.setText("Entrez le nom de Joueur " + playerId + " :");
        field.setText("");
    }
}