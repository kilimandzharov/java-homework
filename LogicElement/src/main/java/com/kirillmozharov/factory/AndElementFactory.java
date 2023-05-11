package com.kirillmozharov.factory;

import com.kirillmozharov.factory.AbstractElementFactory;
import com.kirillmozharov.model.And;
import com.kirillmozharov.model.LogicElement;

public class AndElementFactory implements AbstractElementFactory {
    @Override
    public LogicElement getInstance(int n) {
        return new And(n);
    }
}
