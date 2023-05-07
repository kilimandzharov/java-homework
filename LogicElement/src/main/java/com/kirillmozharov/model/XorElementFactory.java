package com.kirillmozharov.model;

public class XorElementFactory implements AbstractElementFactory {
    @Override
    public LogicElement getInstance(int n) {
        return new Xor(n);
    }
}
