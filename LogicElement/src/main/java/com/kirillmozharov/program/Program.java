package com.kirillmozharov.program;

import com.kirillmozharov.model.*;
import com.kirillmozharov.repository.ElementRepository;
import com.kirillmozharov.util.ElementEnum;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        /*LogicElement logicElement = new And(4);
        LogicElement second = new And(3);
             logicElement.fill(true,true,true,false);
             second.fill(true,true,true);
        System.out.println(logicElement.union(second));*/
        ElementRepository elementRepository = new ElementRepository("elements.csv");
        elementRepository.sort(null);
        Map<ElementEnum, AbstractElementFactory> factoryMap = new HashMap<>();
        factoryMap.put(ElementEnum.OR, new OrElementFactory());
        factoryMap.put(ElementEnum.AND, new AndElementFactory());
        factoryMap.put(ElementEnum.XOR, new XorElementFactory());
        ElementRepository elementRepository2 = new ElementRepository("elements.csv", factoryMap);
        elementRepository2.sort(null);
        System.out.println(elementRepository2.getElements());
    }
}
