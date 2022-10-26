package com.study.andersen.gof.behavior.strategy.strategy.api;

public interface WriteStrategy {
    void writeTheMessage(String message, String sender, String recipient);
}
