package LAB3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        int size = 10_000;
        double[] arr = new double[size];
        double step = 30.0 / size;

        for (int i = 0; i < size; i++) {
            arr[i] = -15 + i * step;
        }

        int threads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        int chunkSize = size / threads;
        Future<?>[] futures = new Future[threads];

        for (int i = 0; i < threads; i++) {
            int start = i * chunkSize;
            int end = (i == threads - 1) ? size : (i + 1) * chunkSize;

            futures[i] = executor.submit(new CalculatePlotTask(arr, start, end, new MyTrigFunc()));
        }

        for (Future<?> future : futures) {
            future.get();
        }

        executor.shutdown();

        PlotDisplayer.showChart(arr, step);
    }
}
