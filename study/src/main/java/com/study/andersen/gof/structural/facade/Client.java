package com.study.andersen.gof.structural.facade;

import com.study.andersen.gof.structural.facade.codec.CompressionCodec;
import java.io.File;

public class Client {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", CompressionCodec.MPEG4);
        System.out.println(mp4Video.toString());
    }
}