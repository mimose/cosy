package com.mimose.cosy.api.function;

/**
 * @author mimose
 * @description function
 * @date 2021/4/24
 */
public interface IFunction<T, R> {

    R apply(T t);
}
