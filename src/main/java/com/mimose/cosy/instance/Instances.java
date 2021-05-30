package com.mimose.cosy.instance;

import javax.annotation.Nonnull;

/**
 * @author mimose
 * @description instance handler
 * @date 2021/4/24
 */
public final class Instances {

    private Instances() {}

    public static <T> T singleton(@Nonnull Class<T> clazz) {
        return InstanceFactory.getInstance().singleton(clazz);
    }

    public static <T> T multiple(@Nonnull Class<T> clazz) {
        return InstanceFactory.getInstance().multiple(clazz);
    }

    public static <T> T decide(@Nonnull Class<T> clazz) {
        return InstanceFactory.getInstance().decide(clazz);
    }
}
