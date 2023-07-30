package interviewexercises.e12;

public class Main {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);


        System.out.println("Middle Node:");
        System.out.println( myLinkedList.findMiddleNode().value);


        /*
            EXPECTED OUTPUT:
            ----------------
            Middle Node:
            3

        */

    }

}