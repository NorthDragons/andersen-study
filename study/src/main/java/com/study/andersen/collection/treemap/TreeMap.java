package com.study.andersen.collection.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class TreeMap<K, V> {
    private final Comparator<? super K> comparator;
    private int size = 0;

    private Entry<K, V> root;

    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public TreeMap() {
        this.comparator = null;
    }

    public TreeMap(Map<? extends K, ? extends V> m) {
        comparator = null;
        putAll(m);
    }

    private void putAll(Map<? extends K, ? extends V> m) {

    }

    private static final boolean BLACK = true;
    private static final boolean RED = false;

    static final class Entry<K, V> implements Map.Entry<K, V> {

        K key;
        V value;
        Entry<K, V> parent;
        Entry<K, V> left;
        Entry<K, V> right;

        private boolean color = BLACK;

        public Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }
    }

    public void put(K key, V value) {
        Entry<K, V> parent = root;
        int compareResult;
        if (comparator != null) {
            do {
                compareResult = comparator.compare(key, parent.key);
                if (compareResult < 0) {
                    parent = parent.left;
                } else if (compareResult > 0) {
                    parent = parent.right;
                } else {
                    root.value = value;
                    return;
                }
            } while (parent != null);
        } else {
            Objects.requireNonNull(key);
            @SuppressWarnings("unchecked")
            Comparable<? super K> comparableKey = (Comparable<? super K>) key;
            do {
                compareResult = comparableKey.compareTo(parent.key);
                if (compareResult < 0) {
                    parent = parent.left;

                } else if (compareResult > 0) {
                    parent = parent.right;
                } else {
                    root.value = value;
                    return;
                }
            } while (parent != null);
        }
        addEntry(key, value, parent, compareResult < 0);
    }

    private void addEntry(K key, V value, Entry<K, V> parent, boolean addToLeft) {
        Entry<K, V> entry = new Entry<>(key, value, parent);
        if (addToLeft) {
            parent.left = entry;
        } else {
            parent.right = entry;
        }
        fixAfterInsertion(entry);
        size++;
    }

    private void fixAfterInsertion(Entry<K, V> entry) {
        entry.color = RED;

        while (entry != null && entry != root && entry.parent.color == RED) {

            if (parentOf(entry) == leftOf(parentOf(parentOf(entry)))) {

                Entry<K, V> rightOfParent = rightOf(parentOf(parentOf(entry)));

                if (colorOf(rightOfParent) == RED) {
                    setColor(parentOf(entry), BLACK);

                    setColor(rightOfParent, BLACK);

                    setColor(parentOf(parentOf(entry)), RED);

                    entry = parentOf(parentOf(entry));

                } else {
                    if (entry == rightOf(parentOf(entry))) {
                        entry = parentOf(entry);
                        rotateLeft(entry);
                    }
                    setColor(parentOf(entry), BLACK);
                    setColor(parentOf(parentOf(entry)), RED);
                    rotateRight(parentOf(parentOf(entry)));
                }
            } else {
                Entry<K, V> leftOfParent = leftOf(parentOf(parentOf(entry)));

                if (colorOf(leftOfParent) == RED) {
                    setColor(parentOf(entry), BLACK);
                    setColor(leftOfParent, BLACK);
                    setColor(parentOf(parentOf(entry)), RED);
                    entry = parentOf(parentOf(entry));
                } else {
                    if (entry == leftOf(parentOf(entry))) {
                        entry = parentOf(entry);

                        rotateRight(entry);
                    }
                    setColor(parentOf(entry), BLACK);
                    setColor(parentOf(parentOf(entry)), RED);
                    rotateLeft(parentOf(parentOf(entry)));
                }
            }
        }
        root.color = BLACK;
    }

    private static <K, V> Entry<K, V> parentOf(Entry<K, V> entry) {
        return (entry == null ? null : entry.parent);
    }

    private static <K, V> boolean colorOf(Entry<K, V> entry) {
        return (entry == null ? BLACK : entry.color);
    }

    private static <K, V> Entry<K, V> leftOf(Entry<K, V> entry) {
        return (entry == null) ? null : entry.left;
    }

    private static <K, V> Entry<K, V> rightOf(Entry<K, V> entry) {
        return (entry == null) ? null : entry.right;
    }

    private static <K, V> void setColor(Entry<K, V> entry, boolean color) {
        if (entry != null) {
            entry.color = color;
        }
    }

    private void rotateLeft(Entry<K, V> entry) {
        if (entry != null) {
            Entry<K, V> r = entry.right;
            entry.right = r.left;
            if (r.left != null) {
                r.left.parent = entry;
            }
            r.parent = entry.parent;
            if (entry.parent == null) {
                root = r;
            } else if (entry.parent.left == entry) {
                entry.parent.left = r;
            } else {
                entry.parent.right = r;
            }
            r.left = entry;
            entry.parent = r;
        }
    }

    private void rotateRight(Entry<K, V> entry) {
        if (entry != null) {

            Entry<K, V> leftEntry = entry.left;

            entry.left = leftEntry.right;

            if (leftEntry.right != null) {
                leftEntry.right.parent = entry;
            }

            leftEntry.parent = entry.parent;
            if (entry.parent == null) {
                root = leftEntry;
            } else if (entry.parent.right == entry) {
                entry.parent.right = leftEntry;
            } else {
                entry.parent.left = leftEntry;
            }
            leftEntry.right = entry;
            entry.parent = leftEntry;
        }
    }


}