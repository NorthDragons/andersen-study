package com.study.andersen.collection.arraylist;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
            IllegalArgumentException exception = new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
            log.error("Exception: ",
                    exception);
            throw exception;
        }
    }

    public ArrayList(Collection<? extends E> c) {
        Object[] array = c.toArray();
        if ((size = array.length) != 0) {
            if (c.getClass() == java.util.ArrayList.class) {
                elementData = array;
            } else {
                elementData = Arrays.copyOf(array, size, Object[].class);
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
            IndexOutOfBoundsException exception =
                    new IndexOutOfBoundsException("indexOutOfBoundsException: size - " + size);
            log.error("Exception: ",
                    exception);
            throw exception;
        }
        final int size;
        Object[] elementData;
        if ((size = this.size) == (elementData = this.elementData).length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index,
                elementData, index + 1,
                size - index);
        elementData[index] = elem;
        this.size = size + 1;
    }

    public void addAll(Collection<? extends E> collection) {
        Object[] array = collection.toArray();
        int numNew = array.length;
        if (numNew != 0) {
            Object[] elementData;
            final int size;
            if (numNew > (elementData = this.elementData).length - (size = this.size)) {
                elementData = grow(size + numNew);
            }
            System.arraycopy(array, 0, elementData, size, numNew);
            this.size = size + numNew;
        }
    }

    public void addAll(int index, Collection<? extends E> collection) {
        Object[] objects = collection.toArray();
        int numNew = objects.length;
        if (numNew != 0) {
            Object[] elementData;
            final int size;
            if (numNew > (elementData = this.elementData).length - (size = this.size)) {
                elementData = grow(size + numNew);
            }
            int numMoved = size - index;
            if (numMoved > 0) {
                System.arraycopy(elementData, index,
                        elementData, index + numNew,
                        numMoved);
            }
            System.arraycopy(objects, 0, elementData, index, numNew);
            this.size = size + numNew;
        }
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    @SuppressWarnings("unchecked")
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
            for (int index = 0; index < elementData.length; index++) {
                if (elementData[index] == null) {
                    remover(index);
                    break;
                }
            }
        } else {
            for (int index = 0; index < elementData.length; index++) {
                if (elementData[index] == element) {
                    remover(index);
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
