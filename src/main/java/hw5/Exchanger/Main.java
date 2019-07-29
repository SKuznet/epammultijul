package hw5.Exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new CreateAtomicLong(exchanger);
        new UseAtomicLong(exchanger);
    }
}