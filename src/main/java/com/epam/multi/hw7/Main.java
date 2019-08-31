package com.epam.multi.hw7;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        List<String> horsesNames = Arrays.asList(new String[] {"Mimi", "Sammy", "Jane", "Mateo", "Catalina", "Loise", "Micky"});
        int pause  = 200;
        int distance = 30;

        System.out.println("Our horses:");
        Utils.printList(horsesNames);
        System.out.println();

        Player testUser = new Player(0L, "Mark", 1000);
        BrokerCompany.createBet(testUser, 500, 1L);
        BrokerCompany.createBet(testUser, 500, 2L);

        System.out.println("Broker company state:");
        System.out.println(BrokerCompany.getBank());
        System.out.println("Player state:");
        System.out.println(testUser.getMoney());

        System.out.println("User " + testUser.getName() + " made these bets:");
        Utils.printList(BrokerCompany.getBets());
        System.out.println();

        List<Horse> winners = Race.startRace(horsesNames, pause, distance);
        BrokerCompany.processResults(winners);

        System.out.println("Broker company state:");
        System.out.println(BrokerCompany.getBank());
        System.out.println("Player state:");
        System.out.println(testUser.getMoney());
    }
}
