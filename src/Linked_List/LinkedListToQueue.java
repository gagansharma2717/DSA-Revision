package Linked_List;
import java.io.*;
import java.util.*;
// stack == addfirst and removefirst, queue = removefirst and addlast
public class LinkedListToQueue {
    public static class LLToQueueAdapter {
        LinkedList<Integer> list;

        public LLToQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            // write your code here
            return list.size();
        }

        void add(int val) {
            // write your code here
            list.addLast(val);
        }

        int remove() {
            // write your code here
            if(size() == 0) {
                System.out.println("Queue Underflow");
            }

            return list.removeFirst();
        }

        int peek() {
            // write your code here
            if(size() == 0) {
                System.out.println("Queue Underflow");
            }

            return list.getFirst();
        }
    }
}

