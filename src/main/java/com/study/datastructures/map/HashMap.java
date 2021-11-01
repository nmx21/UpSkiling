package com.study.datastructures.map;

import com.study.datastructures.list.ArrayList;
import com.study.datastructures.list.List;

import java.util.Iterator;
import java.util.Objects;

public class HashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_CAPACITY = 5;
    //private int capacity = DEFAULT_CAPACITY;
    private List<Entry<K, V>>[] buckets;
    private int size;


    public HashMap() {
        buckets = new ArrayList[DEFAULT_CAPACITY];
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        if (size > buckets.length * 0.75) {
            buckets = resizeBuckets(buckets);
        }
        int bucketIndex = getBucketIndex(entry);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList<>();
            buckets[bucketIndex].add(entry);
            size++;
        } else if (buckets[bucketIndex].contains(entry)) {
            int index = buckets[bucketIndex].indexOf(entry);
            Entry<K, V> oldValue = buckets[bucketIndex].get(index);
            buckets[bucketIndex].set(entry, index);
            return oldValue.value;
        } else {
            buckets[bucketIndex].add(entry);
            size++;
        }
        return null;
    }

    private ArrayList<Entry<K, V>>[] resizeBuckets(List<Entry<K, V>>[] buckets) {
        int newCapacity = buckets.length*2;
        ArrayList<Entry<K, V>>[] newBuckets = new ArrayList[newCapacity];
       // for (Entry<K,V> entry: this){
         //   int bucketIndex = getBucketIndex(entry.key);
           // newBuckets[bucketIndex].add(entry);
        //}

//        for (int i = 0; i < buckets.length; i++) {
//            if (buckets[i] != null) {
//                for (int j = 0; j < buckets[i].size(); j++) {
//                    int newBucketIndex = getBucketIndex(buckets[i].get(j));
//                    if (newBuckets[newBucketIndex] == null) {
//                        newBuckets[newBucketIndex] = new ArrayList<>();
//                        newBuckets[newBucketIndex].add(buckets[i].get(j));
//                    } else if (newBuckets[newBucketIndex].contains(buckets[i].get(j))) {
//                        int index = newBuckets[newBucketIndex].indexOf(buckets[i].get(j));
//                        newBuckets[newBucketIndex].set(buckets[i].get(j), index);
//                    } else {
//                        newBuckets[newBucketIndex].add(buckets[i].get(j));
//                    }
//                }
//            }
//        }
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
        // TODO через итератор
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
        int hash = entry.hashCode();
        return Math.abs((hash) % buckets.length);
    }

    //@Override
    public Iterator<Entry<K,V>> iterator() {
        return null;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private Entry(K key) {
            this.key = key;
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
