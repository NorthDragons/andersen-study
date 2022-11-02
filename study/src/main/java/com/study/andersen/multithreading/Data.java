package com.study.andersen.multithreading;

import java.util.HashMap;

public class Data {
    private final HashMap<String, Integer> values = new HashMap<>();

    private volatile boolean transfer = false;
    private int value = 0;

    public synchronized void increment(String name) {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        transfer = true;
        values.put(name, value);
        value += 5;
        transfer = false;
    }

    public void printResult() {
        System.out.println(values);
    }

    public HashMap<String, Integer> getMap() {
        return values;
    }
}