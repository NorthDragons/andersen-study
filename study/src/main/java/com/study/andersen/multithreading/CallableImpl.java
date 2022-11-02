package com.study.andersen.multithreading;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CallableImpl<V> implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("CallableImpl" +
                Thread.currentThread().getName() + "Started at + " + LocalTime.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("InterruptedException" + e);
        }
        System.out.println(
                Thread.currentThread().getName() + "Complete the task at + " + LocalTime.now());
        return Thread.currentThread().getName();
    }
}
