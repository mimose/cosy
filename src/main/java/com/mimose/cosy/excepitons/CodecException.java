package com.mimose.cosy.excepitons;

/**
 * @author mimose
 * @description codec runtime exception
 * @date 2021/4/24
 */
public final class CodecException extends CommonRuntimeException{

    public CodecException() {
        super();
    }

    public CodecException(String message) {
        super(message);
    }

    public CodecException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodecException(Throwable cause) {
        super(cause);
    }

    protected CodecException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
