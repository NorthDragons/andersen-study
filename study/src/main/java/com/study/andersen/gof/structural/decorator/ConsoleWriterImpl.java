package com.study.andersen.gof.structural.decorator;

import com.study.andersen.gof.structural.decorator.api.ConsoleWriter;

public class ConsoleWriterImpl implements ConsoleWriter {

    @Override
    public void writeData(String data) {
        System.out.println(data);
    }
}
