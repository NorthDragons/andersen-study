package com.study.andersen.multithreading;

import java.time.LocalTime;

public class ThreadImpl extends Thread implements Runnable {
    private final Data data;

    public ThreadImpl(Data data) {
        this.data = data;
    }

    public ThreadImpl(Data data, String name) {
        this.data = data;
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.printf("%s started... Time: %s\n", Thread.currentThread().getName(),
                LocalTime.now());
        data.increment(Thread.currentThread().getName());
        System.out.printf("%s finished... Time: %s\n", Thread.currentThread().getName(),
                LocalTime.now());
    }

}
