package com.mimose.cosy.api.cache;

/**
 * @author mimose
 * @description
 * @date 2021/4/24
 */
public interface ICache<K, V> {

    V get(K key);

    boolean set(K key, V value);
}
