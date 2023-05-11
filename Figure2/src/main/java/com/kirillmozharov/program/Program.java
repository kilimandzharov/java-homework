package com.kirillmozharov.program;

import com.kirillmozharov.model.*;
import com.kirillmozharov.repository.FigureRepository;


//TODO Убрать фабрикии / методы в репозитории сделать статическими
public class Program {
    public static void main(String[] args) {
      /*  Rectangle rectangle = new Rectangle(1, 2);
        Calculator calculator1 = new Calculator(rectangle);

        Triangle triangle = new Triangle(3, 4, 5);
        Calculator calculator2 = new Calculator(triangle);

        System.out.println(calculator1.calculate(Functor.PERIMETER));
        System.out.println(calculator1.calculate(Functor.SQUARE));

        System.out.println(calculator2.calculate(Functor.PERIMETER));
        System.out.println(calculator2.calculate(Functor.SQUARE));

        var figure = new Figure() {
            private double r;

            public double getR() {
                return r;
            }

            public void setR(double r) {
                this.r = r;
            }

            @Override
            public double square() {
                return Math.PI * Math.pow(this.r, 2);
            }

            @Override
            public double perimeter() {
                return 2 * Math.PI * this.r;
            }

            @Override
            public String getName() {
                return "Circle";
            }

            @Override
            public String toCsv() {
                return null;
            }
        };
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        figure.setR(radius);
        Calculator calculator3 = new Calculator(figure);
        System.out.println(calculator3.calculate(Functor.SQUARE));
        System.out.println(calculator3.calculate(Functor.PERIMETER));*/
        Rectangle rectangle = new Rectangle(1, 2);
        FigureRepository figureRepository = new FigureRepository();
        figureRepository.replaceFigures("replace.csv", rectangle, new Triangle(10, 10, 15));
    }
}
