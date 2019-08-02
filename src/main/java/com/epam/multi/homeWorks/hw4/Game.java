package com.epam.multi.homeWorks.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//НЕ РАБОТАЕТ :(
public class Game {
    private int nHorses = 7;
    private List<Player> results = new ArrayList<>();
    private List<Player> players;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        new Game().startGame();
    }

    private void startGame() {
        players = playersAdding();
        while (!players.isEmpty()) {
            List<Bet> bets = getBets(players);
            Horse winner = getWinner(bets);
            players = resultsOfRace(players, bets, winner);
            prepareNextRace(players);
        }
        finishGame();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Bet> getBets(List<Player> players) {
        List<Bet> result = new ArrayList<>();
        List<String> validHorses = getValidNumbersOfHorses();
        for (Player player : players) {
            String answer;
            System.out.println(player.getName() + ", which horse will win? (Choose number from 0 to 6): ");

            while (!validHorses.contains(answer = getAnswer(reader))) {
                System.err.println("Write correct number!: ");
            }

            int horseId = Integer.parseInt(answer);
            System.out.println("Well, what's your bet?: ");

            int betMoney = 0;
            while (true) {
                try {
                    betMoney = Integer.parseInt(getAnswer(reader));
                } catch (NumberFormatException e) {
                    System.err.println("Write correct number!: ");
                }
                if (player.getCash() < betMoney) {
                    System.err.println("Sorry, you have only: " + player.getCash() + ", but this game's programmer " +
                            "cannot write code for your's exit now. So you have to make your bet :( Try again: ");
                } else {
                    break;
                }
            }

            Bet bet = new Bet(betMoney, horseId, player);
            result.add(bet);
        }
        return result;
    }

    private Horse getWinner(List<Bet> bets) {
        Object key = new Object();
        GamesCyclicBarrier barrier = new GamesCyclicBarrier(nHorses, 200, key, bets);
        Thread thread = new Thread(barrier);
        thread.start();

        synchronized (key) {
            try {
                key.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return barrier.getWinner();
    }

    private List<Player> playersAdding() {
        List<Player> players = new ArrayList<>();
        String answer;
        System.out.print("Is there new player?(y/n): ");
        while (!(answer = getAnswer(reader)).equals("n")) {
            if (answer.equals("y")) {
                System.out.print("Enter the new player's name: ");
                String name = getAnswer(reader);
                Player player = new Player(name);
                players.add(player);
                System.out.println("Hi, " + name + " and welcome!");
                System.out.print("Is there another new player?(y/n): ");
            } else {
                System.err.println("Wrong answer. Try again.");
                System.out.print("Is there new player?(y/n): ");
            }
        }
        for (Player player : players) {
            System.out.println(player);
        }
        return players;
    }

    private List<Player> resultsOfRace(List<Player> players, List<Bet> bets, Horse winner) {
        List<Player> newList = players;
        for (Bet bet : bets) {
            if (bet.getHorseId() == winner.getId()) {
                Player player = bet.getPlayer();
                player.setCash(player.getCash() + bet.getBet());
            } else {
                Player player = bet.getPlayer();
                player.setCash(player.getCash() - bet.getBet());
            }
        }

        for (Player player : newList) {
            if (player.getCash() <= 0) {
                newList.remove(player);
                results.add(player);
                System.err.println("Player " + player.getName() + " out of game!");
            }
        }
        return newList;
    }

    private void prepareNextRace(List<Player> players) {
        if(!players.isEmpty()) {
            for (Player player : players) {
                System.out.println(player.getName() + ", You have " + player.getCash() + ". Do You want to continue?(y/n): ");
                String answer = getAnswer(reader);
                boolean validAnswer = false;
                while (!validAnswer) {
                    if (answer.equals("y")) {
                        validAnswer = true;
                        System.out.println(player.getName() + ", welcome to the next round!");
                    }
                    if (answer.equals("n")) {
                        validAnswer = true;
                        players.remove(player);
                        results.add(player);
                        System.err.println("Player " + player.getName() + " out of game!");
                    }
                }
            }
        }
    }

    private void finishGame() {
        System.err.println("The game is finished!");
        System.out.println("That's list of all players:");
        for (Player player : results) {
            System.out.println(player);
        }
        System.err.println("Thank you for playing!");
    }

    private String getAnswer(BufferedReader reader) {
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<String> getValidNumbersOfHorses() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < nHorses; i++) {
            result.add(Integer.toString(i));
        }
        return result;
    }
}
