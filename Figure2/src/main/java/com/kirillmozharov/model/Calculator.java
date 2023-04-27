package com.kirillmozharov.model;

import com.kirillmozharov.util.Functor;

import java.util.Objects;

public class Calculator {
    private Figure figure;

    public Calculator() {
    }

    public Calculator(Figure figure) {
        this.figure = figure;
    }

    private double getPerimeter() {
        return this.figure.perimeter();
    }

    private double getSquare() {
        return this.figure.square();
    }

    /**
     * 5.	В классе Calculator написать метод calculate, принимающий на вход экземпляр перечисления и возвращающий
     * double – результат вычислений калькулятора для заданной фигуры в зависимости от переданного экземпляра перечисления
     * @param functor
     * @return
     */
    public double calculate(Functor functor) {
        if (functor == Functor.PERIMETER) {
            return this.getPerimeter();
        } else if (functor == Functor.SQUARE) {
            return this.getSquare();
        }
        return 0;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(figure, that.figure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figure);
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "figure=" + figure +
                '}';
    }
}
