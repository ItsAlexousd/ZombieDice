package application.model.dice;

public enum DiceFace {
    BRAIN("Cerveau"),
    GUN("Fusil"),
    PRINTS("Empreintes");

    private final String name;

    DiceFace(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}