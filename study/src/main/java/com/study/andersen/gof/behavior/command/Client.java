package com.study.andersen.gof.behavior.command;

import com.study.andersen.gof.behavior.command.mail.Gmail;
import com.study.andersen.gof.behavior.command.mail.MailRemoverCommand;
import com.study.andersen.gof.behavior.command.mail.MailSenderCommand;
import com.study.andersen.gof.behavior.command.mail.api.Command;

public class Client {
    public static void main(String[] args) {
        Gmail gmail = new Gmail();
        Command mailRemoverCommand = new MailRemoverCommand(gmail);
        Command mailSenderCommand = new MailSenderCommand(gmail);
        Manager manager = new Manager(mailSenderCommand, mailRemoverCommand);
        manager.send("Any message");
        manager.remove("Any message");
    }
}
