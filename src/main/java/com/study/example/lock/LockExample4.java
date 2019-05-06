package com.study.example.lock;

import com.study.anno.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@ThreadSafe
public class LockExample4 {
    /**
     * 请求总数
     */
    private static int clientTotal = 5000;
    /**
     * 同时并发执行的线程数
     */
    private static int threadTotal = 200;

    private static int count = 0;

    private static StampedLock lock = new StampedLock();


    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch lock = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                lock.countDown();
            });
        }
        lock.await();
        threadPool.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        long stamp = lock.writeLock();
        try {
            count++;
        } finally {
            lock.unlock(stamp);
        }

    }
}
