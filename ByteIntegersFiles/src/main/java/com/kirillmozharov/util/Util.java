package com.kirillmozharov.util;

import java.util.ArrayList;

public class Util {
    public static ArrayList<Integer> numberToDigitList(Integer number) {
        String n = Integer.toString(number);
        char[] charArray = n.toCharArray();
        ArrayList<Integer> cia = new ArrayList<Integer>();
        for (int i = 0; i < charArray.length; i++) {
            int c = Character.getNumericValue(charArray[i]);
            cia.add(c);
        }
        return cia;
    }
}
