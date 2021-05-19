package application.screen;

public enum ScreenLayout {
    LOADING("loading"),
    HOME("home");

    private String fileName;

    ScreenLayout(String fileName){
        this.fileName = fileName;
    }

    public String getPath() {
        return "screen/" + fileName + ".fxml";
    }
}