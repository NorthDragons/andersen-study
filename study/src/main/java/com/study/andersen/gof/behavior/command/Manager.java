package com.study.andersen.gof.behavior.command;

import com.study.andersen.gof.behavior.command.mail.api.Command;

public class Manager {
    private final Command flipUpCommand;
    private final Command flipDownCommand;

    public Manager(Command flipUpCommand, Command flipDownCommand) {
        this.flipUpCommand = flipUpCommand;
        this.flipDownCommand = flipDownCommand;
    }

    public void send(String message) {
        flipUpCommand.execute(message);
    }

    public void remove(String message) {
        flipDownCommand.execute(message);
    }
}