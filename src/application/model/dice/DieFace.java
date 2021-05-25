package application.model.dice;

public enum DieFace {
    BRAIN("Cerveau"),
    GUN("Fusil"),
    PRINTS("Empreintes");

    private final String name;

    DieFace(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}