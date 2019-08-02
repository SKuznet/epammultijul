package com.epam.multi.lesson7.hw;

public class Bet {
    private int bet;
    private int horseId;
    private Player player;

    public Bet(int bet, int horseId, Player player) {
        this.bet = bet;
        this.horseId = horseId;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getBet() {
        return bet;
    }

    public int getHorseId() {
        return horseId;
    }
}
