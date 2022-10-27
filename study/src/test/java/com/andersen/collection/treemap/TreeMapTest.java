package com.andersen.collection.treemap;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;

public class TreeMapTest {
    @Test
    public void test() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        System.out.println(map.size());
        map.descendingMap();

    }
}
