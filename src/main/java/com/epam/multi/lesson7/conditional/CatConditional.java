package com.epam.multi.lesson7.conditional;

public class CatConditional {
    public static void main(String[] args) {
        final Home home = new Home();
        Cat cat = new Cat(home);
        Host host = new Host(home);

        new Thread(cat).start();
        new Thread(host).start();
    }
}