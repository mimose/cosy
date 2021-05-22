package com.mimose.cosy.collect;

import com.mimose.cosy.lang.Objs;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mimose
 * @description Lists
 * @date 2021/4/23
 */
public final class Lists {

    private Lists() {}

    public static final List EMPTY_LIST = emptyList();

    public static <E> List<E> emptyList() {
        return Collections.emptyList();
    }

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> newArrayList(int capacity) {
        return new ArrayList<>(capacity);
    }

    public static <E> ArrayList<E> newArrayList(@Nonnull E[] elements) {
        Objs.requireNonNull(elements, "newArrayList fail, elements is null");
        ArrayList<E> list = newArrayList(elements.length);
        Collections.addAll(list, elements);
        return list;
    }

    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <E> LinkedList<E> newLinkedList(@Nonnull E[] elements) {
        Objs.requireNonNull(elements, "newLinkedList fail, elements is null");
        final LinkedList<E> list = new LinkedList<>();
        Collections.addAll(list, elements);
        return list;
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(@Nonnull E[] elements) {
        return new CopyOnWriteArrayList<>(Objs.requireNonNull(elements, "newCopyOnWriteArrayList fail, elements is null"));
    }

    public static <E> List<E> asList(@Nonnull E[] elements) {
        return Arrays.asList(Objs.requireNonNull(elements, "asList fail, elements is null"));
    }

    public static <E> List<E> unmodifiableList(List<E> list) {
        return Collections.unmodifiableList(list);
    }

    public static <E> List<E> singletonList(E object) {
        return Collections.singletonList(object);
    }
}
