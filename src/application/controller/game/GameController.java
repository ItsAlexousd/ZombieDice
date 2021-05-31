package application.controller.game;

import application.ZombieDice;
import application.controller.Game;
import application.model.dice.Die;
import application.model.dice.DieFace;
import application.model.player.BrainsComparator;
import application.model.player.Player;
import application.view.Interface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class GameController implements Initializable {
    private final Game game = ZombieDice.getInstance().getGame();

    private List<Player> players;

    private Player currentPlayer;
    private int index;
    private int newBrains;

    private Map<Die, DieFace> dice;

    @FXML
    private Label text;

    @FXML
    private Label brains;

    @FXML
    private HBox box;

    @FXML
    private Button rollButton;
    @FXML
    private Button nextButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        players = new ArrayList<>(game.getPlayers());
        dice = new HashMap<>();
        nextPlayer();
    }

    @FXML
    public void roll(){
        box.getChildren().clear();

        Map<Die, DieFace> currentDice = new HashMap<>();
        List<Die> randomDice = new ArrayList<>();

        new ArrayList<>(dice.keySet()).stream().filter(die -> dice.get(die) == DieFace.PRINTS).forEach(die -> {
            dice.remove(die);
            randomDice.add(die);
        });

        int diceToPick = Game.DICE_PER_ROLL - randomDice.size();

        if(!game.hasEnoughDice(diceToPick)){
            game.getCup().addAll(dice.keySet());
            dice.clear();
        }

        randomDice.addAll(game.pickDice(diceToPick));

        for(Die die : randomDice){
            DieFace face = die.getRandomFace();
            currentDice.put(die, face);

            if(face == DieFace.BRAIN){
                newBrains++;
            }

            HBox dieBox = new HBox(10);
            dieBox.setAlignment(Pos.CENTER);

            ImageView dieImage = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(die.getColor().getPath()), "Die image must not be null")));
            ImageView faceImage = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(face.getPath()), "Die face image must not be null")));
            dieBox.getChildren().addAll(dieImage, faceImage);

            box.getChildren().add(dieBox);
        }

        dice.putAll(currentDice);
        enableButtons(true, true);

        if(dice.values().stream().filter(face -> face == DieFace.GUN).count() >= 3){
            newBrains = 0;
            enableButtons(false, true);
        }

        updateBrains();
    }

    @FXML
    public void nextPlayer(){
        box.getChildren().clear();

        if(newBrains > 0){
            currentPlayer.addBrains(newBrains);
        }

        game.getCup().addAll(dice.keySet());
        dice.clear();

        if(index >= players.size()){
            index = 0;

            if(game.isFinished()){
                List<Player> sortedPlayers = players.stream().sorted(new BrainsComparator()).collect(Collectors.toList());
                Player winner = sortedPlayers.get(0);

                sortedPlayers.stream().filter(player -> player.getBrains() < winner.getBrains()).forEach(player -> players.remove(player));

                if(players.size() == 1){
                    game.setWinner(winner);
                    ZombieDice.getInstance().setInterface(Interface.WINNER);
                    enableButtons(false, false);
                    return;
                }
            }
        }

        currentPlayer = players.get(index++);
        text.setText("C'est au tour de " + currentPlayer.getName());
        newBrains = 0;
        updateBrains();
        enableButtons(true, false);
    }

    private void updateBrains(){
        brains.setText(Integer.toString(currentPlayer.getBrains() + newBrains));
        brains.setTextFill(newBrains == 0 ? Color.WHITE : Color.web("#36f442"));
    }

    private void enableButtons(boolean roll, boolean next){
        rollButton.setDisable(!roll);
        nextButton.setDisable(!next);
    }
}