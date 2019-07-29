package com.epam.multi.lesson7.conditional;

class Cat implements Runnable {
    private Home home;

    public Cat(Home home) {
        this.home = home;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            home.get();
        }
    }
}
