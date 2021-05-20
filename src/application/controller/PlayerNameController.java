package application.controller;

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
                confirm();
                e.consume();
            }
        });
    }

    @FXML
    public void confirm(){
        if(field.getText().isEmpty()){
            return;
        }

        Player player = new Player(field.getText());
        ZombieDice.getInstance().getGame().getPlayers().add(player);

        if(playerId == playerCount){
            System.out.println("Liste des joueurs :");

            for(Player p : ZombieDice.getInstance().getGame().getPlayers()){
                System.out.println(" - " + p.getName());
            }

            ZombieDice.getInstance().setLayout(ScreenLayout.DIFFICULTY);
            return;
        }

        playerId++;
        text.setText("Saisir le nom de Joueur " + playerId + " :");
        field.setText(null);
    }
}