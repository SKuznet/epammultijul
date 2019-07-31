package com.epam.multi.lesson7.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
       new Game().startGame();
    }

    private void startGame(){
        List<Player> players = playersAdding();


    }

    private List<Player> playersAdding(){
        List<Player> players = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String answer;
            System.out.print("Is there new player?(y/n): ");
            while(!(answer = reader.readLine()).equals("n")){
                if(answer.equals("y")){
                    System.out.print("Enter the new player's name: ");;
                    String name = reader.readLine();
                    Player player = new Player(name);
                    players.add(player);
                    System.out.println("Hi, " + name + " and welcome!");
                    System.out.print("Is there another new player?(y/n): ");
                } else {
                    System.err.println("Wrong answer. Try again.");
                    System.out.print("Is there new player?(y/n): ");
                }
            }
            for(Player player : players){
                System.out.println(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}
