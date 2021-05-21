package com.mimose.cosy.collect;

import com.mimose.cosy.lang.Objs;
import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author mimose
 * @description Maps
 * @date 2021/4/23
 */
public final class Maps {

    private Maps() {}

    public static final Map EMPTY_MAP = emptyMap();

    public static <K, V> Map<K, V> emptyMap() {
        return Collections.emptyMap();
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMap(int capacity) {
        return new HashMap<>(capacity);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(int capacity) {
        return new LinkedHashMap<>(capacity);
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@NotNull Comparator<C> comparator) {
        return new TreeMap<>(Objs.requireNonNull(comparator, "newTreeMap fail, comparator is null"));
    }

    public static <K, V> ConcurrentMap newConcurrentMap() {
        return new ConcurrentHashMap<>();
    }

    public static <K, V> ConcurrentMap newConcurrentMap(int capacity) {
        return new ConcurrentHashMap<>(capacity);
    }
}
