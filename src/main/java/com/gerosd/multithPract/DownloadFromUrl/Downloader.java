package com.gerosd.multithPract.DownloadFromUrl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Downloader implements Runnable {
    private static final String url = "https://w.forfun.com/fetch/11/111f83349a9ecaef536b1f65c769c32f.jpeg";

    @Override
    public void run() {
        try {
            download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void download() throws IOException {
        FileUtils.copyURLToFile(new URL(url), new File("D:\\загрузки\\photo.png"));
    }
}
