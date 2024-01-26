package com.gerosd.multithreading;

public class ThreadExt extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadExt is starting " + Thread.currentThread());
    }
}
