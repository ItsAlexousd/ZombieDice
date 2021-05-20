package application.view;

public enum ScreenLayout {
    LOADING("loading"),
    HOME("home"),
    PLAYER_COUNT("playercount"),
    PLAYER_NAME("playername"),
    DIFFICULTY("difficulty"),
    PLAY("play");

    private String fileName;

    ScreenLayout(String fileName){
        this.fileName = fileName;
    }

    public String getPath() {
        return "view/" + fileName + ".fxml";
    }
}