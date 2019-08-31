package com.epam.multi.hw7;

public class Bet {

    private Player player;
    private int sum;
    private Long horseId;
    private int playerWon;

    public Bet(Player player, int sum, Long horseId) {
        this.player = player;
        this.sum = sum;
        this.horseId = horseId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Long getHorse() {
        return horseId;
    }

    public void setHorse(Long horseId) {
        this.horseId = horseId;
    }

    public int getPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(int playerWon) {
        this.playerWon = playerWon;
    }

    @Override
    public String toString() {
        return "Horse ID: " + horseId + ", sum: " + sum;
    }
}
