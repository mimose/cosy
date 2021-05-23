package com.mimose.cosy.api.cache.impl;

import com.mimose.cosy.annotations.Singleton;
import com.mimose.cosy.instance.Instances;
import com.mimose.cosy.lang.Classes;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author mimose
 * @description
 * @date 2021/4/24
 */
@Singleton
public class ClassFieldCache extends MemoryCache<Class, List<Field>> {

    private ClassFieldCache() {}

    private static class ClassFieldCacheHolder {
        private static ClassFieldCache INSTANCE = Instances.decide(ClassFieldCache.class);
    }

    public static ClassFieldCache getInstance() {
        return ClassFieldCacheHolder.INSTANCE;
    }

    @Override
    protected List<Field> buildValue(Class key) {
        return Classes.getAllFieldList(key);
    }
}
