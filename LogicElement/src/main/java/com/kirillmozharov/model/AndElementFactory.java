package com.kirillmozharov.model;

public class AndElementFactory implements AbstractElementFactory {
    @Override
    public LogicElement getInstance(int n) {
        return new And(n);
    }
}
