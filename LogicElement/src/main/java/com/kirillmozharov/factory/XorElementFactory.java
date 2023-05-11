package com.kirillmozharov.factory;

import com.kirillmozharov.factory.AbstractElementFactory;
import com.kirillmozharov.model.LogicElement;
import com.kirillmozharov.model.Xor;

public class XorElementFactory implements AbstractElementFactory {
    @Override
    public LogicElement getInstance(int n) {
        return new Xor(n);
    }
}
