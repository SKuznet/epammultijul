package com.epam.multi.lesson3;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        CastSpell castSpell = new CastSpell();
        castSpell.run();

        Thread thread = new Thread(new CastSpell());
        thread.start();
    }
}
