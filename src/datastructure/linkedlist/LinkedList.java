package datastructure.linkedlist;

public class LinkedList {
    class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        head = tail = null;
        length = 0;
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node pointer = head;

        while (pointer != null) {
            System.out.println(pointer.getValue());
            pointer = pointer.getNext();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node pointer = head;
        Node prePointer = head;

        while (pointer.getNext() != null) {
            prePointer = pointer;
            pointer = pointer.getNext();
        }

        tail = prePointer;
        tail.setNext(null);
        length--;

        if (length == 0) {
            head = tail = null;
        }

        return pointer;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        newNode.setNext(head);
        head = newNode;

        if (length == 0) tail = newNode;

        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node removedNode = head;
        head = head.getNext();
        removedNode.setNext(null);
        length--;

        if (length == 0) {
            tail = null;
        }

        return removedNode;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        int pointerIndex = 0;
        Node pointer = head;

        while (pointer != null) {
            if (pointerIndex == index)
                return pointer;
            pointerIndex++;
            pointer = pointer.getNext();
        }

        return null;
    }

    public boolean set(int index, int value) {
        Node modifiedNode = get(index);

        if (modifiedNode != null) {
            modifiedNode.setValue(value);
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        else if (index == 0) {
            prepend(value);
            return true;
        }
        else if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node preNode = get(index - 1);

        newNode.setNext(preNode.getNext());
        preNode.setNext(newNode);

        length++;

        return false;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        else if (index == 0) return removeFirst();
        else if (index == length - 1) return removeLast();

        Node preNode = get(index - 1);
        Node removedNode = preNode.getNext();

        preNode.setNext(removedNode.getNext());
        removedNode.setNext(null);
        length--;

        return removedNode;
    }

    public void reverse() {
        if (length == 1) return;
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.getNext();
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }
}
