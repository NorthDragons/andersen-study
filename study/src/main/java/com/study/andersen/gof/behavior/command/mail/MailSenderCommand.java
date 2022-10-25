package com.study.andersen.gof.behavior.command.mail;

import com.study.andersen.gof.behavior.command.mail.api.Command;

public class MailSenderCommand implements Command {
    private final Gmail gmail;

    public MailSenderCommand(Gmail gmail) {
        this.gmail = gmail;
    }
    @Override
    public void execute(String message) {
        gmail.sendMessage(message);
    }
}
