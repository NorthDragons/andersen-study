package com.study.andersen.gof.behavior.strategy;

import com.study.andersen.gof.behavior.strategy.strategy.ConsoleStrategyImpl;
import com.study.andersen.gof.behavior.strategy.strategy.FileWriterStrategyImpl;
import com.study.andersen.gof.behavior.strategy.strategy.api.WriteStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    private static final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("""
                Please enter a message recording method
                1 - Print message to console
                2 - Write message to file:
                """);
        Integer strategy = Integer.parseInt(inputStream());
        WriteStrategy writeStrategy = defineStrategy(strategy);
        System.out.println("""
                Please enter the message:
                """);
        String message = inputStream();
        System.out.println("Please enter sender's name");
        String sender = inputStream();
        System.out.println("Please enter recipient's name");
        String recipient = inputStream();
        writeStrategy.writeTheMessage(message,sender,recipient);

    }

    private static String inputStream() {
        String text = "";
        try {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Data entry error");
        }
        return text;
    }

    private static WriteStrategy defineStrategy(Integer value) {
        if (value == 1) {
            return new ConsoleStrategyImpl();
        } else {
            return new FileWriterStrategyImpl();
        }
    }
}
