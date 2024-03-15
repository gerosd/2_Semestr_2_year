package com.gerosd.multithPract.DownloadFromUrl;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ImageHandler implements Runnable{
    ImagePlus imagePlus = IJ.openImage("D:\\загрузки\\photo.png");
    ImageProcessor imageProcessor = imagePlus.getProcessor();

    @Override
    public void run() {
        imageProcessing();
    }

    private void imageProcessing() {
        imageProcessor.drawRect(10, 10, imageProcessor.getWidth() - 50, imageProcessor.getHeight() - 50);
        imagePlus.show();
    }
}
