package com.study.datastructures.list;

public class Node {
    Object value;
    Node next;
    Node prev;

    public Node(Object object) {
        this.value = object;
    }

    public String toString(Node node) {
        String str = "[";
        str += node.value;
        str += "]";
        return str;

    }

}
