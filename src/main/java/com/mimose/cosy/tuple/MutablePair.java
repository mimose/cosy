package com.mimose.cosy.tuple;

/**
 * @author mimose
 * @description mutable tuple with key and value
 * @date 2021/5/23
 */
public final class MutablePair<K, V> extends Pair<K, V> {

    public MutablePair(K key, V value) {
        super(key, value);
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setLeft(K left) {
        this.key = left;
    }

    public void setRight(V right) {
        this.value = right;
    }
}
