package com.mimose.cosy.api.function;

import com.mimose.cosy.excepitons.CommonRuntimeException;

/**
 * @author mimose
 * @description method api
 * @date 2021/4/24
 */
public interface IMethod<T> {

    ISupplier<T> methodGet() throws Exception;

    IFunction<Exception, ? extends CommonRuntimeException> wrapThrowable();

    default T run() {
        try {
            return methodGet().get();
        } catch (Exception e) {
            throw wrapThrowable().apply(e);
        }
    }
}
