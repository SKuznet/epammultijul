package com.epam.multi.homeworks.homework1;

public enum Light {
    GREEN("Зеленый"), YELLOW("Желтый"), RED("Красный");

    private String color;

    /**
     * @param color to set color
     */
    Light(String color) {
        this.color = color;
    }

    /**
     * @return color
     */
    public String getColor() {
        return color;
    }
}
