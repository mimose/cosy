package com.mimose.cosy.excepitons;

/**
 * @author mimose
 * @description argument runtime exception
 * @date 2021/4/24
 */
public final class ArgumentException extends CommonRuntimeException {

    public ArgumentException() {
    }

    public ArgumentException(String message) {
        super(message);
    }

    public ArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentException(Throwable cause) {
        super(cause);
    }

    public ArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
