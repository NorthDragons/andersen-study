package com.study.andersen.gof.structural.facade;

import com.study.andersen.gof.structural.facade.codec.CodecFactory;
import com.study.andersen.gof.structural.facade.codec.api.Codec;
import com.study.andersen.gof.structural.facade.codec.MPEG4CompressionCodec;
import com.study.andersen.gof.structural.facade.codec.OggCompressionCodec;
import com.study.andersen.gof.structural.facade.operations.AudioMixer;
import com.study.andersen.gof.structural.facade.operations.BitrateReader;
import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}