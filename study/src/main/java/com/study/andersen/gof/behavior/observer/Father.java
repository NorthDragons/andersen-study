package com.study.andersen.gof.behavior.observer;

public class Father {
    public static final EventManager events;
    private String place;

    static  {
        events = new EventManager("bought ice cream", "bought groceries");
    }

    public void buyIceCream(String place) {
        this.place = place;
        events.notify("bought ice cream", this.place);
    }

    public void buyGroceries(String place) {
        this.place = place;
        events.notify("bought groceries", this.place);
    }
}
