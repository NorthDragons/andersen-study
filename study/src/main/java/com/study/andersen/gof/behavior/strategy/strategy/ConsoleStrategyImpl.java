package com.study.andersen.gof.behavior.strategy.strategy;

import com.study.andersen.gof.behavior.strategy.strategy.api.WriteStrategy;

public class ConsoleStrategyImpl implements WriteStrategy {
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
