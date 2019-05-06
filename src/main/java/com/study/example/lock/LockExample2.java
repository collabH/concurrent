package com.study.example.lock;

import com.google.common.collect.Maps;
import com.study.anno.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@ThreadSafe
public class LockExample2 {

    private final Map<String, Data> map = Maps.newTreeMap();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    /**
     * 悲观读取，如果读多写上的话，会造成线程饥饿，比如读场景比较多，导致写一直在等待
     * @param key
     * @return
     */
    public Data get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public Data put(String key, Data val) {
        writeLock.lock();
        try {
            return map.put(key, val);
        } finally {
            writeLock.unlock();
        }
    }

    class Data {

    }
}
