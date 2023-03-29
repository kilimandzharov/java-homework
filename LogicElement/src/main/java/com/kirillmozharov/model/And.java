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

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        LogicElement obj = (LogicElement) o;
        return Arrays.equals(obj.entries, this.entries);
    }
}
