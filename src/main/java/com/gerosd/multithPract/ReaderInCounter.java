package com.gerosd.multithPract;

public class ReaderInCounter implements Runnable {
    Counter counter;

    public ReaderInCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(counter.getCount());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
