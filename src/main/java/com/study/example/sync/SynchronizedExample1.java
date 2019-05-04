package com.study.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {
    /**
     * 修饰一个代码块，作用对象调用这个方法对象,俩个对象不同，调用方法顺序不同
     */
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1{}-{}", j, i);
            }
        }
    }

    /**
     * 修饰一个方法，作用对象调用这个方法对象
     * 如果子类调用这个方法，是不带synchronized的，因为synchronized不是方法声明的一部分
     */
    private synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}", i);
        }
    }

    /**
     * 修饰一个静态方法，作用于这个类对象，所有对象
     */
    private static synchronized void test3() {
        for (int i = 0; i < 10; i++) {
            log.info("test3-{}", i);
        }
    }

    /**
     * 同步代码块，作用于这个类对象，所有对象
     *
     * @param j
     */
    private void test4(int j) {
        synchronized (SynchronizedExample1.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test4{}-{}", j, i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() ->
                //example1.test1()
                example1.test4(1)
        );
        pool.execute(() ->
                //example1.test1()
                example1.test4(2)
        );
    }
}
