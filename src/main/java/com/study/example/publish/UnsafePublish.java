package com.study.example.publish;

import com.study.anno.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 发布对象
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info(Arrays.toString(unsafePublish.getStates()));

        //修改私有属性的值
        unsafePublish.getStates()[0] = "d";
        log.info(Arrays.toString(unsafePublish.getStates()));
    }

}
