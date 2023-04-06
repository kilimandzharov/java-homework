package com.kirillmozharov.model;

import java.util.Objects;

public class Rectangle extends Figure {
    private double b;

    public Rectangle(double a, double b, double c, double d) {
        super(a);
        this.b = b;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }


    @Override
    public double getPerimeter() {
        return this.getA() + this.b;
    }

    @Override
    public double getSquare() {
        return this.getA() * this.b;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return (this.b == rectangle.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), b);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + ",b="
                + this.b + "}";
    }

    @Override
    public String toCSV() {
        String otherSides = ";" + b;
        return super.toCSV() + otherSides;
    }
}
