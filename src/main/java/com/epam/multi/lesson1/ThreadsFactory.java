package com.epam.multi.lesson1;

public final class ThreadsFactory {

    private LightThread threadRed;
    private LightThread threadYellow;
    private LightThread threadGreen;

    public ThreadsFactory(Light red, Light yellow, Light green, LightStatus lightStatus) {
        threadRed = new LightThread(red, yellow, lightStatus);
        threadYellow = new LightThread(yellow, green, lightStatus);
        threadGreen = new LightThread(green, red, lightStatus);
    }

    public LightThread getThreadRed() {
        return threadRed;
    }

    public LightThread getThreadYellow() {
        return threadYellow;
    }

    public LightThread getThreadGreen() {
        return threadGreen;
    }
}
