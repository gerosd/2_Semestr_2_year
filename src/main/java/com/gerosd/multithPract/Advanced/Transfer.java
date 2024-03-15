package com.gerosd.multithPract.Advanced;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {
    private final GenerateId idSetter = new GenerateId();
    private CountDownLatch startLatch = new CountDownLatch(1);
    private static final int LOCK_WAIT_SEC = 5;
    private final Random waitRandom = new Random();
    private final int id;
    private final int amount;
    private final Account accountFrom;
    private final Account accountTo;

    public Transfer(Account accountFrom, Account accountTo, int amount) {
        this.id = idSetter.setId();
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Transfer (Account accountFrom, Account accountTo, int amount, CountDownLatch startLatch) {
        this(accountFrom,accountTo,amount);
        this.startLatch = startLatch;
    }

    @Override
    public Boolean call() throws Exception {
        if (startLatch != null) {
            System.out.println("[" + id + "] Waiting to start...");
            startLatch.await();
        }
        if (accountFrom.getLock().tryLock(LOCK_WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (accountTo.getLock().tryLock(LOCK_WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        if (accountFrom.getBalance() < amount) {
                            accountFrom.incFailedTransferCount();
                            return false;
                        }
                        accountFrom.withdraw(amount);
                        accountTo.deposit(amount);
                        Thread.sleep(waitRandom.nextInt(2000));
                        System.out.println(id + " Transfer " + amount + " done from " + accountFrom.getId() + " to " + accountTo.getId());
                        return true;
                    } finally {
                        accountTo.getLock().unlock();
                    }
                } else {
                    accountTo.incFailedTransferCount();
                    return false;
                }
            } finally {
                accountFrom.getLock().unlock();
            }
        } else {
            accountFrom.incFailedTransferCount();
            return false;
        }
    }
}