package com.study.andersen.gof.structural.facade.codec;

public enum CompressionCodec {
    MPEG4("mp4"),
    OGG("ogg");

    private final String value;

    CompressionCodec(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
