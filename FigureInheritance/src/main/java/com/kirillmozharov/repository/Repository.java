package com.kirillmozharov.repository;

import com.kirillmozharov.model.Figure;
import com.kirillmozharov.model.Square;
import com.kirillmozharov.model.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Repository {
    private ArrayList<Figure> figures = new ArrayList<>();

    public Repository() {
    }

    public void add(Figure figure) {
        this.figures.add(figure);
    }

    public String getAllFigures() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Figure figure : this.figures) {
            joiner.add(figure.toCSV());
        }
        return joiner.toString();
    }

    public String getAllTriangles() {
        StringJoiner joiner = new StringJoiner("\n");
        List<Figure> figureArrayList = this.figures.stream()
                .filter(figure -> figure instanceof Triangle).toList();
        for (Figure figure : figureArrayList) {
            joiner.add(figure.toCSV());
        }
        return joiner.toString();
    }

    public double getAllSquares() {
        double sumSquare = 0;
        for (Figure figure : this.figures) {
            sumSquare += figure.getSquare();
        }
        return sumSquare;
    }

    public ArrayList<Figure> getSquaresWithBiggestPerimeter() {
        double maxPerOfSquares = 0;
        List<Figure> squareList = this.figures.stream().filter(figure -> figure instanceof Square).toList();
        for (Figure figure : squareList) {
            if ( figure.getPerimeter() > maxPerOfSquares) {
                maxPerOfSquares = figure.getPerimeter();
            }
        }
        ArrayList<Figure> result = new ArrayList<>();
        for (Figure figure : squareList) {
            if (figure.getPerimeter() == maxPerOfSquares) {
                result.add(figure);
            }
        }
        return result;
    }


}
