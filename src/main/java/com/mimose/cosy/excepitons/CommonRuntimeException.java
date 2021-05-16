package com.mimose.cosy.excepitons;

/**
 * @author mimose
 * @description common runtime exception
 * @date 2021/4/24
 */
public class CommonRuntimeException extends RuntimeException {

    public CommonRuntimeException() {
        super();
    }

    public CommonRuntimeException(String message) {
        super(message);
    }

    public CommonRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonRuntimeException(Throwable cause) {
        super(cause);
    }

    protected CommonRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
