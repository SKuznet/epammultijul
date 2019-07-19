package hw1;

public enum Light {
    RED(2), YELLOW(3), GREEN(4);

    private int duration;

    Light(final int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
