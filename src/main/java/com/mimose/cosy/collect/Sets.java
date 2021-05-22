package com.mimose.cosy.collect;

import com.mimose.cosy.lang.Objs;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author mimose
 * @description Sets
 * @date 2021/4/23
 */
public final class Sets {

    private Sets() {}

    public static final Set EMPTY_SET = emptySet();

    public static <E> Set<E> emptySet() {
        return Collections.emptySet();
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSet(int capacity) {
        return new HashSet<>(capacity);
    }

    public static <E> HashSet<E> newHashSet(@Nonnull E[] elements) {
        Objs.requireNonNull(elements, "newHashSet fail, elements is null");
        HashSet<E> set = newHashSet(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet<>();
    }

    public static <C, E extends C> TreeSet<E> newTreeSet(@Nonnull Comparator<C> comparator) {
        return new TreeSet<>(Objs.requireNonNull(comparator, "newTreeSet fail, comparator is null"));
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(@Nonnull E[] elements) {
        return new CopyOnWriteArraySet<>(Lists.newArrayList(Objs.requireNonNull(elements, "newCopyOnWriteArraySet fail, elements is null")));
    }
}
