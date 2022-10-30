package com.study.andersen.collection.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class TreeMap<K, V> {
    private final Comparator<? super K> comparator;
    private int size = 0;

    private transient Entry<K, V> root;

    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public TreeMap() {
        this.comparator = null;
    }

    private static final boolean BLACK = true;
    private static final boolean RED = false;

    public int size() {
        return size;
    }

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

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return (entry == null ? null : entry.value);
    }

    public void remove(Object key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return;
        }
        V oldValue = entry.value;
        deleteEntry(entry);
    }

    public void put(K key, V value) {
        Entry<K, V> root1 = root;
        if (root != null) {
            int compareResult;
            Entry<K, V> parent;
            if (comparator != null) {
                do {
                    parent = root1;
                    compareResult = comparator.compare(key, parent.key);
                    if (compareResult < 0) {
                        root1 = parent.left;
                    } else if (compareResult > 0) {
                        root1 = parent.right;
                    } else {
                        root.value = value;
                        return;
                    }
                } while (root1 != null);
            } else {
                Objects.requireNonNull(key);
                @SuppressWarnings("unchecked")
                Comparable<? super K> comparableKey = (Comparable<? super K>) key;
                do {
                    parent = root1;
                    compareResult = comparableKey.compareTo(parent.key);
                    if (compareResult < 0) {
                        root1 = parent.left;

                    } else if (compareResult > 0) {
                        root1 = parent.right;
                    } else {
                        root.value = value;
                        return;
                    }
                } while (root1 != null);
            }
            addEntry(key, value, parent, compareResult < 0);
        } else {
            addEntryToEmptyMap(key, value);
        }
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

    private void addEntryToEmptyMap(K key, V value) {
        compare(key, key);
        root = new Entry<>(key, value, null);
        size = 1;
    }

    @SuppressWarnings("unchecked")
    final int compare(Object key1, Object key2) {
        return comparator == null ? ((Comparable<? super K>) key1).compareTo((K) key2)
                : comparator.compare((K) key1, (K) key2);
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
            Entry<K, V> rightEntry = entry.right;
            entry.right = rightEntry.left;
            if (rightEntry.left != null) {
                rightEntry.left.parent = entry;
            }
            rightEntry.parent = entry.parent;
            if (entry.parent == null) {
                root = rightEntry;
            } else if (entry.parent.left == entry) {
                entry.parent.left = rightEntry;
            } else {
                entry.parent.right = rightEntry;
            }
            rightEntry.left = entry;
            entry.parent = rightEntry;
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

    static <K, V> Entry<K, V> successor(Entry<K, V> newEntry) {
        if (newEntry == null) {
            return null;
        } else if (newEntry.right != null) {
            Entry<K, V> right = newEntry.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            Entry<K, V> parent = newEntry.parent;
            Entry<K, V> entry1 = newEntry;
            while (parent != null && entry1 == parent.right) {
                newEntry = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private void deleteEntry(Entry<K, V> entry) {
        size--;
        if (entry.left != null && entry.right != null) {
            Entry<K, V> succEntry = successor(entry);
            entry.key = succEntry.key;
            entry.value = succEntry.value;
            entry = succEntry;
        }

        Entry<K, V> replacement = (entry.left != null ? entry.left : entry.right);

        if (replacement != null) {
            replacement.parent = entry.parent;
            if (entry.parent == null) {
                root = replacement;
            } else if (entry == entry.parent.left) {
                entry.parent.left = replacement;
            } else {
                entry.parent.right = replacement;
            }
            entry.left = entry.right = entry.parent = null;
            if (entry.color == BLACK) {
                fixAfterDeletion(replacement);
            }
        } else if (entry.parent == null) {
            root = null;
        } else {
            if (entry.color == BLACK) {
                fixAfterDeletion(entry);
            }

            if (entry.parent != null) {
                if (entry == entry.parent.left) {
                    entry.parent.left = null;
                } else if (entry == entry.parent.right) {
                    entry.parent.right = null;
                }
                entry.parent = null;
            }
        }
    }

    private void fixAfterDeletion(Entry<K, V> deletedEntry) {
        while (deletedEntry != root && colorOf(deletedEntry) == BLACK) {
            if (deletedEntry == leftOf(parentOf(deletedEntry))) {
                Entry<K, V> rightOfParent = rightOf(parentOf(deletedEntry));

                if (colorOf(rightOfParent) == RED) {
                    setColor(rightOfParent, BLACK);
                    setColor(parentOf(deletedEntry), RED);
                    rotateLeft(parentOf(deletedEntry));
                    rightOfParent = rightOf(parentOf(deletedEntry));
                }

                if (colorOf(leftOf(rightOfParent)) == BLACK &&
                        colorOf(rightOf(rightOfParent)) == BLACK) {
                    setColor(rightOfParent, RED);
                    deletedEntry = parentOf(deletedEntry);
                } else {
                    if (colorOf(rightOf(rightOfParent)) == BLACK) {
                        setColor(leftOf(rightOfParent), BLACK);
                        setColor(rightOfParent, RED);
                        rotateRight(rightOfParent);
                        rightOfParent = rightOf(parentOf(deletedEntry));
                    }
                    setColor(rightOfParent, colorOf(parentOf(deletedEntry)));
                    setColor(parentOf(deletedEntry), BLACK);
                    setColor(rightOf(rightOfParent), BLACK);
                    rotateLeft(parentOf(deletedEntry));
                    deletedEntry = root;
                }
            } else {
                Entry<K, V> leftOfParent = leftOf(parentOf(deletedEntry));

                if (colorOf(leftOfParent) == RED) {
                    setColor(leftOfParent, BLACK);
                    setColor(parentOf(deletedEntry), RED);
                    rotateRight(parentOf(deletedEntry));
                    leftOfParent = leftOf(parentOf(deletedEntry));
                }

                if (colorOf(rightOf(leftOfParent)) == BLACK &&
                        colorOf(leftOf(leftOfParent)) == BLACK) {
                    setColor(leftOfParent, RED);
                    deletedEntry = parentOf(deletedEntry);
                } else {
                    if (colorOf(leftOf(leftOfParent)) == BLACK) {
                        setColor(rightOf(leftOfParent), BLACK);
                        setColor(leftOfParent, RED);
                        rotateLeft(leftOfParent);
                        leftOfParent = leftOf(parentOf(deletedEntry));
                    }
                    setColor(leftOfParent, colorOf(parentOf(deletedEntry)));
                    setColor(parentOf(deletedEntry), BLACK);
                    setColor(leftOf(leftOfParent), BLACK);
                    rotateRight(parentOf(deletedEntry));
                    deletedEntry = root;
                }
            }
        }

        setColor(deletedEntry, BLACK);
    }

    final Entry<K, V> getEntry(Object key) {
        if (comparator != null) {
            return getEntryUsingComparator(key);
        }
        Objects.requireNonNull(key);
        @SuppressWarnings("unchecked")
        Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K, V> root = this.root;
        while (root != null) {
            int compareResult = k.compareTo(root.key);
            if (compareResult < 0) {
                root = root.left;
            } else if (compareResult > 0) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    final Entry<K, V> getEntryUsingComparator(Object key) {
        @SuppressWarnings("unchecked")
        K k = (K) key;
        Comparator<? super K> comparator = this.comparator;
        if (comparator != null) {
            Entry<K, V> root = this.root;
            while (root != null) {
                int compareResult = comparator.compare(k, root.key);
                if (compareResult < 0) {
                    root = root.left;
                } else if (compareResult > 0) {
                    root = root.right;
                } else {
                    return root;
                }
            }
        }
        return null;
    }

}