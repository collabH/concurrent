package com.study.example.immutable;

import com.google.common.collect.Maps;
import com.study.anno.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 简单测试final的使用
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
    }

    public static void main(String[] args) {
        //a=2; 编译错误
        //b="4";
        //map=Maps.newHashMap();引用类型不能执行另一个对象
        map.put(1,3);
        log.info("{}",map.get(1));
    }

    public void test(final int a){
       //a=1;不允许修改
    }
}
