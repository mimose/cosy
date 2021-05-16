package com.mimose.cosy.annotations;

import java.lang.annotation.*;

/**
 * @author mimose
 * @description single instance
 * @date 2021/4/23
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Singleton {
}
