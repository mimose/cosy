package com.mimose.cosy.excepitons.utils;

import com.mimose.cosy.excepitons.ArgumentException;

import java.util.Collection;
import java.util.Objects;

/**
 * @author mimose
 * @description assert
 * @date 2021/4/24
 */
public final class Asserts {

    private Asserts() {}

    public static void notNull(Object obj, String message) {
        if(Objects.isNull(obj)) {
            throw new ArgumentException(message);
        }
    }

    public static void isNull(Object obj, String message) {
        if(Objects.nonNull(obj)) {
            throw new ArgumentException(message);
        }
    }

    public static void notBlank(String str, String message) {
        if(str == null || str.isEmpty()) {
            throw new ArgumentException(message);
        }
    }

    public static void isBlank(String str, String message) {
        if(str != null && !str.isEmpty()) {
            throw new ArgumentException(message);
        }
    }

    public static void notEmpty(Collection collection, String message) {
        if(collection == null || collection.isEmpty()) {
            throw new ArgumentException(message);
        }
    }

    public static void isEmpty(Collection collection, String message) {
        if(collection != null && !collection.isEmpty()) {
            throw new ArgumentException(message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        if(!expression) {
            throw new ArgumentException(message);
        }
    }

    public static void isFalse(boolean expression, String message) {
        if(expression) {
            throw new ArgumentException(message);
        }
    }
}
