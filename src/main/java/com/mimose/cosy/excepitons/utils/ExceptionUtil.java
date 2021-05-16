package com.mimose.cosy.excepitons.utils;

import com.mimose.cosy.excepitons.ArgumentException;
import com.mimose.cosy.excepitons.CommonRuntimeException;
import com.mimose.cosy.excepitons.UnsupportedOperationException;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author mimose
 * @description the util about Exception
 * @date 2021/4/24
 */
public final class ExceptionUtil {

    public static RuntimeException uncheked(Throwable throwable) {
        if(throwable instanceof RuntimeException) {
            return (RuntimeException) throwable;
        }
        return new CommonRuntimeException(throwable);
    }

    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static void throwArgumentException() {
        throw new ArgumentException();
    }

    public static void throwArgumentException(String message) {
        throw new ArgumentException(message);
    }

    public static void throwUnsupportedOperationException() {
        throw new UnsupportedOperationException();
    }

    public static void throwUnsupportedOperationException(String message) {
        throw new UnsupportedOperationException(message);
    }

}
