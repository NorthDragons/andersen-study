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
    public void writeTheMessage(String message) {
        collectMailDetails();
        finalMessage.append(message);
        try (OutputStream fos = new FileOutputStream("./message")) {
            fos.write(finalMessage.toString().getBytes(), 0, finalMessage.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
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
