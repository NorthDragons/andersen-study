package com.study.andersen.gof.structural.facade.codec;

import com.study.andersen.gof.structural.facade.VideoFile;
import com.study.andersen.gof.structural.facade.codec.api.Codec;
import com.study.andersen.gof.structural.facade.codec.MPEG4CompressionCodec;
import com.study.andersen.gof.structural.facade.codec.OggCompressionCodec;

public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}