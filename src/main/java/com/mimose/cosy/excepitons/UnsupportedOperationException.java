package com.mimose.cosy.excepitons;

/**
 * @author mimose
 * @description unsupport operate runtime exception
 * @date 2021/4/24
 */
public final class UnsupportedOperationException extends CommonRuntimeException {

    public UnsupportedOperationException() {
        super();
    }

    public UnsupportedOperationException(String message) {
        super(message);
    }

    public UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedOperationException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
