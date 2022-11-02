package com.study.andersen.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IncrementStarter {

    public static void main(String[] args) {
        Data data = new Data();
        RunnableImpl runnable = new RunnableImpl(data);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(runnable);
        ThreadImpl thread = new ThreadImpl(data, "first");
        ThreadImpl thread2 = new ThreadImpl(data, "second");
        Thread thread3 = new Thread(runnable, "third");
        thread.start();
        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            log.error("InterruptedException:" + e);
        }
        thread2.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            log.error("InterruptedException:" + e);
        }
        thread3.start();

        try {
            thread.join();
            thread2.join();
            thread3.join();
            executorService.shutdown();
        } catch (InterruptedException e) {
            log.error("InterruptedException:" + e);
        }
        System.out.println("All threads have completed, we complete the program");
    }
}

