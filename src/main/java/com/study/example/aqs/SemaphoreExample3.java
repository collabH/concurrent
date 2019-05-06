package com.study.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExample3 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    //尝试获取一个许可，获取了就是释放掉
                    if (semaphore.tryAcquire(5, TimeUnit.SECONDS)) {
                        test(threadNum);
                        semaphore.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
