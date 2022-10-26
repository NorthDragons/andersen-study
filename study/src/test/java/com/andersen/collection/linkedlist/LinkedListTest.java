package com.andersen.collection.linkedlist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.study.andersen.collection.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

public class LinkedListTest1 {
    @Test
    public void add() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.add(integers[0]);
        list.add(integers[1]);
        list.add(integers[2]);
        assertAll(
                () -> assertNotNull(list.get(0)),
                () -> assertEquals(list.size(), 3)
        );
    }

    @Test
    public void addFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.addFirst(integers[0]);
        list.addFirst(integers[1]);
        list.addFirst(integers[2]);
        assertAll(
                () -> assertNotNull(list.get(0)),
                () -> assertEquals(list.get(0), integers[2]),
                () -> assertEquals(list.get(1), integers[1]),
                () -> assertEquals(list.get(2), integers[0])
        );
    }

    @Test
    public void addLast() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.addLast(integers[0]);
        list.addLast(integers[1]);
        list.addLast(integers[2]);
        assertAll(
                () -> assertNotNull(list.get(0)),
                () -> assertEquals(list.get(0), integers[0]),
                () -> assertEquals(list.get(1), integers[1]),
                () -> assertEquals(list.get(2), integers[2])
        );
    }

    @Test
    public void get() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.addFirst(integers[0]);
        list.addFirst(integers[1]);
        list.addFirst(integers[2]);
        assertAll(
                () -> assertNotNull(list.get(integers[2])),
                () -> assertEquals(list.getFirst(), integers[2]),
                () -> assertEquals(list.get(1), integers[1]),
                () -> assertEquals(list.getLast(), integers[0])
        );
    }

    @Test
    public void remove() {

    }
}
