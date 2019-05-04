package com.study.example.singleton;

import com.study.anno.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时创建
 *  1、如果私有构造方法有过多的处理，可能会造成性能问题
 *  2、这个类肯定会被使用，不会带来资源的浪费
 * @author huangsm
 * @version V1.0
 */
@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2() {
    }

    /**
     * 单例对象
     */
    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 静态工厂方法来获取
     *
     * @return
     */
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
