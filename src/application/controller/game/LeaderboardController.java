package application.controller.game;

import application.ZombieDice;
import application.model.player.BrainsComparator;
import application.model.player.Player;
import application.view.Interface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class LeaderboardController implements Initializable {
    @FXML
    private VBox box;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Player> sortedPlayers = ZombieDice.getInstance().getGame().getPlayers().stream().sorted(new BrainsComparator()).collect(Collectors.toList());

        int position = 1;

        for(Player player : sortedPlayers){
            Label label = new Label(position++ + " - " + player.getName() + " (" + player.getBrains() + ")");
            label.getStyleClass().add("leaderboard");
            box.getChildren().add(label);
        }
    }

    @FXML
    public void back(){
        ZombieDice.getInstance().setInterface(Interface.WINNER);
    }
}