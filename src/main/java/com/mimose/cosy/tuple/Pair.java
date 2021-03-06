package com.mimose.cosy.tuple;

import com.mimose.cosy.lang.Objs;
import com.mimose.cosy.tuple.api.IValOne;
import com.mimose.cosy.tuple.api.IValTwo;

/**
 * @author mimose
 * @description tuple with key and value
 * @date 2021/4/23
 */
public class Pair<K, V> implements IValOne<K>, IValTwo<V> {

    protected Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    protected K key;

    protected V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public K getLeft() {
        return this.key;
    }

    public V getRight() {
        return this.value;
    }

    @Override
    public K getValueOne() {
        return this.key;
    }

    @Override
    public V getValueTwo() {
        return this.value;
    }

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    @Override
    public String toString() {
        return this.key + "=" + this.value;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) o;
        if(Objs.nonEquals(this.getKey(), pair.getKey())) {
            return false;
        }
        if(Objs.nonEquals(this.getValue(), pair.getValue())) {
            return false;
        }
        return true;
    }
}
