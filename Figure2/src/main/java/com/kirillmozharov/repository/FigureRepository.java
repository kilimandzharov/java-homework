package com.kirillmozharov.repository;

import com.kirillmozharov.model.Calculator;
import com.kirillmozharov.model.Figure;
import com.kirillmozharov.model.FigureFactory;
import com.kirillmozharov.util.Functor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FigureRepository {

    public FigureRepository() {
    }

    /**
     * 1.	В классе Repository реализовать метод, принимающий на вход заполненное с клавиатуры множество различных
     * фигур, экземпляр перечисления и вычисляющий фигуру с максимальным значением переданного перечисления
     * @param functor
     * @param figuresFromKeyBoard
     * @return
     */
    public double calculateMaxFromList(Functor functor, List<Figure> figuresFromKeyBoard) {
        double result = 0;
        for (Figure figure : figuresFromKeyBoard) {
            Calculator calculator = new Calculator(figure);
            double localVal = calculator.calculate(functor);
            if (localVal > result) {
                result = localVal;
            }
        }
        return result;
    }

    /**
     * 2.	Реализовать метод, вычисляющий две наиболее удаленные друг от друга фигуры по переданному
     * признаку-перечислению
     * @param functor
     * @param figuresFromKeyBoard
     * @return
     */
    public List<Figure> calculateFarthest(Functor functor, List<Figure> figuresFromKeyBoard) {
        List<Figure> result = new ArrayList<>();
        double maxDiff = Double.MAX_VALUE;
        for (int i = 0; i < figuresFromKeyBoard.size(); i++) {
            for (int i1 = i + 1; i1 < figuresFromKeyBoard.size(); i1++) {
                Figure firstFigure = figuresFromKeyBoard.get(i);
                Figure secondFigure = figuresFromKeyBoard.get(i1);
                double firstMeasure = new Calculator(firstFigure).calculate(functor);
                double secondMeasure = new Calculator(secondFigure).calculate(functor);
                double diff = Math.abs(firstMeasure - secondMeasure);
                if (diff < maxDiff) {
                    maxDiff = diff;
                    result = new ArrayList<>();
                    result.add(firstFigure);
                    result.add(secondFigure);
                }
                if (diff == maxDiff) {
                    if (!figuresFromKeyBoard.contains(firstFigure)) {
                        result.add(firstFigure);
                    }
                    if (!figuresFromKeyBoard.contains(secondFigure)) {
                        result.add(secondFigure);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 1. В классе Repository реализовать метод, принимающий на вход имя текстового файла и множество
     * различных фигур и выполняющий сохранение данного множества в файл figures.csv в следующем формате:
     * название_фигуры;параметры_фигуры_через «;»;площадь;периметр
     * @param fileName
     * @param figuresToSave
     */
    public void saveFigures(String fileName, List<Figure> figuresToSave) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Figure figure : figuresToSave) {
                String csvLine = figure.toCsv();
                bufferedWriter.write(csvLine);
                bufferedWriter.write('\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 2.	Реализовать метод, который принимает на вход имя файла, где сохранено множество различных фигур,
     * объект фигуры, который необходимо заменить в файле и объект фигуры на которую требуется произвести замену.
     * Выполняет замену одной фигуры в файле на другую, используя рациональные алгоритмы решения
     * @param fileName
     * @param figureToReplace
     * @param figureToReplaceWith
     * @param figureFactoryMap
     */
    public void replaceFigures(String fileName, Figure figureToReplace, Figure figureToReplaceWith, Map<String,
            FigureFactory> figureFactoryMap) {
        List<Figure> figures = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] vals = line.split(";");
                String figureName = vals[0];
                FigureFactory figureFactory = figureFactoryMap.get(figureName);
                Figure figure = figureFactory.newInstance(Double.parseDouble(vals[1]), Double.parseDouble(vals[2]),
                        Arrays.copyOfRange(vals, 3, vals.length));
                figures.add(figure);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int figureToReplaceIndex = -1;
        for (Figure figure : figures) {
            if (figure.equals(figureToReplace)) {
                figureToReplaceIndex = figures.indexOf(figureToReplace);
            }
        }

        if (figureToReplaceIndex != -1) {
            figures.set(figureToReplaceIndex, figureToReplaceWith);
            this.saveFigures("replace-result.csv", figures);
        }
    }

}
