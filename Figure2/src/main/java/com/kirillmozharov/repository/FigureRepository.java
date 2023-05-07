package com.kirillmozharov.repository;

import com.kirillmozharov.model.Calculator;
import com.kirillmozharov.model.Figure;
import com.kirillmozharov.model.FigureSimpleFactory;
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
     *
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
     *
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
     *
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
     *
     * @param fileName
     * @param figureToReplace
     * @param figureToReplaceWith
     */
    public void replaceFigures(String fileName, Figure figureToReplace, Figure figureToReplaceWith) {
        ArrayList<String> figureStrings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                figureStrings.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int figureToReplaceIndex = -1;
        for (String figureString : figureStrings) {
            if (figureString.equals(figureToReplace.toCsv())) {
                figureToReplaceIndex = figureStrings.indexOf(figureToReplace.toCsv());
            }
        }

        if (figureToReplaceIndex != -1) {
            figureStrings.set(figureToReplaceIndex, figureToReplaceWith.toCsv());
            ArrayList<Figure> figures = new ArrayList<>();
            for (String figureString : figureStrings) {
                String[] vals = figureString.split(";");
                Figure figure = FigureSimpleFactory.getInstance(vals[0], Arrays.copyOfRange(vals, 1, vals.length));
                figures.add(figure);
            }
            this.saveFigures("replace-result.csv", figures);
        }
    }

}
