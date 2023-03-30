package com.kirillmozharov.model;

public class Circle extends Figure {
    public Circle() {
    }

    public Circle(double side) {
        super(side);
    }

    @Override
    public double getPerimeter() {
        return Math.pow(this.getA(), 2) * Math.PI;
    }

    @Override
    public double getSquare() {
        return 2 * Math.PI * this.getA();
    }
}
