package com.mimose.cosy.excepitons;

/**
 * @author mimose
 * @description loader runtime exception
 * @date 2021/4/24
 */
public final class LoaderException extends CommonRuntimeException {

    public LoaderException() {
        super();
    }

    public LoaderException(String message) {
        super(message);
    }

    public LoaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoaderException(Throwable cause) {
        super(cause);
    }

    protected LoaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
