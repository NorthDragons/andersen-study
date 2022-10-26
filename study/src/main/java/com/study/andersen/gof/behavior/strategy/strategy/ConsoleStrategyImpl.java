package com.study.andersen.gof.behavior.strategy.strategy;

import com.study.andersen.gof.behavior.strategy.strategy.api.WriteStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStrategyImpl implements WriteStrategy {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final StringBuilder finalMessage = new StringBuilder();

    @Override
    public void writeTheMessage(String message) {
        collectMailDetails();
        finalMessage.append(message);
        System.out.println(finalMessage);
    }

    private void collectMailDetails() {
        String sender = "";
        String recipient = "";
        try {
            System.out.println("Please enter sender's name");
            sender = reader.readLine();
            System.out.println("Please enter recipient's name");
            recipient = reader.readLine();
        } catch (IOException e) {
            System.out.println("Data entry error");
        }
        finalMessage.append("Sender: ").append(sender)
                .append("\nRecipient: ").append(recipient)
                .append("\n");
    }
}
