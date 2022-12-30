package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V>  implements Map61B<K, V> {

    private int size;
    private Node root;

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return find(key) != null;
    }

    @Override
    public V get(K key) {

        Node p = find(key);
        if (p != null) {
            return p.value;
        }
        return null;
    }

    private Node find(K key) {
        Node p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size ++;
        } else {
            Node p = root;
            Node parent = p;
            int cmp = 0;
            while (p != null) {
                parent = p;
                cmp = key.compareTo(p.key);
                if (cmp < 0)
                    p = p.left;
                else if (cmp > 0)
                    p = p.right;
                else {
                    p.value = value;
                    return;
                }
                
            }

            Node node = new Node(key, value);
            size ++;
            if (cmp < 0) {
                parent.left = node;
            } else if (cmp > 0) {
                parent.right = node;
            }

        }
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node {
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K key;
        public V value;
        public Node left;
        public Node right;
    }
}
