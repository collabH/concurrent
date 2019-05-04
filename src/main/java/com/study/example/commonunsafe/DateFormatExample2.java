package com.study.example.commonunsafe;

import com.study.anno.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 线程安全的SimpleDateFormat
 * 使用线程封闭方式，也可以使用ThreadLocal来封装SimpleDateFormat
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@ThreadSafe
public class DateFormatExample2 {
    /**
     * 请求总数
     */
    private static int clientTotal = 5000;
    /**
     * 同时并发执行的线程数
     */
    private static int threadTotal = 200;
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
    }

    private static void update() throws ParseException {
        //堆栈封闭的方式解决SimpleDateFormat线程不安全问题
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.parse("20190512");
    }
}
