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
        Entry<K, V> p = getEntry(key);
        return (p == null ? null : p.value);
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
        Entry<K, V> parent = root;
        if (parent == null) {
            addEntryToEmptyMap(key, value);
            return;
        }
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

    private void addEntryToEmptyMap(K key, V value) {
        compare(key, key);
        root = new Entry<>(key, value, null);
        size = 1;
    }

    @SuppressWarnings("unchecked")
    final int compare(Object k1, Object k2) {
        return comparator == null ? ((Comparable<? super K>) k1).compareTo((K) k2)
                : comparator.compare((K) k1, (K) k2);
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

    static <K, V> Entry<K, V> successor(Entry<K, V> entry) {
        if (entry == null) {
            return null;
        } else if (entry.right != null) {
            Entry<K, V> right = entry.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            Entry<K, V> parent = entry.parent;
            Entry<K, V> ch = entry;
            while (parent != null && ch == parent.right) {
                ch = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private void deleteEntry(Entry<K, V> entry) {
        size--;
        if (entry.left != null && entry.right != null) {
            Entry<K, V> s = successor(entry);
            entry.key = s.key;
            entry.value = s.value;
            entry = s;
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

    private void fixAfterDeletion(Entry<K, V> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Entry<K, V> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib)) == BLACK &&
                        colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else {
                Entry<K, V> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                        colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    final Entry<K, V> getEntry(Object key) {
        if (comparator != null) {
            return getEntryUsingComparator(key);
        }
        Objects.requireNonNull(key);
        @SuppressWarnings("unchecked")
        Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K, V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    final Entry<K, V> getEntryUsingComparator(Object key) {
        @SuppressWarnings("unchecked")
        K k = (K) key;
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            Entry<K, V> p = root;
            while (p != null) {
                int cmp = cpr.compare(k, p.key);
                if (cmp < 0) {
                    p = p.left;
                } else if (cmp > 0) {
                    p = p.right;
                } else {
                    return p;
                }
            }
        }
        return null;
    }

}