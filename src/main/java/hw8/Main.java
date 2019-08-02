package main.java.hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {
        makeBet();
    }

    public static void makeBet() {
        while (true) {
            try {
                String string = bufferedReader.readLine();
                if (string.isEmpty() || "".equals(string)) {
                    System.out.println(Pocket.INSTANCE.getAmount() + " in you pocket.");
                    break;
                } else {
                    int bet = Integer.parseInt(string);
                    if (bet <= Pocket.INSTANCE.getAmount()) {
                        System.out.println("Change horse");
                        int betHorse = Integer.parseInt(bufferedReader.readLine());
                        int nHorses = 7;
                        int pause = 200;
                        Hippodrome hippodrome = new Hippodrome(nHorses, pause);
                        if (betHorse==hippodrome.getHorseWinner()) {
                            Pocket.INSTANCE.setAmount(Pocket.INSTANCE.getAmount() + bet*2);
                        } else {
                            Pocket.INSTANCE.setAmount(Pocket.INSTANCE.getAmount() - bet);
                        }
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }
}
