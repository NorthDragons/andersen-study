package com.study.andersen.gof.structural.decorator;


import com.study.andersen.gof.structural.decorator.api.ConsoleWriter;

public class ConsoleWriterDecorator implements ConsoleWriter {
    private ConsoleWriter wrappee;

    ConsoleWriterDecorator(ConsoleWriter source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

}