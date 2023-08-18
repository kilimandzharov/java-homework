package com.kirillmozharov.program;

import com.kirillmozharov.model.NumberCalculator;
import com.kirillmozharov.model.SumCalculator;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        NumberCalculator numberCalculator = new SumCalculator(3);
        numberCalculator.fill(2,3,5);
        System.out.println(numberCalculator.getObject());
        for (int[] ints : numberCalculator.invokeGetMass()) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
