package com.epam.multi.lesson7.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookmakersOffice {

    private boolean isTakeWinnings;
    private int winnings;
    private int entry;
    private int horseNumber;
    private Player player;

    public BookmakersOffice(Player player) {
        this.player = player;
    }

    public void setWinnings(int winnings) {
        this.winnings += winnings;
        player.setPlayerBill(player.getPlayerBill() + winnings);
    }

    public boolean isTakeWinnings() {
        return isTakeWinnings;
    }

    public void setTakeWinnings(boolean takeWinnings) {
        isTakeWinnings = takeWinnings;
    }

    public void takeWinning(BufferedReader reader) throws IOException {
        System.out.println("If you want to continues type 1 or 0 if you want to take winnings");
        String line;
        while (true) {
            if (!((line = reader.readLine()) == null)) {
                int decision = Integer.parseInt(line);
                if (decision == 1) {
                    System.out.println("Let's try to win again!");
                    break;
                } else if (decision == 0) {
                    System.out.println("Congratulation! Your winnings is " + winnings);
                    this.setTakeWinnings(true);
                    break;
                } else {
                    System.out.println("Wrong number. Try again!");
                }
            } else {
                break;
            }
        }
    }

    public int getHorseNumber() {
        return horseNumber;
    }

    public int getHorseWinnerId() {

        for (int i = 1; i <= 5; i++) {
            Thread horse = new Thread(new Horse(i));
            horse.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Integer horseId : Horse.winnerHorses) {
            System.out.println("Horse " + horseId + " finish the race!!!");
        }

        return Horse.winnerHorses.get(0);
    }

    public void chooseHorse(BufferedReader reader) throws IOException {
        System.out.println("Choose the horse (type id from 1 to 5): ");
        String line;
        while (true) {
            if (!((line = reader.readLine()) == null)) {
                int id = Integer.parseInt(line);
                if (id > 0 && id < 6) {
                    horseNumber = id;
                    break;
                } else {
                    System.out.println("Wrong number! Choose the horse (type id from 1 to 5): ");
                }
            } else {
                break;
            }
        }
    }

    public void setEntry(BufferedReader reader) throws IOException, NotEnoughMoneyException {
        System.out.println(player.getName() + " your balance is " + player.getPlayerBill());
        System.out.println("Please get entry: ");
        String line;
        while (true) {
            if (!((line = reader.readLine()) == null)) {
                int entry = Integer.parseInt(line);
                if (entry > player.getPlayerBill() || entry < 0) {
                    throw new NotEnoughMoneyException();
                } else {
                    this.entry = entry;
                    player.setPlayerBill(player.getPlayerBill() - entry);
                    break;
                }
            } else {
                break;
            }
        }
    }

    public int getEntry() {
        return entry;
    }

    public static void main(String[] args) {
        BookmakersOffice bookmakersOffice = new BookmakersOffice(new Player("Bill", 1000));
        System.out.println("Welcome to bookmaker's office!");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            while (!bookmakersOffice.isTakeWinnings()) {
                bookmakersOffice.setEntry(reader);
                bookmakersOffice.chooseHorse(reader);
                if (bookmakersOffice.getHorseWinnerId() == bookmakersOffice.getHorseNumber()) {
                    bookmakersOffice.setWinnings(bookmakersOffice.getEntry() * 2);
                    System.out.println("You won! ");
                } else {
                    System.out.println("Sorry! You lose!");
                }
                Horse.winnerHorses.clear();
                bookmakersOffice.takeWinning(reader);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        } catch (NotEnoughMoneyException e) {
            System.err.println("You do not have enough money!!!");
        }
    }
}
