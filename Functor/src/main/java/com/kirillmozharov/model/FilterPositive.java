package com.kirillmozharov.model;

public class FilterPositive implements Filter<Integer> {
    @Override
    public boolean apply(Integer item) {
        return item < 0;
    }
}
