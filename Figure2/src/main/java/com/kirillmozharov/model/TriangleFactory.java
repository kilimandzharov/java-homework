package com.kirillmozharov.model;

public class TriangleFactory implements FigureFactory {
    @Override
    public Figure newInstance(double a, double b, String... others) {
        return new Triangle(a, b, Double.parseDouble(others[0]));
    }
}
