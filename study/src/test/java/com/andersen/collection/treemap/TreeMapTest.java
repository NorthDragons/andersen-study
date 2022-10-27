package com.andersen.collection.treemap;


import com.study.andersen.collection.treemap.TreeMap;
import org.junit.jupiter.api.Test;

public class TreeMapTest {
    @Test
    public void test() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        System.out.println(map.size());
        Integer integer = map.get(1);
        System.out.println(integer);
    }
}
