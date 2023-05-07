package com.kirillmozharov.model;

public class OrElementFactory implements AbstractElementFactory {
    @Override
    public LogicElement getInstance(int n) {
        return new Or(n);
    }
}
