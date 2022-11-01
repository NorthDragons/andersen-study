package com.andersen.collection.arraylist;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.study.andersen.collection.arraylist.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 2, 3, 4, 5, 6, 7));
    int oldSize = arrayList.size();

    @Test
    public void addItemHaveToBeAddedToTheEndOfArraySizeIncrease() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        assertAll(
                () -> assertEquals(3, arrayList.size()),
                () -> assertEquals(1, arrayList.get(0)),
                () -> assertEquals(2, arrayList.get(1)),
                () -> assertEquals(3, arrayList.get(2))
        );
    }

    @Test
    public void addItemHaveToBeAddedAtIndexSizeIncrease() {
        int oldItem = arrayList.get(5);
        arrayList.add(5, 1);
        assertAll(
                () -> assertEquals(1, arrayList.get(5)),
                () -> assertEquals(oldItem, arrayList.get(6)),
                () -> assertEquals(oldSize + 1, arrayList.size())
        );
    }

    @Test
    public void addAllItemsHaveToBeAddedToTheEndOfArraySizeIncrease() {
        arrayList.addAll(Arrays.asList(3, 4, 5));
        assertAll(
                () -> assertEquals(5, arrayList.get(arrayList.size() - 1)),
                () -> assertEquals(4, arrayList.get(arrayList.size() - 2)),
                () -> assertEquals(3, arrayList.get(arrayList.size() - 3)),
                () -> assertEquals(oldSize + 3, arrayList.size())
        );
    }

    @Test
    public void addAllItemsHaveToBeAddedToIndexPlaceSizeIncrease() {
        int startIndex = 4;
        arrayList.addAll(startIndex, Arrays.asList(-4, -3, -2));
        assertAll(
                () -> assertEquals(-4, arrayList.get(startIndex)),
                () -> assertEquals(-3, arrayList.get(startIndex + 1)),
                () -> assertEquals(-2, arrayList.get(startIndex + 2)),
                () -> assertEquals(oldSize + 3, arrayList.size())
        );
    }

    @Test
    public void getReceiveSomeItemByIndex() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(7);
        Integer integer = arrayList.get(arrayList.size() - 1);
        assertEquals(7, integer);
    }

    @Test
    public void removeItemMustBeRemovedByIndexSizeShrink() {
        int removedElem = arrayList.get(6);
        int nextElem = arrayList.get(7);
        arrayList.remove(6);
        assertAll(
                () -> assertNotEquals(removedElem, arrayList.get(6)),
                () -> assertEquals(nextElem, arrayList.get(6)),
                () -> assertEquals(oldSize - 1, arrayList.size())
        );
    }

    @Test
    public void removeItemMustBeRemovedByValueSizeShrink() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.remove(Integer.valueOf(2));
        assertAll(
                () -> assertEquals( 2, arrayList.size()),
                () -> assertEquals(3, arrayList.get(0)),
                () -> assertEquals(2, arrayList.get(1))
        );
    }

}
