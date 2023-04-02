package com.kirillmozharov.util;

import com.kirillmozharov.model.LogicElement;

import java.lang.reflect.InvocationTargetException;

public class Elements {
    /**
     * Объединяет два логических элемента
     * @param elements
     */
    static LogicElement union(LogicElement ...elements) {
        LogicElement currentVal = elements[0];
        for (int i = 1; i < elements.length; i++) {
            currentVal = currentVal.union(elements[i]);
        }
        return currentVal;
    }
}
