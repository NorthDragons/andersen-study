package com.andersen.collection.linkedlist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.study.andersen.collection.linkedlist.LinkedList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @Test
    public void addItemMustBeAddedAsLastItemSizeIncrease() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.add(integers[2]);
        assertAll(
                () -> assertEquals(1, list.size()),
                () -> assertEquals(integers[2], list.get(1))
        );
    }

    @Test
    public void addFirstItemMustBeAddedAsFirstElementSizeIncrease() {
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
    public void addLastItemMustBeAddedAsLastItemSizeIncrease() {
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
    public void getItemMustBeReceivedByIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.add(integers[0]);
        list.add(integers[1]);
        list.add(integers[2]);
        assertAll(
                () -> assertNotNull(list.get(2)),
                () -> assertEquals(integers[0], list.get(0))
        );
    }

    @Test
    public void getFirstReceivedFirstElement() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.add(integers[0]);
        list.add(integers[1]);
        list.addFirst(integers[2]);
        assertEquals(integers[2], list.getFirst());
    }

    @Test
    public void getLastReceivedLastElement() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        list.add(integers[1]);
        list.add(integers[2]);
        list.addLast(integers[0]);
        assertEquals(integers[0], list.getLast());
    }

    @Test
    public void removeRemovedLastElementSizeDecreased() {
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(integers));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int size = list.size();
        int lastElem = list.getLast();
        list.removeLast();
        assertAll(
                () -> assertEquals(size - 1, list.size()),
                () -> assertNotEquals(lastElem, list.getLast())
        );
    }

    @Test
    public void removeRemovedItemByIndexSizeDecrease() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        int size = list.size();
        int index = 1;
        int removedElem = list.get(index);
        list.remove(index);
        assertAll(
                () -> assertEquals(size - 1, list.size()),
                () -> assertNotEquals(removedElem, list.get(index))

        );
    }

    @Test
    public void removeRemovedByValueSizeDecrease() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2));
        assertEquals(2, list.size());
        assertEquals(3, list.get(1));
    }

    @Test
    public void removeFirstRemovedFirstElementSizeDecrease() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(22);
        list.add(12);
        list.removeFirst();
        assertEquals(3,list.size());
    }

    @Test
    public void removeLastRemovedLastElementSizeDecrease() {
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(integers));
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeLast();
        assertEquals(2, list.size());
    }
}
