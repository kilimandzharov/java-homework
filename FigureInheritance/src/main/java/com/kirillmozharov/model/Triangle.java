package com.kirillmozharov.model;

import java.util.Objects;

public class Triangle extends Figure {
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        super(a);
        this.b = b;
        this.c = c;
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

    @Override
    public double getSquare() {
        double semiPerimeter = this.getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - this.getA()) *
                (semiPerimeter - this.b) * (semiPerimeter - this.c));
    }

    @Override
    public double getPerimeter() {
        return this.getA() + this.b + this.c;
    }
    @Override
    public boolean equals(Object o) {
         if(!super.equals(o)){
             return false;
         }
         Triangle triangle = (Triangle) o;
         return (this.b == triangle.b) && (this.c == triangle.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), b, c);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + ",b=" + this.b + ",c=" + this.c + "}";
    }

    @Override
    public String toCSV() {
        String otherSides = ";" + b + ";" + c;
        return super.toCSV() + otherSides;
    }
}
