package com.study.andersen.algoritm;

import static com.study.andersen.algoritm.QuickSort.quickSort;

import java.util.Arrays;

public class Sorter {
    public static void main(String[] args) {
        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: \n" + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (int index = 1; index < array.length; index++) {
                if (array[index] < array[index - 1]) {
                    swap(array, index - 1, index);
                    repeat = true;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {

        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int index = left; index < array.length; index++) {
                if (array[index] > array[minInd]) {
                    minInd = index;
                }
            }
            swap(array, left, minInd);
        }
    }

    public static void insertionSort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int index = left - 1;
            for (; index >= 0; index--) {
                if (value < array[index]) {
                    array[index + 1] = array[index];
                } else {
                    break;
                }
            }
            array[index + 1] = value;
        }
    }

    public static void swap(int[] array, int left, int minIndex) {
        int tmp = array[left];
        array[left] = array[minIndex];
        array[minIndex] = tmp;
    }
}
