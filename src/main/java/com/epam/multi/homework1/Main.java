package com.epam.multi.homework1;


public class Main {
    public static void main(String[] args) {

        try {
            if (args.length == 0) {
                System.out.println("No Data");
            } else if (args.length != 3) {
                throw new IndexOutOfBoundsException();
            }

            TrafficLight t1 = new TrafficLight(Integer.parseInt(args[0]));
            TrafficLight t2 = new TrafficLight(Integer.parseInt(args[1]));
            TrafficLight t3 = new TrafficLight(Integer.parseInt(args[2]));

            t1.start();
            t2.start();
            t3.start();

        } catch (NumberFormatException e) {
            System.err.println("Illegal data input format");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Illegal amount of data, please enter three numbers");
        }


    }
}
