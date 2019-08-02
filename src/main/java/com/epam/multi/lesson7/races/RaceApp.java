package com.epam.multi.lesson7.races;

import com.epam.multi.lesson7.races.entities.Horse;
import com.epam.multi.lesson7.races.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class RaceApp {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        List<Horse> horses = new ArrayList<>();

        players.add(new Player("John"));
        players.add(new Player("Becky"));
        players.add(new Player("Jason"));

        horses.add(new Horse("Horse1"));
        horses.add(new Horse("Horse2"));
        horses.add(new Horse("Horse3"));

        players.get(0).makeABet(200, horses.get(0), 2);
    }
}
