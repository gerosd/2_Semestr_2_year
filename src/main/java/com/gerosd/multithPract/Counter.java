package com.gerosd.multithPract;

public class Counter implements Runnable {
    private int count = 2138746832;

    @Override
    public void run() {
        this.test();
    }

    private synchronized void test() {
        for (int i = 0; i < 100; i++) {
            count = count - 10000;
            if (i % 10 == 0) {
                System.out.println(Thread.currentThread() + " " + count);
            }
        }
    }
}
