package com.study.datastructures.list;


import junit.framework.Assert;
import org.junit.Test;


public class ArrayListTest {

    @Test
    public void add() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        Assert.assertEquals(3, arrayList.size());
        arrayList.clear();
        long startTime = System.nanoTime();
    }

    @Test
    public void testAdd() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D", 2);
        Assert.assertEquals(4, arrayList.size());
        Assert.assertEquals("D", arrayList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddExp() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Z", 100);
    }

    @Test
    public void remove() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assert.assertEquals("B", arrayList.remove(1));
        Assert.assertEquals(2, arrayList.size());
        Assert.assertEquals("C", arrayList.get(1));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeExp() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.remove(1);
    }

    @Test
    public void get() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assert.assertEquals("C", arrayList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExp() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.get(1);
    }

    @Test
    public void set() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.set("F", 1);
        Assert.assertEquals("A", arrayList.get(0));
        Assert.assertEquals("F", arrayList.get(1));
        Assert.assertEquals("C", arrayList.get(2));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setExp() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.set("E", 5);
    }

    @Test
    public void clear() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        Assert.assertEquals(15, arrayList.size());
        arrayList.clear();
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void size() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        Assert.assertEquals(15, arrayList.size());
    }

    @Test
    public void isEmpty() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        Assert.assertFalse(arrayList.isEmpty());
    }

    @Test
    public void contains() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assert.assertTrue(arrayList.contains("C"));
        Assert.assertFalse(arrayList.contains("F"));
    }

    @Test
    public void indexOf() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assert.assertEquals(2, arrayList.indexOf("C"));
        Assert.assertEquals(-1, arrayList.indexOf("F"));
    }

    @Test
    public void lastIndexOf() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("F");
        arrayList.add("B");
        arrayList.add("H");
        Assert.assertEquals(4, arrayList.lastIndexOf("B"));
    }

    @Test
    public void testToString() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assert.assertEquals("[A,B,C]", arrayList.toString());
    }
}