package com.kirillmozharov.model;

public class Integral {
    public static double EPS = 0.05;

    public static double integralRectangle(Function function, double a, double b, double n) {
        double s = 0;
        double d = (b - a) / n;
        double xb = 0;

        for (int i = 0; i < n; i++) {
            double xe = xb + d;
            double xm = (xb + xe) / 2;
            s += d * function.f(xm);
            xb = xe;
        }
        return s;
    }

    public static double integralRectangleWithEPS(Function function, double a, double b) {
        int tempN = 1;
        double resultN = integralRectangle(function, a, b, tempN);
        double result2N = integralRectangle(function, a, b, 2 * tempN);
        while (Math.abs(result2N - resultN) / 3 > EPS) {
            tempN = 2 * tempN;
            resultN = integralRectangle(function, a, b, tempN);
            result2N = integralRectangle(function, a, b, 2 * tempN);
        }
        return resultN;
    }
}
