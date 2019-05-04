package com.study.example.singleton;


import com.study.anno.Recommend;
import com.study.anno.ThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时进行创建
 * 双重同步锁单例模式
 *
 * @author huangsm
 * @version V1.0
 */
@ThreadSafe
@Recommend
public class SingletonExample4 {
    private SingletonExample4() {
    }

    /**
     * 单例对象
     * 加上volatile方式禁止new SingletonExample4();操作时指令重排序
     * <p>
     * 1、memory=allocate()分配对象的内存空间
     * 2、ctorInstance()初始化对象
     * 3、instance=memory设置instance指向刚分配的内存
     *
     * JVM和cpu优化，发生了指令重排
     *
     * 指令顺序会编程 1 3 2
     */
    private static volatile SingletonExample4 instance = null;

    /**
     * 静态工厂方法来获取
     *
     * @return
     */
    public static SingletonExample4 getInstance() {

        if (instance == null) {  // B
            //双重检测机制
            synchronized (SingletonExample4.class) {
                //同步锁
                if (instance == null) {
                    instance = new SingletonExample4(); // A -3
                }
            }

        }
        return instance;
    }
}
