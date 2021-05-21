package com.mimose.cosy.tuple;

import com.mimose.cosy.lang.Objs;

/**
 * @author mimose
 * @description tuple with key and value
 * @date 2021/4/23
 */
public final class Pair<K, V> {

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K key;

    public V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
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
