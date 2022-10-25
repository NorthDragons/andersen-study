package com.study.andersen.gof.structural.decorator;

import com.study.andersen.gof.structural.decorator.api.ConsoleWriter;

public class FinalEdditor extends ConsoleWriterDecorator {

    public FinalEdditor(ConsoleWriter source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(addText(data));
    }

    private String addText(String data) {
        return data + " completed";
    }
}