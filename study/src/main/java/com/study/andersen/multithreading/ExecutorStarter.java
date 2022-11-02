package com.study.andersen.multithreading;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorStarter {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Runnable " +
                    Thread.currentThread().getName() + "Started at + " + LocalTime.now());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error("InterruptedException" + e);
            }
            System.out.println(
                    Thread.currentThread().getName() + "Complete the task at + " + LocalTime.now());
        });
        executorService.submit(new CallableImpl<String>());
        try {
            if (!executorService.awaitTermination(4500, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
                System.out.println("executorService stopped the thread at +" + LocalTime.now());
            }
        } catch (InterruptedException e) {
            log.error("InterruptedException" + e);
        }
    }
}
