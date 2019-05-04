package com.study.example.singleton;

import com.study.anno.Recommend;
import com.study.anno.ThreadSafe;

/**
 * 枚举单例模式:最安全的
 *
 * @author huangsm
 * @version V1.0
 */
@ThreadSafe
@Recommend
public class SingletonExample6 {
    private SingletonExample6() {

    }

    public static SingletonExample6 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample6 singleton;

        /**
         * JVM保证这个方法绝对只调用一次
         */
        Singleton() {
            singleton = new SingletonExample6();
        }

        public SingletonExample6 getSingleton() {
            return singleton;
        }
    }
}
