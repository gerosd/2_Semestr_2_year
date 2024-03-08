package com.gerosd.multithPract.Advanced;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OperationsService {
    private static final Random random = new Random();
    final static Account acc1 = new Account(1, 1000);
    final static Account acc2 = new Account(2, 1000);
    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final CountDownLatch endLatch = new CountDownLatch(1);
    static ScheduledExecutorService service = createSuccessMonitoringThread();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            service.submit(new Transfer(acc1, acc2, random.nextInt(400), startLatch, endLatch));
            startLatch.countDown();
        }
        service.shutdown();
    }

    private static ScheduledExecutorService createSuccessMonitoringThread() {
        service = Executors.newScheduledThreadPool(1);
        service.schedule(() ->
                System.out.println("Failed transfer in Account: " + acc1.getFailCount()), 1, TimeUnit.SECONDS);
        return service;
    }
}
