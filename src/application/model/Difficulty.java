package application.model;

public enum Difficulty {
    EASY("Facile", 8, 3, 2),
    MEDIUM("Moyen", 6, 4, 3),
    HARD("Difficile", 4, 5, 4);

    private final String name;
    private final int greenDices;
    private final int yellowDices;
    private final int redDices;

    Difficulty(String name, int greenDices, int yellowDices, int redDices) {
        this.name = name;
        this.greenDices = greenDices;
        this.yellowDices = yellowDices;
        this.redDices = redDices;
    }

    public String getName() {
        return name;
    }

    public int getGreenDices() {
        return greenDices;
    }

    public int getYellowDices() {
        return yellowDices;
    }

    public int getRedDices() {
        return redDices;
    }
}