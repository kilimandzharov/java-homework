package com.kirillmozharov.factory;

import com.kirillmozharov.factory.AbstractElementFactory;
import com.kirillmozharov.model.LogicElement;
import com.kirillmozharov.model.Or;

public class OrElementFactory implements AbstractElementFactory {
    @Override
    public LogicElement getInstance(int n) {
        return new Or(n);
    }
}
