package com.gerosd.multithPract.DownloadFromUrl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Downloader implements Runnable {
    private static final String url = "https://k0d.cc/storage/books/Architecture/Чистый%20код.%20Создание,%20анализ%20и%20рефакторинг%20(Мартин%202013).pdf";

    @Override
    public void run() {
        try {
            download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void download() throws IOException {
        FileUtils.copyURLToFile(new URL(url), new File("D:\\загрузки\\книга.pdf"));
    }
}
