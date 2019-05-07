package com.study.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * FutureTask
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String s = futureTask.get();
        log.info("result:{}", s);

    }
}
