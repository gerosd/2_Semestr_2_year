package com.gerosd.multithPract.Advanced;

public class Operations {
    public static void main(String[] args) {
        final Account a = new Account(1, 1000);
        final Account b = new Account(2, 2000);

        new Thread(() -> {
            try {
                new Transfer(a, b, 500).call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                new Transfer(b, a, 300).call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}