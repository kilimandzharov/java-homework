package com.kirillmozharov.model;

import java.util.Arrays;

public class And extends LogicElement {
    public And(int n) {
        super(n);
    }

    @Override
    protected boolean operation(boolean firstArg, boolean secondArg) {
        return firstArg && secondArg;
    }
}
