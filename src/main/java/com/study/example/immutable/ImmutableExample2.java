package com.study.example.immutable;

import com.google.common.collect.Maps;
import com.study.anno.NotThreadSafe;
import com.study.anno.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * 使用Collections.unmodifiableMap(map)
 *
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //报错
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

}
