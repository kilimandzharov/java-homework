package com.kirillmozharov.model;

public interface FigureFactory {
    Figure newInstance(double a, double b, String... others);
}
