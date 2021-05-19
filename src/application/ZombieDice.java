package application;

import application.screen.ScreenLayout;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ZombieDice extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private static ZombieDice instance;
    private Stage stage;

    public ZombieDice(){
        instance = this;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        URL url = getClass().getResource(ScreenLayout.HOME.getPath());

        if(url == null){
            throw new NullPointerException("Home file is null");
        }

        Parent root = FXMLLoader.load(url);

        // Center the window on the screen
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((bounds.getWidth() - WIDTH) / 2);
        primaryStage.setY((bounds.getHeight() - HEIGHT) / 2);

        primaryStage.setTitle("Zombie Dice");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }

    public void setLayout(ScreenLayout screen) {
        URL url = getClass().getResource(screen.getPath());

        if(url != null){
            try {
                stage.getScene().setRoot(FXMLLoader.load(url));
            } catch (IOException e) {
                e.printStackTrace();
                Platform.exit();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ZombieDice getInstance() {
        if(instance == null) {
            ZombieDice.launch(ZombieDice.class);
        }

        return instance;
    }
}