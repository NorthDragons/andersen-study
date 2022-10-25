package com.study.andersen.gof.behavior.command.mail;

public class Gmail {
    public void sendMessage(String message) {
        System.out.println("Letter sent: " + message);
    }

    public void deleteMessage(String message) {
        System.out.println("Letter deleted: " + message);
    }
}
