package Linked_List;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KReverse {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public int size() {
            return size;
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }
        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void kReverse(int k) {
            LinkedList prev = new LinkedList();

            while(size > 0){
                LinkedList curr = new LinkedList();

                if(size < k){
                    while(size > 0){
                        int val = head.data;
                        this.removeFirst();
                        curr.addLast(val); // this is will not reverse last group less than k
                    }
                }else {
                    // extracting one group of size k
                    for (int i = 0; i < k; i++) {
                        int val = head.data;
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }
                // or prev.size == 0
                // First first reverse group of k
                if(prev.head == null) {
                    prev = curr;
                }else{
                    prev.tail.next = curr.head; // updating prev head
                    prev.tail = curr.tail; // updating prev tail
                    prev.size += curr.size; // updating prev size
                }

                prev.tail.next = null;
                this.head = prev.head;
                this.tail = prev.tail;
                this.size = prev.size;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        int k = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l1.kReverse(k);
        l1.display();
        l1.addFirst(a);
        l1.addLast(b);
        l1.display();
    }
}
