package com.epam.multi.lesson2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (IOException e) {
            try {
                throw new RuntimeException();
            } catch (RuntimeException ex1) {

            }
        }

        System.out.println("Hello");
    }
}
