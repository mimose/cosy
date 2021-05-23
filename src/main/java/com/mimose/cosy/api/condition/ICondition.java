package com.mimose.cosy.api.condition;

/**
 * @author mimose
 * @description condition
 * @date 2021/4/24
 */
public interface ICondition<T> {

    boolean match(T object);
}
