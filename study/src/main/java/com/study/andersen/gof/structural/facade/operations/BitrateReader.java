package com.study.andersen.gof.structural.facade.operations;

import com.study.andersen.gof.structural.facade.VideoFile;
import com.study.andersen.gof.structural.facade.codec.api.Codec;

public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}