package com.mimose.cosy.lang;

import java.util.Objects;

/**
 * @author mimose
 * @description Strings
 * @date 2021/4/23
 */
public final class Strings {

    private Strings() {}

    private static final String EMPTY_STR = empty();

    private static String empty() {
        return "";
    }

    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    public static String optionalOrGetEmpty(Object obj) {
        return Objects.isNull(obj) ? EMPTY_STR : obj.toString();
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen = length(cs);
        if (strLen == 0) {
            return true;
        } else {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }
}
