package com.epam.multi.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex {
    public static void main(String[] args) {
        Ex ex = new Ex();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 3; i++) {
                ex.getInputValue(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInputValue(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
