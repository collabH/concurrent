package com.study.example.commonunsafe;

import com.study.anno.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * StringBuffer线程安全
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@ThreadSafe
public class StringExample2 {
    /**
     * 请求总数
     */
    private static int clientTotal = 5000;
    /**
     * 同时并发执行的线程数
     */
    private static int threadTotal = 200;

    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch lock = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                lock.countDown();
            });
        }
        lock.await();
        threadPool.shutdown();
        log.info("count:{}", stringBuffer.length());
    }

    private static void update() {
        stringBuffer.append("1");
    }
}
