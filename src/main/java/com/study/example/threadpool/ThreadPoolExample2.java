package com.study.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int count=i;
            exec.execute(()->{
                log.info("task is {}",count);
            });
        }
        exec.shutdown();
    }
}
