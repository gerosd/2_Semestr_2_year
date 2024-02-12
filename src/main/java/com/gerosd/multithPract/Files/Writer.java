package com.gerosd.multithPract.Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer implements Runnable {
    private final List<Integer> listOfResults;

    File file = new File("src\\main\\resources\\multithreadingFiles\\output.txt");

    public Writer (List<Integer> listOfResults) {
        this.listOfResults = listOfResults;
    }

    @Override
    public void run() {
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            synchronized (listOfResults) {
                writeFile(bufferedWriter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFile(BufferedWriter bufferedWriter) throws IOException {
        for (Integer result : listOfResults) {
            bufferedWriter.write(result.toString());
            bufferedWriter.newLine();
        }
    }
}
