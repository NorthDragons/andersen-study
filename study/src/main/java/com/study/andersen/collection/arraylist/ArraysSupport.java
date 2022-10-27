package com.study.andersen.collection.arraylist;

public class ArraysSupport {
    public static final int MAX_LENGTH = Integer.MAX_VALUE - 8;
    public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int prefLength = oldLength + Math.max(minGrowth, prefGrowth);
        if (0 < prefLength && prefLength <= MAX_LENGTH) {
            return prefLength;
        } else {
            return hugeLength(oldLength, minGrowth);
        }
    }
    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) {
            throw new OutOfMemoryError(
                    "Required array length " + oldLength + " + " + minGrowth + " is too large");
        } else return Math.max(minLength, MAX_LENGTH);
    }
}
