package com.kirillmozharov.model;

import java.util.Objects;

public abstract class Figure {
    private double a;

    public Figure() {
    }

    public Figure(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public abstract double getPerimeter();
    public abstract double getSquare();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Double.compare(figure.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "a=" + a +
                '}';
    }

    public String toCSV() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append(';').append(this.a);
        return stringBuilder.toString();
    }
}
