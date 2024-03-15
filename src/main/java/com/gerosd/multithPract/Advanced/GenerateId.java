package com.gerosd.multithPract.Advanced;

import java.util.Random;

public class GenerateId {
    static Random randId = new Random();
    ThreadLocal<Integer> idSetter = ThreadLocal.withInitial(() -> Math.abs(randId.nextInt()));

    public int setId() {
        return idSetter.get();
    }
}
