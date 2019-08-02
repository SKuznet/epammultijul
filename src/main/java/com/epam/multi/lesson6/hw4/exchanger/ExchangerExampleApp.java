package com.epam.multi.lesson6.hw4.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExampleApp {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new UseSomeString(exchanger);
        new MakeSomeString(exchanger);
    }

}
