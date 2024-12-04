package LAB3;

import java.util.concurrent.Callable;

public class CalculatePlotTask implements Callable<Void> {
    private final double[] arr;
    private final int start;
    private final int end;
    private final Calculable function;

    public CalculatePlotTask(double[] arr, int start, int end, Calculable function) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.function = function;
    }

    @Override
    public Void call() {
        for (int i = start; i < end; i++) {
            arr[i] = function.calculate(arr[i]);
        }
        return null;
    }
}
