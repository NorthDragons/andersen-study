package com.study.andersen.multithreading;

import java.time.LocalTime;

public class RunnableImpl implements Runnable {
    private volatile Data data;

    public RunnableImpl(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.printf("%s started... Time: %s\n", Thread.currentThread().getName(),
                LocalTime.now());
        data.increment(Thread.currentThread().getName());
        data.printResult();
        System.out.printf("%s finished... Time: %s\n", Thread.currentThread().getName(),
                LocalTime.now());
    }

}
