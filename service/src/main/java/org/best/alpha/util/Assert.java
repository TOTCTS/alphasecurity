package org.best.alpha.util;

import org.best.alpha.exception.NullPointException;
import org.best.alpha.exception.ParameterException;

import java.util.Collection;

/**
 * @author: BG336672
 * @create: 2018-09-27 10:45
 * @description:
 **/
public class Assert {

    public static void notNull(Object object, String message) {
        if (isNull(object)) {
            throw new NullPointException(message);
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static void notEmpty(String text, String message) {
        if (isEmpty(text)) {
            throw new ParameterException(message);
        }
    }

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (isEmpty(collection)) {
            throw new ParameterException(message);
        }
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static void isTure(Boolean result, String message) {
        if (result) {
            throw new ParameterException(message);
        }
    }

    public static void isFalse(Boolean result, String message) {
        if (!result) {
            throw new ParameterException(message);
        }
    }

}
