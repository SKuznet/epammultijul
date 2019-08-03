package hw5;

import java.util.HashMap;
import java.util.Map;

public class Bookmaker {

    private Map<Player, Integer> bets = new HashMap<>();

    public void acceptBet(Player player, int horseNum) {
        bets.put(player, horseNum);
    }

    public void giveOutPrize(int winningHorseNum) {
        for (Map.Entry<Player, Integer> bet : bets.entrySet()) {
            Player player = bet.getKey();
            if (bet.getValue().equals(winningHorseNum)) {
                player.setBalance(player.getBalance()*2);
                System.err.println("Player #" + player.getId() + " won money!");
                System.err.println("Now his balance: " + player.getBalance());
            } else {
                player.setBalance(0);
                System.out.println("Player #" + player.getId() + " lose!");
                System.out.println("Now his balance: " + player.getBalance());
            }

        }
    }

    public Map<Player, Integer> getBets() {
        return bets;
    }

    public void setBets(Map<Player, Integer> bets) {
        this.bets = bets;
    }
}
