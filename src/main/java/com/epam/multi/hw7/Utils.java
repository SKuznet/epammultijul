package com.epam.multi.hw7;

import java.util.List;

public class Utils {

    public static <T> void printList(List<T> list){
        int index = 1;
        for (T element: list) {
            System.out.println(index++ + " " + element);
        }
    }
}
