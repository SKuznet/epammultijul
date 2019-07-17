package hw1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

class LightController {
    private ColorCreator colorCreator = new ColorCreator();
    private ExecutorService executorService;

    void getLightByMinute(double minute) {
        double workTime = minute % 9;
        executorService = Executors.newFixedThreadPool(3);
        Callable<String> redColor = () -> workTime >= 0 && workTime <= 2
                ? colorCreator.makeRedLight().getColor(): null;
        Callable<String> yellowColor = () -> workTime > 2 && workTime <= 5
                ? colorCreator.makeYellowColor().getColor(): null;
        Callable<String> greenColor = () -> workTime > 5 && workTime <= 9
                ? colorCreator.makeGreenColor().getColor(): null;

        List<Callable<String>> callables = prepareListOfCallables(redColor, yellowColor, greenColor);
        List<Future<String>> futures = handleInvokeExceptions(callables);
        futures.stream()
                .map(this::getStringFromFuture)
                .filter(Objects::nonNull).forEach(System.out::println);

        executorService.shutdown();
    }

    private String getStringFromFuture(Future<String> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        }
    }

    private List<Callable<String>> prepareListOfCallables(Callable<String>... callable) {
        return Arrays.asList(callable);
    }

    private List<Future<String>> handleInvokeExceptions(List<Callable<String>> callables) {
        try {
            return executorService.invokeAll(callables);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
