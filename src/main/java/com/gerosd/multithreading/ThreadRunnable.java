package com.gerosd.multithreading;

public class ThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadRunnable is starting " + Thread.currentThread());
    }
}
