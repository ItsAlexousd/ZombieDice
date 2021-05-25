package application.view;

public enum ScreenLayout {
    LOADING("loading"),
    PLAYER_COUNT("playercount"),
    PLAYER_NAME("playername"),
    DIFFICULTY("difficulty"),
    PLAY("play"),
    GAME("game");

    private final String fileName;

    ScreenLayout(String fileName){
        this.fileName = fileName;
    }

    public String getPath() {
        return "view/" + fileName + ".fxml";
    }
}