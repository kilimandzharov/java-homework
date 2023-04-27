package com.kirillmozharov.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Rectangle implements Figure {
    private double a;
    private double b;

    public Rectangle() {
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double square() {
        return a * b;
    }

    public double perimeter() {
        return 2 * (a + b);
    }

    public String getName() {
        return "Rectangle";
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.a, a) == 0 && Double.compare(rectangle.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public String toCsv() {
        StringJoiner stringJoiner = new StringJoiner(";");
        stringJoiner.add(this.getName()).add(Double.toString(this.a)).add(Double.toString(this.b))
                .add(Double.toString(this.perimeter())).add(Double.toString(this.square()));
        return stringJoiner.toString();
    }
}
