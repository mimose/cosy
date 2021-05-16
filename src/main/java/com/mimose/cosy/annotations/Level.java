package com.mimose.cosy.annotations;

import java.lang.annotation.*;

/**
 * @author mimose
 * @description level in loader
 * @date 2021/4/24
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Level {

    Integer DEFAULT_PRIORITY = 0;

    /**
     * the priority value.
     * the default is 0, which means the lowest
     * @return
     */
    int priority() default 0;
}
