package com.study.datastructures.list;

import org.junit.Assert;
import org.junit.Test;


public class LinkedListTest {

    @Test
    public void add() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals("A", linkedList.head.value);
        Assert.assertEquals("[A,B,C]", linkedList.toString());
        linkedList.add(null);
        Assert.assertEquals(4, linkedList.capacity);
    }

    @Test
    public void testAddByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A", 0);
        linkedList.add("B", 0);
        linkedList.add("C", 0);
        Assert.assertEquals("[C,B,A]", linkedList.toString());
        linkedList.add("D", 2);
        Assert.assertEquals("[C,B,D,A]", linkedList.toString());
        linkedList.add("Z", 1);
        Assert.assertEquals("[C,Z,B,D,A]", linkedList.toString());
        linkedList.add(null, 2);
        Assert.assertEquals(6, linkedList.capacity);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeExp() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.remove(10);
    }

    @Test
    public void remove() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.remove(2);
        linkedList.add(null, 2);
        linkedList.remove(2);
        Assert.assertEquals(1, linkedList.indexOf("B"));
        Assert.assertEquals(-1, linkedList.indexOf("C"));
        Assert.assertEquals(2, linkedList.capacity);
    }

    @Test
    public void get() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(3, linkedList.capacity);
        Assert.assertEquals("C", linkedList.get(2));
        Assert.assertEquals("B", linkedList.get(1));
        linkedList.add(null, 2);
        Assert.assertNull(linkedList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExp() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.get(7);
    }


    @Test
    public void set() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.set("D", 0);
        linkedList.set("E", 1);
        linkedList.set("F", 2);
        Assert.assertEquals("[D,E,F]", linkedList.toString());
        Assert.assertEquals(3, linkedList.capacity);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setExp() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.set("Z", 20);
    }

    @Test
    public void clear() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.clear();
        Assert.assertEquals(0, linkedList.capacity);
    }

    @Test
    public void size() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(3, linkedList.capacity);
        linkedList.clear();
        linkedList.add("B");
        Assert.assertEquals(1, linkedList.capacity);
        Assert.assertEquals("[B]", linkedList.toString());
    }

    @Test
    public void isEmpty() {
        LinkedList linkedList = new LinkedList();
        Assert.assertTrue(linkedList.isEmpty());
        linkedList.add("A");
        linkedList.add("B");
        Assert.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void contains() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertFalse(linkedList.contains("M"));
        linkedList.add("M");
        Assert.assertTrue(linkedList.contains("M"));
        Assert.assertTrue(linkedList.contains("A"));
    }

    @Test
    public void indexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(-1, linkedList.indexOf("M"));
        linkedList.add("M");
        linkedList.add("B");
        Assert.assertEquals(3, linkedList.indexOf("M"));
    }

    @Test
    public void lastIndexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(-1, linkedList.lastIndexOf("M"));
        linkedList.add("B");
        linkedList.add("M");
        Assert.assertEquals(3, linkedList.lastIndexOf("B"));
        Assert.assertEquals(5, linkedList.capacity);
    }


    @Test
    public void testToString() {
        LinkedList linkedList = new LinkedList();
        Assert.assertEquals("[]", linkedList.toString());
        linkedList.add("A", 0);
        Assert.assertEquals("[A]", linkedList.toString());
        linkedList.add("B", 1);
        linkedList.add("C", 2);
        Assert.assertEquals("[A,B,C]", linkedList.toString());
    }
}