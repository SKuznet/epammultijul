package hw7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Gambler {

    private int balance = 200;
    private int bet;
    private int horseNumber;
    private boolean wantToContinue = true;

    public void status() {
        System.out.println("Your balance is: " + balance);
    }

    public boolean makeBet() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("What is yor bet?");
            try {
                bet = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct number");
                return false;
            }
            if (bet > balance) {
                System.out.println("Insufficient funds!");
                return false;
            }
            System.out.println("Good! What is your horse number? We have numbers 1 - 7");
            try {
                horseNumber = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct number");
                return false;
            }
            if (horseNumber < 1 || horseNumber > 7) {
                System.out.println("We have numbers 1 - 7");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void result(int winner) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (winner == horseNumber) {
            System.out.println("You win!");
            balance += bet * 2;
        } else {
            System.out.println("You lost!");
            balance -= bet;
        }
    }

    public void setWantToContinue() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        System.out.println("--------------------------");
        System.out.println("Do you want to continue? Y/N");
        while (true) {
            try {
                answer = bufferedReader.readLine();
                if (answer.equals("N")) {
                    System.out.println("Bye!");
                    System.exit(0);
                } else if (answer.equals("Y")) {
                    break;
                } else {
                    System.out.println("Answer not clear. Do you want to continue? Y/N");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
