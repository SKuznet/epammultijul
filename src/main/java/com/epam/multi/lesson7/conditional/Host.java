package com.epam.multi.lesson7.conditional;

class Host implements Runnable {
    private Home home;

    public Host(Home home) {
        this.home = home;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            home.put();
        }
    }
}
