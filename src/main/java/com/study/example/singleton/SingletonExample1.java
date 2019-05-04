package com.study.example.singleton;

import com.study.anno.NotThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时进行创建
 *
 * @author huangsm
 * @version V1.0
 */
@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1() {
    }

    /**
     * 单例对象
     */
    private static SingletonExample1 instance = null;

    /**
     * 静态工厂方法来获取
     *
     * @return
     */
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
