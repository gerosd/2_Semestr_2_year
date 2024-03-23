package com.gerosd.multithPract.Philosophers;

import java.util.concurrent.*;

public class StartActions {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Philosopher());
        }
        executorService.shutdown();
    }
}
