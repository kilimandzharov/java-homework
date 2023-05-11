package com.kirillmozharov.factory;

import com.kirillmozharov.model.And;
import com.kirillmozharov.model.LogicElement;
import com.kirillmozharov.model.Or;
import com.kirillmozharov.model.Xor;
import com.kirillmozharov.util.ElementEnum;

public class SimpleElementFactory {
    public static LogicElement getInstance(ElementEnum elementEnum, int n) {
        switch (elementEnum) {
            case OR -> {
                return new Or(n);
            }
            case AND -> {
                return new And(n);
            }
            case XOR -> {
                return new Xor(n);
            }
            default -> {
                return null;
            }
        }
    }
}
