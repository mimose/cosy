package com.mimose.cosy.excepitons;

/**
 * @author mimose
 * @description operate runtime exception
 * @date 2021/4/24
 */
public final class OperationException extends CommonRuntimeException {

    public OperationException() {
        super();
    }

    public OperationException(String message) {
        super(message);
    }

    public OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationException(Throwable cause) {
        super(cause);
    }

    protected OperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
