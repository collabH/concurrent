package com.study.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.study.anno.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用Collections.unmodifiableMap(map)
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.<Integer,Integer>builder().put(1,2).put(2,3).put(3,4).build();

    public static void main(String[] args) {
        //list.add(1);
        map.put(1,4);
    }

}
