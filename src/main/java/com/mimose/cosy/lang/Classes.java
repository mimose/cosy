package com.mimose.cosy.lang;

import com.mimose.cosy.api.condition.ICondition;
import com.mimose.cosy.api.function.IFunction;
import com.mimose.cosy.collect.Lists;
import com.mimose.cosy.collect.Maps;
import com.mimose.cosy.excepitons.CommonRuntimeException;
import com.mimose.cosy.excepitons.utils.Asserts;
import com.mimose.cosy.excepitons.utils.ExceptionUtil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author mimose
 * @description Class
 * @date 2021/4/24
 */
public final class Classes {

    public static List<Field> getAllFieldList(Class clazz) {
        List<Field> allFieldList = Lists.newArrayList();
        Class tempClass = clazz;
        while (tempClass != null) {
            allFieldList.addAll(Lists.newArrayList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }

        List<Field> resultList = Lists.newArrayList(allFieldList.size());
        for (Field field : allFieldList) {
            String fieldName = field.getName();

            if ("serialVersionUID".equals(fieldName)) {
                continue;
            }

            field.setAccessible(true);
            resultList.add(field);
        }
        return resultList;
    }

    public static List<Field> getModifyableFieldList(Class clazz) {
        List<Field> allFieldList = getAllFieldList(clazz);
        if (Collects.isEmpty(allFieldList)) {
            return allFieldList;
        }

        ICondition<Field> condition = new ICondition<Field>() {
            @Override
            public boolean match(Field field) {
                return Modifier.isFinal(field.getModifiers());
            }
        };

        if (Collects.isEmpty(allFieldList)) {
            return Lists.emptyList();
        }

        return allFieldList.stream().filter(field -> condition.match(field)).collect(Collectors.toList());
    }

    public static Map<String, Field> getAllFieldMap(Class clazz) {
        List<Field> fieldList = getAllFieldList(clazz);

        if (Objs.isNull(fieldList)) {
            return Maps.emptyMap();
        }

        IFunction<Field, String> keyFunction = new IFunction<Field, String>() {
            @Override
            public String apply(Field field) {
                return field.getName();
            }
        };

        return fieldList.stream().collect(Collectors.toMap(keyFunction::apply, Function.identity()));
    }

    public static List<Method> getAllFieldsReadMethods(Class clazz) throws IntrospectionException {
        List<Field> fieldList = getAllFieldList(clazz);
        if (Collects.isEmpty(fieldList)) {
            return Lists.emptyList();
        }

        List<Method> methods = Lists.newArrayList();
        for (Field field : fieldList) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);

            Method getMethod = pd.getReadMethod();
            methods.add(getMethod);
        }
        return methods;
    }

    public static Method getMethod(Class clazz, String methodName, Class... paramTypes) {
        Asserts.notNull(clazz, "clazz");
        Asserts.notBlank(methodName, "methodName");

        try {
            return clazz.getMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            throw ExceptionUtil.uncheked(e);
        }
    }

    public static Method getMethod(Class<?> clazz, String methodName) {
        Asserts.notNull(clazz, "clazz");
        Asserts.notBlank(methodName, "methodName");

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }

        throw new CommonRuntimeException("method not exists");
    }

    public static List<Method> getMethodList(Class tClass) throws IntrospectionException {
        Asserts.notNull(tClass, "tClass");

        Method[] methods = tClass.getMethods();
        return Lists.newArrayList(methods);
    }

    public static List<Method> getDeclaredMethodList(Class tClass) throws IntrospectionException {
        Asserts.notNull(tClass, "tClass");

        Method[] methods = tClass.getDeclaredMethods();
        return Lists.newArrayList(methods);
    }

}
