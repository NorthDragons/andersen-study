package com.study.andersen.gof.behavior.command.mail;

import com.study.andersen.gof.behavior.command.mail.api.Command;

public class MailRemoverCommand implements Command {
    private final Gmail gmail;

    public MailRemoverCommand(Gmail gmail) {
        this.gmail = gmail;
    }

    @Override
    public void execute(String message) {
        gmail.deleteMessage(message);
    }
}
