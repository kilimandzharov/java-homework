package com.kirillmozharov.util;

import java.util.Arrays;
import java.util.HashSet;

public class Util {
    public static int getDifferentNumbers(Integer[] arr){
        HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(arr));
        return hashSet.size();
    }
}
