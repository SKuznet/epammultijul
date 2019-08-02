package hw7;

import hw7.player.Player;
import hw7.tote.Bookmaker;
import hw7.tote.Horse;
import hw7.tote.Judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Supported commands:
 * make bet - let you type your bet
 * change horses - let you change amount of horses
 * change distance - let you change distance of race
 */
public class Application {

    public static void main(String[] args) {

        Bookmaker bookmaker = new Bookmaker();
        CopyOnWriteArrayList<Horse> winners = new CopyOnWriteArrayList<>();
        Judge judge = new Judge(winners);
        Player you;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("How much money do U have? - ");
            try {
                you = new Player(Integer.parseInt(reader.readLine()));
            } catch (NumberFormatException e) {
                lazyNumberFormatExceptionHandling();
                return;
            }

            System.out.println("Default number of horses is 5");
            System.out.println("Default distance is 1000");
            String input;
            bookmaker.gimMoney(you.getAccount());
            while (true) {
                if (you.getMoney() <= 0) {
                    System.err.println("You haven't enough money for bets, see you later");
                    return;
                }

                System.out.println("What do U want to do?");
                input = reader.readLine();
                switch (input) {
                    case "make bet":
                        System.out.print("In which horse do you believe: ");
                        int horse;
                        try {
                            horse = Integer.parseInt(reader.readLine());
                        } catch (NumberFormatException e) {
                            lazyNumberFormatExceptionHandling();
                            return;
                        }
                        System.out.print("Your bet: ");
                        int bet;
                        try {
                            bet = Integer.parseInt(reader.readLine());
                        } catch (NumberFormatException e) {
                            lazyNumberFormatExceptionHandling();
                            return;
                        }
                        if (bet < 0) {
                            lazyNumberFormatExceptionHandling();
                            return;
                        }
                        if (!bookmaker.takeBet(bet, horse)) {
                            System.err.println("Not enough money");
                            continue;
                        }
                        judge.startRace();
                        judge.printResults();
                        if (bookmaker.resolve(winners)) {
                            System.out.println("You win");
                        } else {
                            System.out.println("You lose");
                        }
                        System.out.println("Your money: " + you.getMoney());
                        break;
                    case "change horses":
                        System.out.print("Type new amount of horses: ");
                        int horsesAmount;
                        try {
                            horsesAmount = Integer.parseInt(reader.readLine());
                        } catch (NumberFormatException e) {
                            lazyNumberFormatExceptionHandling();
                            return;
                        }
                        if (horsesAmount == 1) {
                            System.out.println("Good try, but no, sorry");
                        } else {
                            judge.setAmountOfHorses(horsesAmount);
                            System.out.println("Done");
                        }
                        break;
                    case "change distance":
                        System.out.print("Type new distance: ");
                        int distance;
                        try {
                            distance = Integer.parseInt(reader.readLine());
                        } catch (NumberFormatException e) {
                            lazyNumberFormatExceptionHandling();
                            return;
                        }
                        if (distance <= 0) {
                            lazyNumberFormatExceptionHandling();
                            return;
                        } else {
                            judge.setDistance(distance);
                            System.out.println("Done");
                        }
                        break;
                    case "go home":
                        System.out.println("See you");
                        return;
                    default:
                        System.err.println("Unsupported command");
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void lazyNumberFormatExceptionHandling() {
        System.err.println("Oh cmon, you even cant type number without error. We aren't able to take bets from underage, bb");
    }
}
