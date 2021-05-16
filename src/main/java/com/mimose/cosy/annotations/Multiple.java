package com.mimose.cosy.annotations;

import java.lang.annotation.*;

/**
 * @author mimose
 * @description multiple instance
 * @date 2021/4/23
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Multiple {
}
