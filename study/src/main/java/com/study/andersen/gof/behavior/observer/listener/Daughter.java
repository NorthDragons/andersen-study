package com.study.andersen.gof.behavior.observer.listener;

import com.study.andersen.gof.behavior.observer.listener.api.EventListener;

public class Daughter implements EventListener {
    @Override
    public void update(String eventType, String place) {
        System.out.println("The father went to the store and performed the following operations: " +
                eventType +
                " geolocation: " + place);
    }
}
