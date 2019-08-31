package com.epam.multi.hw7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrokerCompany {

    private static List<Player> players;
    private static List<Bet> bets = new ArrayList<>();
    private static Integer bank = 1000000;
    private static Integer betSum = 0;

    public static Integer getBank() {
        return bank;
    }

    public static void addPlayer(Player player){
        players.add(player);
    }

    public static void addBet(Bet bet){
        bets.add(bet);
    }

    public static List<Bet> getBets() {
        return bets;
    }

    public static void givePrize(Player player, int amount){
        synchronized (BrokerCompany.class){
            player.setMoney(player.getMoney() + amount*2);
            bank -= amount*2;
        }
    }

    public static void collectPrize(Player player, int amount){
        synchronized (BrokerCompany.class){
            player.setMoney(player.getMoney() - amount);
            bank += amount;
        }
    }

    public static void processResults(List<Horse> winners){
        for (Bet bet: bets){
            boolean userLost = true;
            for (Horse winner: winners){
                if (bet.getHorse().equals(winner.getId())){
                    givePrize(bet.getPlayer(), bet.getSum());
                    userLost = false;
                }
            }
            if (userLost){
                collectPrize(bet.getPlayer(), bet.getSum());
            }
        }
        bets = Collections.emptyList();
        betSum = 0;
    }

    public static void createBet(Player player, int sum, Long horseId){
        if (betSum + sum*2 > bank){
            System.out.println("Cannot accept such a huge bet now!");
            return;
        }
        if (sum > player.getMoney()){
            System.out.println("You don't have enough money for this bet!");
            return;
        }
        bets.add(new Bet(player, sum, horseId));
    }
}
