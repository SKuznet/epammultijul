package hw1;

public enum  Colors {
    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN");

    private String color;

    Colors(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
