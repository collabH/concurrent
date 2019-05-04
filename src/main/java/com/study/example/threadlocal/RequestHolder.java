package com.study.example.threadlocal;

import com.study.anno.Recommend;
import com.study.anno.ThreadSafe;

/**
 * ThreadLocal的应用
 *
 * @author huangsm
 * @version V1.0
 */
@ThreadSafe
@Recommend
public class RequestHolder {
    private final static ThreadLocal<Long> USER_ID = new ThreadLocal<>();

    public static void add(Long id) {
        USER_ID.set(id);
    }

    public static Long get() {
        return USER_ID.get();
    }

    public static void remove() {
        USER_ID.remove();
    }
}
