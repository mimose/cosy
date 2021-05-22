package com.mimose.cosy.lang;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * @author mimose
 * @description Collects
 * @date 2021/4/24
 */
public final class Collects {

    private Collects() {}

    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean contains(@Nullable Iterator<?> iterator, Object element) {
        if (iterator != null) {
            while(iterator.hasNext()) {
                Object candidate = iterator.next();
                if (Objs.equals(candidate, element)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean contains(@Nullable Enumeration<?> enumeration, Object element) {
        if (enumeration != null) {
            while(enumeration.hasMoreElements()) {
                Object candidate = enumeration.nextElement();
                if (Objs.equals(candidate, element)) {
                    return true;
                }
            }
        }

        return false;
    }
}
