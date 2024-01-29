package com.gerosd.multithreading;
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting " + Thread.currentThread());
        ThreadExt ext = new ThreadExt();
        ext.start();
        ThreadRunnable runnable = new ThreadRunnable();
        Thread testThread = new Thread(runnable);
        testThread.start();
        try {
            testThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(() -> System.out.println("Anon class is running"));
        thread.start();
        System.out.println("Exit " + Thread.currentThread());
    }
}
