package hw1;

import java.util.function.Function;

class ColorCreator {

    private String color;
    private final String reset = "\u001B[0m";
    private final String red = "\u001B[31m";
    private final String yellow = "\u001B[33m";
    private final String green = "\u001B[32m";
    private Function<String, ColorCreator> stringLightColorFunction = (s) -> {
        ColorCreator colorCreator = new ColorCreator();
        colorCreator.setColor(s);
        return colorCreator;
    };

    ColorCreator makeRedLight() {
        color = red + Colors.RED + reset;
        return stringLightColorFunction.apply(color);
    }

    ColorCreator makeYellowColor() {
        color = yellow + Colors.YELLOW + reset;
        return stringLightColorFunction.apply(color);
    }

    ColorCreator makeGreenColor() {
        color = green + Colors.GREEN + reset;
        return stringLightColorFunction.apply(color);
    }

    String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }
}
