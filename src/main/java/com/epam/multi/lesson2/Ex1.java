package com.epam.multi.lesson2;

import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println(getCount());
    }

    private static int getCount() {
        int i = 5;
        try {
            throw new IOException();
        } catch(IOException e) {
            i = i + 1;
            return i;
        } finally {
            i = 10;
            System.out.println("In finally i = " + i);
            return i;
        }
    }
}
