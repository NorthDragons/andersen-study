package com.study.andersen.collection.arraylist;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;


public class ArrayList<E> implements Serializable {
    @Serial
    private static final long serialVersionUID = 8683452581122892189L;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;

    transient Object[] elementData;
    private int size;

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public ArrayList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == java.util.ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            elementData = EMPTY_ELEMENTDATA;
        }
    }


    public void add(E elem) {
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = elem;
        size += 1;
    }

    public void add(int index, E elem) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("indexOutOfBoundsException: size - " + size);
        }


    }

    public void addAll(Collection<? extends E> collection) {
        Object[] a = collection.toArray();
        int numNew = a.length;
        if (numNew != 0) {
            Object[] elementData;
            final int s;
            if (numNew > (elementData = this.elementData).length - (s = size)) {
                elementData = grow(s + numNew);
            }
            System.arraycopy(a, 0, elementData, s, numNew);
            size = s + numNew;
        }
    }

    public void addAll(int index, Collection<? extends E> collection) {
        Object[] objects = collection.toArray();
        int numNew = objects.length;
        if (numNew != 0) {
            Object[] elementData;
            final int s;
            if (numNew > (elementData = this.elementData).length - (s = size)) {
                elementData = grow(s + numNew);
            }
            int numMoved = s - index;
            if (numMoved > 0) {
                System.arraycopy(elementData, index,
                        elementData, index + numNew,
                        numMoved);
            }
            System.arraycopy(objects, 0, elementData, index, numNew);
            size = s + numNew;
        }
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity,
                    oldCapacity >> 1);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    public void remove(E element) {
        if (element == null) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    remover(i);
                    break;
                }
            }
        } else {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == element) {
                    remover(i);
                    break;
                }
            }
        }
    }

    private void remover(int index) {
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        }
        elementData[size = newSize] = null;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        remover(index);
    }

    public int size() {
        return size;
    }
}
