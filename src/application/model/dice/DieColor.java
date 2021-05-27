package application.model.dice;

public enum DieColor {
    GREEN("Vert", "green-die", 3, 2, 1),
    YELLOW("Jaune", "yellow-die", 2, 2, 2),
    RED("Rouge", "red-die", 1, 2, 3);

    private final String name;
    private final String fileName;
    private final int brainCount;
    private final int gunCount;
    private final int printsCount;

    DieColor(String name, String fileName, int brainCount, int gunCount, int printsCount) {
        this.name = name;
        this.fileName = fileName;
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

    public String getPath() {
        return "/img/" + fileName + ".png";
    }
}