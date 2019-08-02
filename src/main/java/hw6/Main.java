package hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static int N_HORSES = 9;
    final static int TOTAL_MONEY = 10000;
    final static int PAUSE = 200;
    final String NAME_REGEX = "[a-zA-Z ]+";
    final String NUMBER_REGEX = "[1-9]{1}";


    public static void main(String[] args) {
        Main app = new Main();
        Agent agent = new Agent("James");
        Customer customer = new Customer();
        app.interactWithUser(agent, customer);
        int winnerId = app.play();
        app.checkBet(agent, customer, winnerId);
    }

    void interactWithUser(Agent agent, Customer customer) {

        customer.setMoney(TOTAL_MONEY);

        agent.say("Awesome offer! Bet on the right horse - double your money! What is your name, pal?");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = reader.readLine();
            if (name.matches(NAME_REGEX)) {
                customer.setName(name);
                agent.say("Ok, " + customer.getName() + ". We have " + N_HORSES + " horses today. Make your bet, please");
                String str_horseNumber = reader.readLine();
                if (str_horseNumber.matches(NUMBER_REGEX)) {
                    int horseNumber = Integer.parseInt(str_horseNumber);
                    agent.say("How much money you will lay?");
                    int moneyAmount = Integer.parseInt(reader.readLine());
                    if (moneyAmount > 0 && moneyAmount <= customer.getMoney()) {
                        customer.makeBet(moneyAmount, horseNumber);
                        customer.setMoney(customer.getMoney() - moneyAmount);
                        agent.say("Good job! Let's get started");
                    } else {
                        agent.say("Not enough money, sir! Try next time");
                    }
                } else {
                    System.err.println("Incorrect horse number");
                }
            } else {
                System.err.println("Invalid name");
            }
        } catch (IOException e) {
            System.err.println("Oops! Something went wrong");
        }
    }

    int play() {
        CyclicBarrierEx cyclicBarrierEx = new CyclicBarrierEx(N_HORSES, PAUSE);
        return cyclicBarrierEx.getHorseWinnerId();
    }

    void checkBet(Agent agent, Customer customer, int winnerId) {
        if (customer.getBet().getHorseNumber() == winnerId) {
            agent.say("Congratulations, my friend! You win!!!");
            double prize = customer.getBet().getMoney() * 2;
            customer.setMoney(customer.getMoney() + prize);
        } else {
            agent.say("There is no prize for you, man. Good luck next time!");
        }
    }

}
