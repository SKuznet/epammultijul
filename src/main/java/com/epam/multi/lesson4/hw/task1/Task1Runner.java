package com.epam.multi.lesson4.hw.task1;

public class Task1Runner {
    private static ATM atm = new ATM();

    public void run(){
        User ivan = new User("Ivan");
        User kirill = new User("Kirill");
        User james = new User("James");

        transAction(ivan, kirill, james);
    }

    private static void transAction(User... users){
        for(final User user : users){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    user.getMoney(atm,500);
                }
            }).start();
        }
    }
}
