package com.study.datastructures.list;


public class  LinkedList<E> implements List<E> {
    Node<E> head = null;
    Node<E> tail = null;
    Node<E> tempNode;
    int capacity = 0;


    @Override
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value);
            capacity++;
        } else {
            Node<E> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            capacity++;
            tempNode.next = new Node<>(value);
            tail = tempNode.next;
            tail.prev = tempNode;
        }
    }

    @Override
    public void add(E value, int index) {
        // TODO list/2
        Node<E> nodeAfter;
        if (index > capacity) {
            throw new IndexOutOfBoundsException("ADD by Index. LinkedList is empty. Try insert with index 0. Sorry...");
        }
        if (capacity == 0) {
            head = new Node<>(value);
            capacity++;
        } else {
            if (index == 0) {
                tempNode = head;
                head = new Node<>(value);
                head.next = tempNode;
                head.next.prev = head;
                capacity++;
                return;
            }
            tempNode = head;
            if (index == capacity) {
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = new Node<>(value);
                tempNode.next.prev = tempNode;
                tail = tempNode.next;
                capacity++;
                return;
            } else {
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        if (index != capacity - 1) {
                            nodeAfter = tempNode.next;
                            tempNode.next = new Node<>(tempNode.value);
                            tempNode.next.next = nodeAfter;
                            tempNode.value = value;
                        } else {
                            tempNode.next = new Node<>(tempNode.value);
                            tempNode.value = value;
                            tail = tempNode.next;
                        }
                        tempNode.next.prev = tempNode;
                        capacity++;
                        return;
                    }
                    tempNode = tempNode.next;
                }
            }
        }
    }


    @Override
    public E remove(int index) {
        // TODO list/2
        int temp_index = 0;
        Node<E> bufNode;
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("REMOVE by Index. Index (" + index + ") is biggest from length (" + capacity + ") of LinkedList . Sorry...");
        }
        if (capacity == 0) {
            throw new IndexOutOfBoundsException("REMOVE by Index. LinkedList is empty . Sorry...");

        } else {

            if (index == 0) {
                if (capacity == 1) {
                    bufNode = head;
                    head = null;
                    tail = null;
                    capacity--;

                    return (E) bufNode.value;
                } else {
                    tempNode = head;
                    head = head.next;
                    head.prev = null;
                    capacity--;
                    return (E) tempNode.value;
                }
            }

            if (index == capacity - 1) {
                tail = tail.prev;
                tail.next = null;
                capacity--;
                return tail.value;
            } else {
                tempNode = head;
                while (tempNode.next != null) {
                    if (++temp_index == index) {
                        bufNode = tempNode.next;
                        tempNode.next = tempNode.next.next;
                        tempNode.next.prev = tempNode;
                        return bufNode.value;
                    }
                    tempNode = tempNode.next;
                }
            }
        }
        return null;
    }

    @Override
    public E get(int index) {
        // TODO list/2
        if (head == null) {
            throw new IndexOutOfBoundsException("GET by Index. LinkedList is empty. Try insert with index 0. Sorry...");

        }
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("GET by Index. Index (" + index + ") is biggest from length (" + capacity + ") of LinkedList . Sorry...");
        }
        Node<E> tempNode = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return tempNode.value;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    @Override
    public E set(E value, int index) {
        // TODO list/2
        if (head == null) {
            throw new IndexOutOfBoundsException("SET by Index. LinkedList is empty. Try insert with index 0. Sorry...");
        }
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("SET by Index. Index (" + index + ") is biggest from length (" + capacity + ") of LinkedList . Sorry...");
        }
        tempNode = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                tempNode.value = value;
                return tempNode.value;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        capacity = 0;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null && capacity == 0;
    }

    @Override
    public boolean contains(E value) {
       return indexOf(value)>-1;
    }

    @Override
    public int indexOf(E value) {
        // TODO list/2
        int indexNode = 0;
        if (head != null) {
            {
                Node<E> tempNode = head;
                if (tempNode.value.equals(value)) {
                    return indexNode;
                }
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                    indexNode++;
                    if (tempNode.value.equals(value)) {
                        return indexNode;
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        int indexNode = 0;
        int lastIndexNode = -1;
        if (head != null) {
            {
                Node<E> tempNode = head;
                if (tempNode.value.equals(value)) {
                    lastIndexNode = indexNode;
                }
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                    indexNode++;
                    if (tempNode.value.equals(value)) {
                        lastIndexNode = indexNode;
                    }
                }
            }
        }
        return lastIndexNode;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (capacity > 0) {
            Node<E> tempNode = head;
            str.append(tempNode.value.toString());

            while (tempNode.next != null) {
                tempNode = tempNode.next;
                if (tempNode.value == null) {
                    str.append(",Null");
                } else {
                    str.append(",").append(tempNode.value.toString());
                }
            }
        }
        str.append("]");
        return str.toString();
    }

    static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        private Node(E object) {
            this.value = object;
        }

        private String toString(Node<E> node) {
            String str = "[";
            str += node.value;
            str += "]";
            return str;

        }

    }
}
