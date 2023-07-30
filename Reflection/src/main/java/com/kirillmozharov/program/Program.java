package com.kirillmozharov.program;

import com.kirillmozharov.model.NumberCalculator;
import com.kirillmozharov.model.SumCalculator;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        NumberCalculator numberCalculator = new SumCalculator(8);
        numberCalculator.fill(2,3,5);
        System.out.println(numberCalculator.result());
        System.out.println(Arrays.toString(numberCalculator.getDataA()));
    }
}
