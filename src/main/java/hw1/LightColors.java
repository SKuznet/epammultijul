package hw1;

enum LightColors {
    RED(2), YELLOW(3), GREEN(4);

    private int duration;

    LightColors(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
