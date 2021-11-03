package com.study.datastructures.map;

import com.study.datastructures.list.ArrayList;

import java.util.Objects;

public class HashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_CAPACITY = 5;

    private ArrayList<Entry<K, V>>[] buckets;
    private int size;

    public HashMap() {
        buckets = new ArrayList[DEFAULT_CAPACITY];
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = new Entry(key, value, null);
        if (size > buckets.length * 0.75) {
            buckets = resizeBuckets(buckets);
        }
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList<>();
            buckets[bucketIndex].add(entry);
            size++;
        } else {
            int index = buckets[bucketIndex].indexOf(entry);
            if (index > -1) {
                Entry<K, V> oldValue = buckets[bucketIndex].get(index);
                buckets[bucketIndex].set(entry, index);
                return oldValue.value;
            } else {
                if(buckets[bucketIndex].size()>0)
                {
                    Entry prevEntry = buckets[bucketIndex].get(buckets[bucketIndex].size() - 1);
                    prevEntry.next = entry;
                }
                buckets[bucketIndex].add(entry);

                size++;
            }
        }
        return null;
    }

    private ArrayList<Entry<K, V>>[] resizeBuckets(ArrayList<Entry<K, V>>[] buckets) {
        int newCapacity = buckets.length * 2;
        ArrayList<Entry<K, V>>[] newBuckets = new ArrayList[newCapacity];

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    int newBucketIndex = getBucketIndex(buckets[i].get(j));
                    if (newBuckets[newBucketIndex] == null) {
                        newBuckets[newBucketIndex] = new ArrayList<>();
                        newBuckets[newBucketIndex].add(buckets[i].get(j));
                    }else {
                        int index = newBuckets[newBucketIndex].indexOf(buckets[i].get(j));
                        if (index > -1) {
                            newBuckets[newBucketIndex].set(buckets[i].get(j), index);
                        } else {
                            newBuckets[newBucketIndex].add(buckets[i].get(j));
                        }
                    }
                }
            }
        }
        return newBuckets;
    }

    @Override
    public V get(K key) {

        Entry<K, V> entry = new Entry<>(key);
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] != null) {
            int index = buckets[bucketIndex].indexOf(entry);
            Entry<K, V> newEntry = buckets[bucketIndex].get(index);
            return newEntry.value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        Entry<K, V> entry = new Entry<>(key);
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] != null) {
            return buckets[bucketIndex].contains(entry);
        }
        return false;
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entry = new Entry<>(key);
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] != null) {
            int index = buckets[bucketIndex].indexOf(entry);
            if (index > -1) {
                size--;
                Entry<K, V> oldEntry = buckets[bucketIndex].get(index);
                buckets[bucketIndex].remove(index);
                return oldEntry.value;
            }
        }
        return null;
    }

    private int getBucketIndex(Entry<K, V> entry) {

        return Math.abs((entry.hash) % buckets.length);
    }


    private static class Entry<K, V> {
        private K key;
        private V value;
        private int hash;
        private Entry next;

        private Entry(K key, V value, Entry entry) {
            this.key = key;
            this.value = value;
            this.hash = hashCode();
            this.next = entry;
        }

        private Entry(K key) {
            this.key = key;
            this.hash = hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<K, V> entry = (Entry<K, V>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }


}
