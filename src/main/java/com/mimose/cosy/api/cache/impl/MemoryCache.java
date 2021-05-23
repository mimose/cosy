package com.mimose.cosy.api.cache.impl;

import com.mimose.cosy.api.cache.ICache;
import com.mimose.cosy.collect.Maps;
import com.mimose.cosy.lang.Objs;

import java.util.Map;

/**
 * @author mimose
 * @description cahce in memory
 * @date 2021/4/24
 */
public abstract class MemoryCache<K, V> implements ICache<K,V> {

    private final Map<K, V> cache = Maps.newConcurrentMap();

    @Override
    public V get(K key) {
        V result = (V)this.cache.get(key);
        if (Objs.nonNull(result)) {
            return result;
        }
        set(key, (result = (V)buildValue(key)));
        return result;
    }

    @Override
    public boolean set(K key, V value) {
        this.cache.put(key, value);
        return true;
    }

    protected abstract V buildValue(K key);
}
