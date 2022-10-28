package com.study.andersen.collection.linkedlist;

import java.util.List;

public class LinkedList<E> {

    int size = 0;
    Node<E> first = null;
    Node<E> last = null;

    public LinkedList(List<E> asList) {

    }

    public LinkedList() {
    }

    public void add(E element) {
        if (size != 0) {
            addLast(element);
        } else {
            addFirst(element);
        }

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
    }

    private void addBefore(E newElem, Node<E> beforeElem) {
        Node<E> prev = beforeElem.prev;
        prev.next = new Node<>(prev, newElem, beforeElem);
        size++;
    }

    public void addFirst(E element) {
        if (first != null) {
            Node<E> f = first;
            first = new Node<>(null, element, f);
            f.prev = first;
            if (last == null) {
                last = f;
            }
        } else {
            first = new Node<>(null, element, null);
        }
        size++;
    }

    public void addLast(E element) {
        if (last == null && first == null) {
            addFirst(element);
        } else {
            Node<E> l;
            if (last == null) {
                l = first;
            } else {
                l = last;
            }
            last = new Node<>(l, element, null);
            l.next = last;
            size++;
        }

    }


    Node<E> node(int index) {
        Node<E> x;

        if (index < (size >> 1)) {
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

    public boolean contains(E obj) {
        return indexOf(obj) >= 0;
    }

    public E get(int i) {
        if (!isPositionIndex(i)) {
            throw new IndexOutOfBoundsException("exx");
        }
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

    public void remove(int index) {
        remove(node(index));
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

    public void remove(Node<E> node) {
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
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
