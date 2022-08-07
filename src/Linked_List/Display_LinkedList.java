package Linked_List;

public class Display_LinkedList {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public void display() {
            Node curr = head;

            while (curr.next != null) {
                System.out.println(curr.data + " ");
                curr = curr.next;
            }
        }

        public void displayReverse(Node curr) {
            if(curr == null) return;

            displayReverse(curr.next);

            System.out.println(curr.data);
        }
    }
}
