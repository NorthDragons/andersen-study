package com.study.andersen.collection.arraylist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
            OutOfMemoryError exception = new OutOfMemoryError(
                    "Required array length " + oldLength + " + " + minGrowth + " is too large");
            log.error("Exception: ",
                    exception);
            log.error("Exception: ", exception);
            throw exception;
        } else {
            return Math.max(minLength, MAX_LENGTH);
        }
    }
}
