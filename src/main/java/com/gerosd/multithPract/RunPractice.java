package com.gerosd.multithPract;

public class RunPractice {
    static Counter runnable = new Counter();
    static Thread counter1 = new Thread(runnable);
    static Thread counter2 = new Thread(runnable);
    static Thread counter3 = new Thread(runnable);
    static Thread counter4 = new Thread(runnable);

    public static void main(String[] args) {
        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();
    }
}
