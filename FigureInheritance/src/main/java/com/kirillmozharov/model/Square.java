package com.kirillmozharov.model;

public class Square extends Figure {
    public Square(double a) {
        super(a);
    }

    @Override
    public double getSquare() {
        return Math.pow(this.getA(), 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * this.getA();
    }
}
