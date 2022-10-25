package com.study.andersen.gof.structural.decorator;

import com.study.andersen.gof.structural.decorator.api.ConsoleWriter;


public class Client {
    public static void main(String[] args) {
        String salaryRecords = "test";
        ConsoleWriterDecorator encoded = new Editor(
                new FinalEdditor(
                        new ConsoleWriterImpl()));
        encoded.writeData(salaryRecords);
        ConsoleWriter plain = new ConsoleWriterImpl();
        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
    }
}
