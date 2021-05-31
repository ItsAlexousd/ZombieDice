package application.view;

public enum Interface {
    LOADING("loading"),
    PLAYER_COUNT("playercount"),
    PLAYER_NAME("playername"),
    DIFFICULTY("difficulty"),
    PLAY("play"),
    GAME("game"),
    WINNER("winner"),
    LEADERBOARD("leaderboard");

    private final String fileName;

    Interface(String fileName){
        this.fileName = fileName;
    }

    public String getPath() {
        return "view/" + fileName + ".fxml";
    }
}