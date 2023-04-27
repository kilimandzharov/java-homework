package com.kirillmozharov.model;

public class RectangleFactory implements FigureFactory {
    @Override
    public Figure newInstance(double a, double b, String... others) {
        return new Rectangle(a, b);
    }
}
