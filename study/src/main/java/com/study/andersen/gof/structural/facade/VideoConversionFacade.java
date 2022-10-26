package com.study.andersen.gof.structural.facade;

import com.study.andersen.gof.structural.facade.codec.CodecFactory;
import com.study.andersen.gof.structural.facade.codec.CompressionCodec;
import com.study.andersen.gof.structural.facade.operations.AudioMixer;
import com.study.andersen.gof.structural.facade.operations.BitrateReader;
import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, CompressionCodec format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        CompressionCodec sourceCodec = CodecFactory.extract(file);
        CompressionCodec destinationCodec =
                format.equals(CompressionCodec.MPEG4) ?
                        CompressionCodec.MPEG4 : CompressionCodec.OGG;

        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}