package com.study.andersen.collection.linkedlist;

import java.util.List;

public class Test<E> {

    int size = 0;
    Node<E> first = null;
    Node<E> last = null;

    public void add(E element) {
        if (size != 0) {
            addLast(element);
        } else {
            addFirst(element);
        }
        size++;
    }

    public void add(int index, E element) {
        if (index == size) {
            addLast(element);
        } else {
            if (node(index) == null) {
                add(element);
            } else {
                addBefore(element, node(index));
            }
        }
        size++;
    }

    private void addBefore(E newElem, Node<E> beforeElem) {
        Node<E> prev = beforeElem.prev;
        prev.next = new Node<>(prev, newElem, beforeElem);
        size++;
    }

    public void addFirst(E element) {
        if (first != null) {
            Node<E> f = first;
            first = new Node<>(null, element, first.next);
        } else {
            first = new Node<>(null, element, null);
        }
        size++;
    }

    public void addLast(E element) {

        Node<E> l = last == null ? first : last;
        last = new Node<>(last, element, null);
        size++;
    }


    Node<E> node(int index) {
        Node<E> x;

        if (index < (size >> 1) && index > 1) {
            x = first;

            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

//    public void addAll(List<E> collection) {
//        addAll(size, collection);
//    }

//    public <T> void addAll(int index, List<T> c) {
//        checkPositionIndex(index);
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        if (numNew != 0) {
//            Node<E> pred, succ;
//            if (index == size) {
//                succ = null;
//                pred = last;
//            } else {
//                succ = node(index);
//                pred = succ.prev;
//            }
//            for (Object o : a) {
//                @SuppressWarnings("unchecked") E e = (E) o;
//                Node<E> newNode = new Node<>(pred, e, null);
//                if (pred == null) {
//                    first = newNode;
//                } else {
//                    pred.next = newNode;
//                }
//                pred = newNode;
//            }
//
//            if (succ == null) {
//                last = pred;
//            } else {
//                pred.next = succ;
//                succ.prev = pred;
//            }
//            size += numNew;
//        }
//    }

    public boolean contains(E obj) {
        return indexOf(obj) >= 0;
    }

    public E get(int i) {
        return node(i).item;
    }

    public E getLast() {
        return last.item;
    }

    public E getFirst() {
        return first.item;
    }

    public void remove() {
        removeFirst();
    }

    public void remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    remove(x);
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    remove(x);
                }
            }
        }
    }

    public void remove(int index) {
        Node<E> x = node(index);
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
    }

    public void removeFirst() {
        if (first != null) {
            if (first.next != null) {
                first = first.next;
                first.prev = null;
            } else {
                first = null;
            }
            size--;
        }
    }

    public void removeLast() {
        last = last.prev;
        last.next = null;
        size--;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private int outOfBoundsMsg(int index) {
        return size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
}
