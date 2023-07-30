package com.kirillmozharov.model;

public class MultCalculator extends NumberCalculator {
    public MultCalculator() {
    }

    public MultCalculator(int n) {
        super(n);
    }

    @Override
    protected int operation(int a, int b) {
        return a * b;
    }
}
