package com.study.andersen.gof.structural.decorator;

import com.study.andersen.gof.structural.decorator.api.ConsoleWriter;

public class Editor extends ConsoleWriterDecorator {
    private int compLevel = 6;

    public Editor(ConsoleWriter source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compLevel;
    }

    public void setCompressionLevel(int value) {
        compLevel = value;
    }

    @Override
    public void writeData(String data) {
        super.writeData(addText(data));
    }

    private String addText(String stringData) {
        return stringData + " successfully";
    }
}