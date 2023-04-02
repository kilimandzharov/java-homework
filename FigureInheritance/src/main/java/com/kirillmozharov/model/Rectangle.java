package com.kirillmozharov.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Rectangle extends Figure {
    private double b;
    private double c;
    private double d;

    public Rectangle(double a, double b, double c, double d) {
        super(a);
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public double getPerimeter() {
        return this.getA() + this.b + this.c + this.d;
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
        return (this.b == rectangle.b) && (this.c == rectangle.c) && (this.d == rectangle.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), b, c);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + ",b="
                + this.b + ",c=" + this.c + ",d=" + this.d + "}";
    }

    @Override
    public String toCSV() {
        String otherSides = ";" + b + ";" + c + ";" + d;
        return super.toCSV() + otherSides;
    }
}
