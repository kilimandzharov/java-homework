package com.kirillmozharov.model;

public class Or extends LogicElement {
    public Or(int n) {
        super(n);
    }

    @Override
    protected boolean operation(boolean firstArg, boolean secondArg) {
        return firstArg || secondArg;
    }


}
