package interviewexercises.e15;

public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // WRITE THE REVERSEBETWEEN METHOD HERE //
    //                                      //
    //                                      //
    //                                      //
    //                                      //
    //////////////////////////////////////////
    public void reverseBetween(int m, int n) {
        if (m >= n) return;
        else if (length == 0) return;
        else if (m < 0 || n >= length) return;

        Node pointer = head;
        int pointerIdx = 0;
        Node pointerBeforeM = null;
        while (pointerIdx < m) {
            pointerBeforeM = pointer;
            pointer = pointer.next;
            pointerIdx++;
        }
        Node pointerM = pointer;
        Node pointerN = null;
        Node preNode = null;

        while (pointerIdx <= n) {
            if (pointerIdx == n) pointerN = pointer;
            Node nextPointer = pointer.next;
            pointer.next = preNode;
            preNode = pointer;
            pointer = nextPointer;
            pointerIdx++;
        }

        pointerM.next = pointer;

        if (pointerBeforeM != null) pointerBeforeM.next = pointerN;

        if (m == 0) head = pointerN;

    }

}