package com.kirillmozharov.model;

public class Xor extends LogicElement {
    public Xor(int n) {
        super(n);
    }

    @Override
    protected boolean operation(boolean firstArg, boolean secondArg) {
        return firstArg ^ secondArg;
    }


}
