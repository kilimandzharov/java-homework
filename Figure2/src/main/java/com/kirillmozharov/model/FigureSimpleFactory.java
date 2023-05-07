package com.kirillmozharov.model;

import java.util.Objects;

public class FigureSimpleFactory {
    public static Figure getInstance(String className, String... args) {
        if (className.equals("Triangle")) {
            return new Triangle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else if (className.equals("Rectangle")) {
            return new Rectangle(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        return null;
    }

}
