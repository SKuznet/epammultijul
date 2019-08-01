package com.epam.multi.lesson6.homework5;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerMain {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <4 ; i++) {
            Exchanger<Integer> exchanger = new Exchanger();
            new IllegalCurrencyExchanger(exchanger);
            new JustAManWithExtraDollars(exchanger);
            TimeUnit.SECONDS.sleep(2);
        }

    }
}

