package hw6;

import java.util.concurrent.Exchanger;

public class ExchangerMain {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Helper(exchanger);
        new TroubleMaker(exchanger);
    }
}

