package application.controller;

import application.ZombieDice;
import application.screen.ScreenLayout;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingController implements Initializable {
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RotateTransition transition = new RotateTransition(Duration.seconds(4), image);
        transition.setByAngle(360 * 3);
        transition.play();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(4), e -> ZombieDice.getInstance().setLayout(ScreenLayout.PLAYER_COUNT)));
        timeline.play();
    }
}