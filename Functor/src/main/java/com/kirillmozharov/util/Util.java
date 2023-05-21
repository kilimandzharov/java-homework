package com.kirillmozharov.util;

import com.kirillmozharov.model.Filter;

import java.lang.reflect.Array;
import java.util.function.Function;

public class Util {
    public static <T> T[] filter(T[] arr, Filter<T> tFilter) throws InstantiationException, IllegalAccessException {
        int count = 0;
        for (T t : arr) {
            if (tFilter.apply(t)) {
                count++;
            }
        }
        T[] result = (T[]) Array.newInstance(arr.getClass().getComponentType(), count);
        int index = 0;
        for (T t : arr) {
            if (tFilter.apply(t)) {
                result[index++] = t;
            }
        }
        return result;
    }

    public static <T> T[] filter(T[] arr, Function<T, Boolean> function) {
        int count = 0;
        for (T t : arr) {
            if (function.apply(t)) {
                count++;
            }
        }
        T[] result = (T[]) Array.newInstance(arr.getClass(), count);
        int index = 0;
        for (T t : arr) {
            if (function.apply(t)) {
                result[index++] = t;
            }
        }
        return result;
    }
}
