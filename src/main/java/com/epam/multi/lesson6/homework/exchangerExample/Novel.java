package com.epam.multi.lesson6.homework.exchangerExample;

import java.util.concurrent.Exchanger;

public class Novel {
    public static final Exchanger<String> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(new Writer("Jack", "ABCD")).start();
        new Thread(new Writer("Ivan", "DCBA")).start();
    }
}
