package com.study.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample3 {
    private static final CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        //优先执行这个runnable
        log.info("runnable is running");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.info("{}", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
