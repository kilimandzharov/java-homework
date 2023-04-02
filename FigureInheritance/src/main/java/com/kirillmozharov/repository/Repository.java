package com.kirillmozharov.repository;

import com.kirillmozharov.model.*;
import com.kirillmozharov.util.ParType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private ArrayList<Figure> figures = new ArrayList<>();

    public Repository(){

    }

    /**
     * 4. Написать метод добавления фигуры в список фигур
     *
     * @param figure
     */
    public void add(Figure figure) {
        this.figures.add(figure);
    }

    /**
     * 5. Написать метод, который выводит весь список фигур в csv. Заранее в классе Figure написать метод
     * toCSV(название фигуры;стороны фигуры) и переопределить для наследников при необходимости, далее вызывать
     * его в классе репозитория в методе вывода для каждого объекта из списка
     * @param name
     * @throws IOException
     */
    public void save(String name) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name))) {
            bufferedWriter.write("Figure;Sides\n");
            for (Figure figure : this.figures) {
                String line = figure.toCSV();
                bufferedWriter.write(line + "\n");
            }
        }
    }

    /**
     * 6.	Написать метод, который выводит из репозитория все объекты Triangle в формате CSV
     *
     * @param name
     * @param type
     * @throws IOException
     */
    public void saveTriangles(String name) throws IOException {
        List<Figure> figureArrayList = this.figures.stream()
                .filter(figure -> figure instanceof Triangle).toList();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name))) {
            bufferedWriter.write("Figure;Sides\n");
            for (Figure figure : figureArrayList) {
                String line = figure.toCSV();
                bufferedWriter.write(line + "\n");
            }
        }
    }

    /**
     * 7. Вычислить сумму площадей всех фигур
     *
     * @return
     */
    public double getAllSquares() {
        double sumSquare = 0;
        for (Figure figure : this.figures) {
            sumSquare += figure.getSquare();
        }
        return sumSquare;
    }

    /**
     * 9.	Найти все фигуры - прямоугольники с наибольшим периметром
     *
     * @return
     */
    public ArrayList<Figure> getRectanglesWithBiggestPerimeter() {
        double maxPerOfSquares = 0;
        for (Figure figure : rectangleList) {
            if (figure instanceof Rectangle && figure.getPerimeter() > maxPerOfSquares) {
                maxPerOfSquares = figure.getPerimeter();
            }
        }
        ArrayList<Figure> result = new ArrayList<>();
        for (Figure figure : rectangleList) {
            if (figure instanceof Rectangle && figure.getPerimeter() == maxPerOfSquares) {
                result.add(figure);
            }
        }
        return result;
    }

    /**
     * 8. Для каждой фигуры из списка вызвать методы square() и perimeter().
     * Вернуть название фигуры, площадь и ее периметр
     *
     * @return
     */
    public String getNameSquareAndPerimeter() {
        StringBuilder result = new StringBuilder();
        for (Figure figure : this.figures) {
            result.append(figure.getClass().getSimpleName()).append(";");
            result.append(figure.getPerimeter()).append(";");
            result.append(figure.getSquare()).append("\n");
        }
        return result.toString();
    }

    /**
     * 10.Найти наименее удалённые фигуры по параметру, переданному в аргументе (либо площадь либо периметр)
     * в виде Enum
     */
    public List<Figure> getClosestFigures(ParType parType) {
        List<Figure> result = new ArrayList<>();
        double minDiff = Double.MAX_VALUE;
        for (int i = 0; i < this.figures.size(); i++) {
            for (int i1 = i + 1; i1 < this.figures.size(); i1++) {
                Figure firstFigure = this.figures.get(i);
                Figure secondFigure = this.figures.get(i1);
                double firstMeasure = parType == ParType.PERIMETER ?
                        firstFigure.getPerimeter() : firstFigure.getSquare();
                double secondMeasure = parType == ParType.PERIMETER ?
                        secondFigure.getPerimeter() : secondFigure.getSquare();
                double diff = Math.abs(firstMeasure - secondMeasure);
                if (diff < minDiff) {
                    minDiff = diff;
                    result = new ArrayList<>();
                    result.add(firstFigure);
                    result.add(secondFigure);
                }
                if (diff == minDiff) {
                    if (!this.figures.contains(firstFigure)) {
                        result.add(firstFigure);
                    }
                    if (!this.figures.contains(secondFigure)) {
                        result.add(secondFigure);
                    }
                }
            }
        }
        return result;
    }
}
