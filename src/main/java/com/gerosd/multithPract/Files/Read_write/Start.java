package com.gerosd.multithPract.Files.Read_write;

import java.util.ArrayList;
import java.util.List;

public class Start {
    List<Integer> listOfResults = new ArrayList<>();

    Reader reader = new Reader(listOfResults);
    Writer writer = new Writer(listOfResults);
    Thread readerThread = new Thread(reader);
    Thread writerThread = new Thread(writer);

    public static void main(String[] args) throws InterruptedException {
        Start start = new Start();
        start.planningThreads();
    }

    private void planningThreads() throws InterruptedException {
        readerThread.start();
        readerThread.join();
        writerThread.start();
    }
}
