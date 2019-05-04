package com.study.example.atomic;

import com.study.anno.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater类
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    /**
     * 修改一个类的fieldName字段
     */
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    /**
     * 必须为volatile关键字修饰，非static修饰
     */
    @Getter
    private volatile int count = 100;


    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success1:{}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success2:{}", example5.getCount());
        } else {
            log.info("update fail:{}", example5.getCount());
        }
    }
}
