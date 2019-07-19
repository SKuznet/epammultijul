package hw1;


public class ColorCalculator implements Calculator<Integer, Light> {

    private final static int ONE_CYCLE_DURATION = 9;

    @Override
    public Light calculate(final Integer value) {
        final Light result;
        final int minutes = value % ONE_CYCLE_DURATION;

        if(value < 0) {
            throw new IllegalArgumentException("The value should not be negative");
        }

        if (minutes < Light.RED.getDuration()) {
            result = Light.RED;
        } else if (minutes < Light.RED.getDuration() + Light.YELLOW.getDuration()) {
            result = Light.YELLOW;
        } else {
            result = Light.GREEN;
        }

        return result;
    }
}
