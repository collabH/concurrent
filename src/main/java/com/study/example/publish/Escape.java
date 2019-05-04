package com.study.example.publish;

import com.study.anno.NotRecommend;
import com.study.anno.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象逸出
 *
 * @author huangsm
 * @version V1.0
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
