package com.study.datastructures.list;

public class ArrayList implements List {
    private static final int INIT_SIZE = 10;
    Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(Object value) {
        if (pointer >= array.length) {
            resize(array.length * 2);
        }
        array[pointer++] = value;
    }

    public void add(Object value, int index) {
        if (index >= pointer || index < 0) {
            throw new IndexOutOfBoundsException("ADD. Index should be between 0 and " + pointer + ". You entered the index value " + index + ". Sorry...");
        }
        if (pointer >= array.length) {
            resize(array.length * 2);
        }
        for (int i = index; i < pointer; i++) {
            array[i + 1] = array[i];
        }
        pointer++;
        array[index] = value;
    }

    public Object remove(int index) {
        if (index >= pointer || index < 0) {
            throw new IndexOutOfBoundsException("REMOVE. Index should be between 0 and " + (pointer - 1) + ". You entered the index value " + index + ". Sorry...");
        }
        for (int i = index; i < pointer - 1; i++) {
            array[i] = array[i + 1];
        }
        pointer--;
        resize(array.length - 1);
        return array;
    }

    public Object get(int index) {
        if (index >= pointer || index < 0) {
            throw new IndexOutOfBoundsException("GET. Index should be between 0 and " + (pointer - 1) + ". You entered the index value " + index + ". Sorry...");
        }
        return array[index];
    }

    public Object set(Object value, int index) {
        if (index >= pointer || index < 0) {
            throw new IndexOutOfBoundsException("SET. Index should be between 0 and " + (pointer - 1) + ". You entered the index value " + index + ". Sorry...");
        }
        return array[index] = value;
    }

    public void clear() {
        for (int i = pointer - 1; i > 0; i--) {
            array[i] = null;
        }
        pointer = 0;
        resize(INIT_SIZE);
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public boolean contains(Object value) {
        // with indexOff
        if (pointer > 0) {
            for (int i = 0; i < pointer; i++) {
                if (array[i].equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object value) {
        if (pointer > 0) {
            for (int i = 0; i < pointer; i++) {
                if (array[i].equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        int marker = -1;
        if (pointer > 0) {
            for (int i = 0; i < pointer; i++) {
                if (array[i].equals(value)) {
                    marker = i;
                }
            }
        }
        return marker;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < pointer; i++) {
            str += array[i];
            if (i < pointer - 1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}