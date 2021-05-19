package application;

import application.view.ScreenLayout;
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
import java.net.URL;
import java.util.Objects;

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

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(ScreenLayout.LOADING.getPath()), "Loading URL must not be null"));

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