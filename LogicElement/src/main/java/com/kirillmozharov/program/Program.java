package com.kirillmozharov.program;

import com.kirillmozharov.model.And;
import com.kirillmozharov.model.LogicElement;

import java.lang.reflect.InvocationTargetException;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        LogicElement logicElement = new And(4);
        LogicElement second = new And(3);
             logicElement.fill(true,true,true,false);
             second.fill(true,true,true);
        System.out.println(logicElement.union(second));

    }
}
