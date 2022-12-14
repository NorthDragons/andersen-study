package com.andersen.collection.treemap;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.study.andersen.collection.treemap.TreeMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TreeMapTest {
    @Test
    public void putPutElementByKeySizeIncrease() {
        java.util.TreeMap<Integer,Integer> m1ap=new java.util.TreeMap<>();
        m1ap.put(1,1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(3, 1);
        map.put(2, 1);
        map.put(5, 1);
        assertAll(
                () -> assertEquals(4, map.size()),
                () -> assertEquals(1, map.get(1))
        );
    }

    @Test
    public void getReceivedElementByKey() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.get(1);
        assertEquals(1, map.get(1));
    }

    @Test
    public void removeRemoveElementByKeySizeDecrease() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(2, 11);
        map.put(3, 11);
        map.remove(1);
        assertEquals(2, map.size());
    }
}
