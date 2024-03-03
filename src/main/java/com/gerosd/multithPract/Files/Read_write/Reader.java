package com.gerosd.multithPract.Files.Read_write;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Reader implements Runnable {

    protected final List<Integer> listOfResults;
    File file = new File("src\\main\\resources\\multithreadingFiles\\input.txt");

    public Reader(List<Integer> listOfResults) {
        this.listOfResults = listOfResults;
    }

    @Override
    public void run() {
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            read(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void read(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            synchronized (listOfResults) {
                add(line);
            }
        }
    }

    private void add(String line) {
        listOfResults.add(addiction(line));
    }


    private int addiction(String line) {
        List<Integer> intList = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
        int first = intList.get(0);
        int second = intList.get(1);
        return first + second;
    }

}

