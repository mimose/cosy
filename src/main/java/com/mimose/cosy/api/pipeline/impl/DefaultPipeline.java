package com.mimose.cosy.api.pipeline.impl;

import com.mimose.cosy.api.pipeline.IPipeline;
import com.mimose.cosy.collect.Lists;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mimose
 * @description default pipeline by LinkedList
 * @date 2021/4/24
 */
public class DefaultPipeline<T> implements IPipeline<T> {

    private LinkedList<T> list = Lists.newLinkedList();

    @Override
    public IPipeline addLast(T object) {
        this.list.addLast(object);
        return this;
    }

    @Override
    public IPipeline addFirst(T object) {
        this.list.addFirst(object);
        return this;
    }

    @Override
    public IPipeline set(int index, T object) {
        this.list.set(index, object);
        return this;
    }

    @Override
    public IPipeline removeLast() {
        this.list.removeLast();
        return this;
    }

    @Override
    public IPipeline removeFirst() {
        this.list.removeFirst();
        return this;
    }

    @Override
    public IPipeline remove(int index) {
        this.list.remove(index);
        return this;
    }

    @Override
    public T get(int index) {
        return (T)this.list.get(index);
    }

    @Override
    public T getFirst() {
        return (T)this.list.getFirst();
    }

    @Override
    public T getLast() {
        return (T)this.list.getLast();
    }

    @Override
    public List<T> list() {
        return Lists.unmodifiableList(this.list);
    }

    @Override
    public List<T> slice(int startIndex, int endIndex) {
        return this.list.subList(startIndex, endIndex);
    }
}
