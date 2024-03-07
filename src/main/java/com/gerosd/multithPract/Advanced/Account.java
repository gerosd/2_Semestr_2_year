package com.gerosd.multithPract.Advanced;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private final int id;
    private final LongAdder failCounter = new LongAdder();

    private int balance;

    public Account(int accountId ,int initialBalance) {
        this.id = accountId;
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void incFailedTransferCount() {
        failCounter.increment();
    }

    public int getId() {
        return id;
    }

    public long getFailCount() {
        return failCounter.sum();
    }

    public Lock getLock() {
        return lock;
    }

    public int getBalance() {
        return balance;
    }
}
