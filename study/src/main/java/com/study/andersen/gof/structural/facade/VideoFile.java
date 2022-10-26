package com.study.andersen.gof.structural.facade;

import com.study.andersen.gof.structural.facade.codec.CompressionCodec;

public class VideoFile {
    private final String name;
    private final CompressionCodec codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType =
                name.substring(name.indexOf(".") + 1)
                        .equals(CompressionCodec.MPEG4.getValue()) ? CompressionCodec.MPEG4 :
                        CompressionCodec.OGG;
    }

    public CompressionCodec getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}