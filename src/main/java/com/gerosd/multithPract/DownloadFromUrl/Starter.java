package com.gerosd.multithPract.DownloadFromUrl;

public class Starter {
    private static final Downloader downloadRunnable = new Downloader();
    private static final Thread download = new Thread(downloadRunnable);
    private static final ImageHandler handler = new ImageHandler();
    private static final Thread imageHandler = new Thread(handler);

    public static void main(String[] args) {
        //imageHandler.start();
        download.start();
    }
}
