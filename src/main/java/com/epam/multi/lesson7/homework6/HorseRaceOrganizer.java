package com.epam.multi.lesson7.homework6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;

public class HorseRaceOrganizer {
    public static void main(String[] args) throws IOException {
        BidDependentPlayer bidDependentPlayer = new BidDependentPlayer( 600, "Alex");
        int nHorses = 7;
        int pause  = 200;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            while (true) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                System.out.println(bidDependentPlayer.getName() + "'s current cash amount is " + bidDependentPlayer.getCashAmount() + " dollars!");
                System.out.println("Want to lose your money on horse racing? type \"no\" for exit or anything else to continue:");
                if(br.readLine().equals("no")){
                    break;
                }
                System.out.println("Input horse number you want to lose your money on:");
                bidDependentPlayer.setCurrentHorseNumber(Integer.parseInt(br.readLine()));
                if ((bidDependentPlayer.getCurrentHorseNumber() < 0) || (bidDependentPlayer.getCurrentHorseNumber() > nHorses)) {
                    throw new IOException();
                }
                System.out.println("Input you bid:");
                bidDependentPlayer.setCurrentBid(Integer.parseInt(br.readLine()));
                if (bidDependentPlayer.getCurrentBid() > bidDependentPlayer.getCashAmount()) {
                    throw new IOException();
                }
                new HorseRacingClub(nHorses, pause, bidDependentPlayer, countDownLatch);
                countDownLatch.await();
            }
        }
        catch (NumberFormatException ex){
            System.err.println("Wrong number format, system shutting down...");
        }
        catch (IOException ex) {
            System.err.println("You broke the system...shutting down...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        br.close();
    }
}
