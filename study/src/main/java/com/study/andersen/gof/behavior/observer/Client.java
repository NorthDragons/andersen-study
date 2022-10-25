package com.study.andersen.gof.behavior.observer;

import com.study.andersen.gof.behavior.observer.listener.Daughter;
import com.study.andersen.gof.behavior.observer.listener.Mother;

public class Client {
    public static void main(String[] args) {
        Father father = new Father();
        father.events.subscribe("bought ice cream", new Daughter());
        father.events.subscribe("bought groceries", new Mother());
        father.buyIceCream("shop near the house");
        father.buyGroceries("Biedronka");
    }
}
