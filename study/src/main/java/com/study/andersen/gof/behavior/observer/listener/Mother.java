package com.study.andersen.gof.behavior.observer.listener;

import com.study.andersen.gof.behavior.observer.listener.api.EventListener;

public class Mother implements EventListener {
    @Override
    public void update(String eventType, String place) {
        System.out.println("Husband went to the store and performed the operation: " + eventType +
                " geolocation: " + place);
    }
}
