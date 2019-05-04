package com.study.example.singleton;

import com.study.anno.NotRecommend;
import com.study.anno.NotThreadSafe;
import com.study.anno.ThreadSafe;

/**
 * 懒汉模式synchronized
 * 单例的实例在第一次使用时进行创建
 *
 * @author huangsm
 * @version V1.0
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    private SingletonExample3() {
    }

    /**
     * 单例对象
     */
    private static SingletonExample3 instance = null;

    /**
     * 静态工厂方法来获取
     *
     * @return
     */
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
