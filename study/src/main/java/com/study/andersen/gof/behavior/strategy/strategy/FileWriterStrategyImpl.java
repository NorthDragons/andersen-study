package com.study.andersen.gof.behavior.strategy.strategy;

import com.study.andersen.gof.behavior.strategy.strategy.api.WriteStrategy;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileWriterStrategyImpl implements WriteStrategy {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final StringBuilder finalMessage = new StringBuilder();

    @Override
    public void writeTheMessage(String message, String sender, String recipient) {
        collectMailDetails(sender, recipient, message);
        try (OutputStream fos = new FileOutputStream("./message")) {
            fos.write(finalMessage.toString().getBytes(), 0, finalMessage.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void collectMailDetails(String sender, String recipient, String message) {
        finalMessage.append("Sender: ").append(sender)
                .append("\nRecipient: ").append(recipient)
                .append("\n").append(message);
    }


}
