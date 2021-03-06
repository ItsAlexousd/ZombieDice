package application.model.player;

public class Player implements Comparable<Player> {
    private final String name;
    private int brains;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBrains() {
        return brains;
    }

    public void addBrains(int brains) {
        this.brains += brains;
    }

    @Override
    public int compareTo(Player player) {
        return player.getBrains() - brains;
    }
}