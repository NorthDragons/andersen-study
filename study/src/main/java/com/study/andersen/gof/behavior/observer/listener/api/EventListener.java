package com.study.andersen.gof.behavior.observer.listener.api;

public interface EventListener {
    void update(String eventType, String place);
}
