package com.kirillmozharov.util;

import com.kirillmozharov.model.LogicElement;

import java.lang.reflect.InvocationTargetException;

public class Elements {
    /**
     * Объединяет два логических элемента
     * @param elements
     * @return
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    static LogicElement union(LogicElement ...elements) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        LogicElement currentVal = elements[0].union(elements[1]);
        for (int i = 2; i < elements.length; i++) {
            currentVal = currentVal.union(elements[i]);
        }
        return currentVal;
    }
}
