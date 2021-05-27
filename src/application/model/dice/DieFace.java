package application.model.dice;

public enum DieFace {
    BRAIN("Cerveau", "brain"),
    GUN("Fusil", "gun"),
    PRINTS("Empreintes", "footprint");

    private final String name;
    private final String fileName;

    DieFace(String name, String fileName){
        this.name = name;
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return "/img/" + fileName + ".png";
    }
}