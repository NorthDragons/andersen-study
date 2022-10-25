package com.study.andersen.gof.structural.facade.operations;

import com.study.andersen.gof.structural.facade.VideoFile;
import java.io.File;

public class AudioMixer {
    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}