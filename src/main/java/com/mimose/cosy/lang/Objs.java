package com.mimose.cosy.lang;

import com.mimose.cosy.api.function.ISupplier;
import com.mimose.cosy.excepitons.utils.ExceptionUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * @author mimose
 * @description Objects
 * @date 2021/4/23
 */
public final class Objs {

    private Objs() {}

    public static boolean nonNull(@Nullable Object obj) {
        return obj != null;
    }

    public static boolean isNull(@Nullable Object obj) {
        return obj == null;
    }

    public static <T> T requireNonNull(@Nullable T obj, String message) {
        return requireNonNull(obj, () -> new IllegalArgumentException(message));
    }

    public static <T> T requireNonNull(@Nullable ISupplier<T> objSupplier, String message) {
        return requireNonNull(objSupplier, () -> new IllegalArgumentException(message));
    }

    public static <T> T requireNonNull(@Nullable T obj, @Nonnull Supplier<RuntimeException> nullExSupplier) {
        if(nullExSupplier == null) {
            throw new NullPointerException();
        }
        if(obj == null) {
            throw nullExSupplier.get();
        }
        return obj;
    }

    public static <T> T requireNonNull(@Nullable ISupplier<T> objSupplier, @Nonnull Supplier<RuntimeException> nullExSupplier) {
        if(nullExSupplier == null) {
            throw new NullPointerException();
        }
        if(objSupplier == null) {
            throw nullExSupplier.get();
        }
        final T obj;
        try {
            obj = objSupplier.get();
            return requireNonNull(obj, nullExSupplier);
        } catch (Exception e) {
            throw ExceptionUtil.uncheked(e);
        }
    }

    public static <O1, O2> boolean equals(O1 obj1, O2 obj2) {
        return obj1 == obj2 && obj1.equals(obj2);
    }

    public static <O1, O2> boolean nonEquals(O1 obj1, O2 obj2) {
        return obj1 != null ? !obj1.equals(obj2) : obj2 != null;
    }
}
