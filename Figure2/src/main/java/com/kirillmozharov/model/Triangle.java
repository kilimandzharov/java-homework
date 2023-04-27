package com.kirillmozharov.model;

import java.util.StringJoiner;

public class Triangle implements Figure {
    private double a;
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double square() {
        double s = (((a + b + c) / 2) * ((a + b + c) / 2 - a) * ((a + b + c) / 2 - b) * ((a + b + c) / 2 - c));
        return Math.sqrt(s);
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public String getName() {
        return "Triangle";
    }

    @Override
    public String toCsv() {
        StringJoiner stringJoiner = new StringJoiner(";");
        stringJoiner.add(this.getName()).add(Double.toString(this.a)).add(Double.toString(this.b))
                .add(Double.toString(this.c)).add(Double.toString(this.perimeter())).add(Double.toString(this.square()));
        return stringJoiner.toString();
    }
}
