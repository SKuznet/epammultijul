package com.epam.multi.lesson1.hm1.java;

public enum Color {
    GREEN, YELLOW, RED;

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";

    public int delay;

    static {
        GREEN.delay = 4;
        YELLOW.delay = 3;
        RED.delay = 2;
    }

    public String toString() {
        switch (this) {
            case GREEN: return ANSI_GREEN + "Green" + ANSI_RESET;
            case RED: return ANSI_RED + "Red" + ANSI_RESET;
            case YELLOW: return ANSI_YELLOW + "Yellow" + ANSI_RESET;
            default: return "Some Error";
        }
    }
}
