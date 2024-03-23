package com.gerosd.multithPract.Philosophers;

public class Philosopher implements Runnable {
    private static int i = 1;

    private String name;

    {
        this.setName("Philosopher - " + i);
        i++;
    }

    @Override
    public void run() {
        try {
            logic();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void logic() throws InterruptedException {
        doAction("Thinking");
        doAction("Get left fork");
        doAction("Get right fork - eating");
        doAction("Put down left fork");
        doAction("Put down right fork - start thinking");
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(this.getName() + " " + action);
        Thread.sleep((int) (Math.random() * 100));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
