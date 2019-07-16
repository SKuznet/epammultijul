package com.epam.multi.lesson1;

public class Service {
    public static ColorOfTheLight getColor(Integer minute) {
        int min = minute % 9;
        if (min >= 0 && min <= 2) return ColorOfTheLight.RED;
        else if (min > 2 && min <= 5) return ColorOfTheLight.YELLOW;
        else if (min > 5 && min <= 9) return ColorOfTheLight.GREEN;
        System.out.println("Wrong expression");
        return null;
    }
}
