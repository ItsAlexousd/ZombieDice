package application.model.dice;

public enum DiceColor {
    GREEN("Vert", 3, 2, 1),
    YELLOW("Jaune", 2, 2, 2),
    RED("Rouge", 1, 2, 3);

    private final String name;
    private final int brainCount;
    private final int gunCount;
    private final int printsCount;

    DiceColor(String name, int brainCount, int gunCount, int printsCount) {
        this.name = name;
        this.brainCount = brainCount;
        this.gunCount = gunCount;
        this.printsCount = printsCount;
    }

    public String getName() {
        return name;
    }

    public int getBrainCount() {
        return brainCount;
    }

    public int getGunCount() {
        return gunCount;
    }

    public int getPrintsCount() {
        return printsCount;
    }
}