package com.mimose.cosy.api.pipeline;

import java.util.List;

/**
 * @author mimose
 * @description pipline
 * @date 2021/4/24
 */
public interface IPipeline<T> {

    IPipeline addLast(T object);

    IPipeline addFirst(T object);

    IPipeline set(int index, T object);

    IPipeline removeLast();

    IPipeline removeFirst();

    IPipeline remove(int index);

    T get(int index);

    T getFirst();

    T getLast();

    List<T> list();

    List<T> slice(int startIndex, int endIndex);
}
