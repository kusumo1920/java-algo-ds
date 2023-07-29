package datastructure.linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(9);
        myLinkedList.prepend(2);
        myLinkedList.append(12);
        myLinkedList.removeLast();
        myLinkedList.prepend(3);
        myLinkedList.removeFirst();
        myLinkedList.insert(1, 8);
        myLinkedList.remove(3);
        myLinkedList.reverse();
        myLinkedList.printList();
    }
}
