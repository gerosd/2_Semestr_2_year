package com.gerosd.multithPract;

public class Counter implements Runnable {
    volatile int count = 2138746832;

    @Override
    public void run() {
        this.test();
    }

    private synchronized void test() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 100; i++) {
            count = count - 10000;
        }
    }

    public int getCount() {
        return count;
    }
}
