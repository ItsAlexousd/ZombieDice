package application.model.dice;

public enum DiceColor {
    GREEN("Vert"),
    YELLOW("Jaune"),
    RED("Rouge");

    private final String name;

    DiceColor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}