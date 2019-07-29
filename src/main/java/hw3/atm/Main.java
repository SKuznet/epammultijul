package main.java.hw3.atm;

public class Main {

    public static void main(String[] args) {

        Cardholder ch1 = new Cardholder("Bob");
        Cardholder ch2 = new Cardholder("John");
        Cardholder ch3 = new Cardholder("Jack");
        ch1.start();
        ch2.start();
        ch3.start();
    }
}
