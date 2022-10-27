package com.andersen.collection.arraylist;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.study.andersen.collection.arraylist.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ArrayListTest {


    @Test
    public void add() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0, 1);
        arrayList.add(2);
        arrayList.addAll(Arrays.asList(3, 4, 5));
        arrayList.addAll(0, Arrays.asList(-4, -3, -2, -1, 0));
        System.out.println(arrayList);
    }

    @Test
    public void get() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Integer integer = arrayList.get(arrayList.size() - 1);
        System.out.println(integer);
    }

    @Test
    public void remove() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 2, 3, 4, 5, 6, 7));
        int startSize = arrayList.size();
        assertEquals(4, arrayList.get(6));
        arrayList.remove(6);
        assertNotEquals(4, arrayList.get(6));
        assertEquals(5, arrayList.get(6));
        assertEquals(startSize - 1, arrayList.size());
    }

    @Test
    public void removeObject() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 2, 3, null));
        int size = arrayList.size();
        arrayList.remove(Integer.valueOf(2));
        assertEquals(size - 1, arrayList.size());
        arrayList.remove(null);
        assertEquals(size - 2, arrayList.size());
    }

}
