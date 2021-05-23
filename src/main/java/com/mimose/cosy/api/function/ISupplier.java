package com.mimose.cosy.api.function;

/**
 * @author mimose
 * @description supplier with exception
 * @date 2021/4/24
 */
public interface ISupplier<T> {

    T get() throws Exception;

}
