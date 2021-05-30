package com.mimose.cosy.instance;

import com.mimose.cosy.annotations.Singleton;
import com.mimose.cosy.api.function.IFunction;
import com.mimose.cosy.api.function.IMethod;
import com.mimose.cosy.api.function.ISupplier;
import com.mimose.cosy.collect.Maps;
import com.mimose.cosy.excepitons.ArgumentException;
import com.mimose.cosy.excepitons.CommonRuntimeException;
import com.mimose.cosy.excepitons.OperationException;
import com.mimose.cosy.lang.Objs;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * @author mimose
 * @description the instsance factory
 * @date 2021/4/24
 */
public final class InstanceFactory {
    private final Map<String, Object> singletonMap = Maps.newConcurrentMap(16);

    private InstanceFactory() {}

    private static class InstanceFactoryHolder {
        private static final InstanceFactory FACTORY = new InstanceFactory();
    }

    public static InstanceFactory getInstance() {
        return InstanceFactoryHolder.FACTORY;
    }

    public <T> T singleton(@Nonnull Class<T> clazz) {
        Objs.requireNonNull(clazz, () -> new ArgumentException("singleton fail, class is null"));
        String key = clazz.getName();
        T instance;
        if ((instance = (T) singletonMap.get(key)) == null) {
            singletonMap.put(key, instance = this.multiple(clazz));
        }
        return instance;
    }

    public <T> T multiple(@Nonnull Class<T> clazz) {
        Objs.requireNonNull(clazz, () -> new ArgumentException("multiple fail, class is null"));
        return (new IMethod<T>() {
            @Override
            public ISupplier<T> methodGet() throws Exception {
                return () -> clazz.newInstance();
            }
            @Override
            public IFunction<Exception, ? extends CommonRuntimeException> wrapThrowable() {
                return (e) -> new OperationException(e);
            }
        }).run();
    }

    public <T> T decide(@Nonnull Class<T> clazz) {
        Objs.requireNonNull(clazz, () -> new ArgumentException("decide fail, class is null"));
        if(clazz.isAnnotationPresent(Singleton.class)) {
            return this.singleton(clazz);
        }
        return this.multiple(clazz);
    }

}
