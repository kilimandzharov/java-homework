package com.kirillmozharov.model;

public class SumCalculator extends NumberCalculator {
    public SumCalculator() {
    }

    public SumCalculator(int n) {
        super(n);
    }

    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}
