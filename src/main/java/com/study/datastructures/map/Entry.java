//package com.study.datastructures.map;
//
//import java.util.Objects;
//
//public class Entry {
//    Object key;
//    Object value;
//
//    public Entry(Object key, Object value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public Entry(Object key) {
//        this.key = key;
//
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Entry entry = (Entry) o;
//        return Objects.equals(key, entry.key);
//                //&&                 Objects.equals(value, entry.value);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(key);
//    }
//}
