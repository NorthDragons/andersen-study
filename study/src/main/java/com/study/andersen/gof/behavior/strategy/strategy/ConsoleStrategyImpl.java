package com.study.andersen.gof.behavior.strategy.strategy;

import com.study.andersen.gof.behavior.strategy.strategy.api.WriteStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStrategyImpl implements WriteStrategy {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final StringBuilder finalMessage = new StringBuilder();

    @Override
    public void writeTheMessage(String message, String sender, String recipient) {
        collectMailDetails(sender, recipient, message);
        System.out.println(finalMessage);
    }

    private void collectMailDetails(String sender, String recipient, String message) {
        finalMessage.append("Sender: ").append(sender)
                .append("\nRecipient: ").append(recipient)
                .append("\n").append(message);
    }
}
