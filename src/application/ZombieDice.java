package application;

import application.controller.Game;
import application.view.Interface;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ZombieDice extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private static ZombieDice instance;
    private Stage stage;

    private Game game;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        game = new Game();
        stage = primaryStage;

        Parent root = getInterface(Interface.LOADING);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("view/style.css"), "Style CSS must not be null").toExternalForm());
        primaryStage.setScene(scene);

        // Center the window on the screen
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((bounds.getWidth() - WIDTH) / 2);
        primaryStage.setY((bounds.getHeight() - HEIGHT) / 2);

        primaryStage.setTitle("Zombie Dice");
        primaryStage.getIcons().add(new Image("img/icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setInterface(Interface i){
        try {
            stage.getScene().setRoot(getInterface(i));
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    private Parent getInterface(Interface i) throws IOException {
        return FXMLLoader.load(Objects.requireNonNull(getClass().getResource(i.getPath()), "Interface URL must not be null"));
    }

    public Game getGame() {
        return game;
    }

    public void newGame(){
        game = new Game();
    }

    public static ZombieDice getInstance() {
        if(instance == null){
            launch(ZombieDice.class);
        }

        return instance;
    }
}