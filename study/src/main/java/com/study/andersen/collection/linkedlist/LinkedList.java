package com.study.andersen.collection.linkedlist;

import java.util.List;
import java.util.Objects;

public class LinkedList<E> {

    int size = 0;
    Node<E> first = null;
    Node<E> last = null;

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
            Node<E> nextItem = first;
            first = new Node<>(null, element, nextItem);
            nextItem.prev = first;
            if (last == null) {
                last = nextItem;
            }
        } else {
            first = new Node<>(null, element, null);
            if (last == null) {
                last = first;
            }
        }
        size++;
    }

    public void addLast(E element) {
        if (last == null && first == null) {
            addFirst(element);
        } else {
            Node<E> previous;
            previous = Objects.requireNonNullElseGet(this.last, () -> first);
            this.last = new Node<>(previous, element, null);
            previous.next = this.last;
            size++;
        }

    }


    Node<E> node(int index) {
        Node<E> node;

        if (index < (size >> 1)) {
            node = first;

            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    public E get(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("exx");
        }
        return node(index).item;
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

    public void remove(Object item) {
        if (item == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    remove(x);
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (item.equals(node.item)) {
                    remove(node);
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

    public int indexOf(Object item) {
        int index = 0;
        if (item == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (item.equals(node.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
}
