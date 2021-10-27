package com.study.datastructures.list;

public class  ArrayList <T> implements List <T> {
    private static final int INIT_SIZE = 10;
    T[] array = (T[]) new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T value) {
        if (pointer >= array.length) {
            resize(array.length * 2);
        }
        array[pointer++] = value;
    }

    public void add(T value, int index) {
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

    public T remove(int index) {

        if (index >= pointer || index < 0) {
            throw new IndexOutOfBoundsException("REMOVE. Index should be between 0 and " + (pointer - 1) + ". You entered the index value " + index + ". Sorry...");
        }
        T deletedValue = array[index];
        for (int i = index; i < pointer - 1; i++) {
            array[i] = array[i + 1];
        }
        pointer--;
        resize(array.length - 1);
        return deletedValue;
    }

    public T get(int index) {
        if (index >= pointer || index < 0) {
            throw new IndexOutOfBoundsException("GET. Index should be between 0 and " + (pointer - 1) + ". You entered the index value " + index + ". Sorry...");
        }
        return array[index];
    }

    public T set(T value, int index) {
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

    public boolean contains(T value) {
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

    public int indexOf(T value) {
        if (pointer > 0) {
            for (int i = 0; i < pointer; i++) {
                if (array[i].equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(T value) {
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
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < pointer; i++) {
            str.append(array[i]);
            if (i < pointer - 1) {
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }

    private void resize(int newLength) {
        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}