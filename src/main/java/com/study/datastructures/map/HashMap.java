package com.study.datastructures.map;

import com.study.datastructures.list.ArrayList;
import com.study.datastructures.list.List;

import java.util.Objects;

public class HashMap implements Map {
    private static final int DEFAULT_CAPACITY = 5;
    private List[] buckets;
    private int size;


    public HashMap() {
        buckets = new ArrayList[DEFAULT_CAPACITY];

    }

    @Override
    public Object put(Object key, Object value) {
        Entry entry = new Entry(key, value);
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList();
            buckets[bucketIndex].add(entry);
            size++;
        } else if (buckets[bucketIndex].contains(entry)) {
            int index = buckets[bucketIndex].indexOf(entry);
            Entry oldValue = (Entry) buckets[bucketIndex].get(index);
            buckets[bucketIndex].set(entry, index);
            return oldValue.value;
        } else {
            buckets[bucketIndex].add(entry);
            size++;
        }
        return null;
    }

    @Override
    public Object get(Object key) {
        Entry entry = new Entry(key);
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] != null) {
            int index = buckets[bucketIndex].indexOf(entry);
            Entry newEntry = (Entry) buckets[bucketIndex].get(index);
            return newEntry.value;
        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(Object key) {
        Entry entry = new Entry(key);
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] != null) {
            return buckets[bucketIndex].contains(entry);

        }
        return false;
    }

    @Override
    public Object remove(Object key) {
        Entry entry = new Entry(key);
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] != null) {
            int index = buckets[bucketIndex].indexOf(entry);
            if (index > -1) {
                size--;
                Entry oldEntry = (Entry) buckets[bucketIndex].get(index);
                buckets[bucketIndex].remove(index);
               return oldEntry.value;

            }

        }
        return null;
    }

    private int getBucketIndex(Entry entry) {
        int hash = entry.hashCode();
        return Math.abs(hash) % DEFAULT_CAPACITY;
    }

    private static class Entry {
        Object key;
        Object value;

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    
        private Entry(Object key) {
            this.key = key;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }


}
