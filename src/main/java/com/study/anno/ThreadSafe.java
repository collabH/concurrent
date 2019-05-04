package com.study.anno;

import java.lang.annotation.*;

/**
 * 代表线程安全的
 *
 * @author huangsm
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
