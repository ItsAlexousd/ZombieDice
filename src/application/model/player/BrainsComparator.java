package application.model.player;

import java.util.Comparator;

public class BrainsComparator implements Comparator<Player> {
    @Override
    public int compare(Player player1, Player player2) {
        return player1.compareTo(player2);
    }
}