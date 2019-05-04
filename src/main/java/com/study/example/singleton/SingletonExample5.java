package com.study.example.singleton;

import com.study.anno.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时创建
 * 1、如果私有构造方法有过多的处理，可能会造成性能问题
 * 2、这个类肯定会被使用，不会带来资源的浪费
 *
 * @author huangsm
 * @version V1.0
 */
@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5() {
    }


    /**
     * 单例对象
     */
    private static SingletonExample5 instance = null;

    static {
        instance = new SingletonExample5();
    }


    /**
     * 静态工厂方法来获取
     *
     * @return
     */
    public static SingletonExample5 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
