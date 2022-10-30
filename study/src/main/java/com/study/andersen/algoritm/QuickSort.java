package com.study.andersen.algoritm;

import static com.study.andersen.algoritm.Sorter.swap;

public class QuickSort {
    static int getPivotIndex(int[] array, int startIndex, int endIndex) {
        int pivot = (startIndex - 1);
        for (int j = startIndex; j <= endIndex - 1; j++) {

            if (array[j] < array[endIndex]) {
                pivot++;
                swap(array, pivot, j);
            }
        }
        swap(array, pivot + 1, endIndex);
        return (pivot + 1);
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = getPivotIndex(array, startIndex, endIndex);
            quickSort(array, startIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, endIndex);
        }
    }
}
