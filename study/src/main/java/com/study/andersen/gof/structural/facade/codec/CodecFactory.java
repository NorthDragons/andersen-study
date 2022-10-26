package com.study.andersen.gof.structural.facade.codec;

import com.study.andersen.gof.structural.facade.VideoFile;

public class CodecFactory {
    public static CompressionCodec extract(VideoFile file) {
        CompressionCodec type = file.getCodecType();
        if (type.equals(CompressionCodec.MPEG4)) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return CompressionCodec.MPEG4;
        } else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return CompressionCodec.OGG;
        }
    }
}