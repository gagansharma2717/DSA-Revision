package Linked_List;

import java.io.*;
import java.util.*;
// stack == addfirst and removefirst, queue = removefirst and addlast
public class LinkedListToStack {

    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }


        int size() {
            // write your code here
            list.size();
        }

        void push(int val) {
            // write your code here
            list.addFirst(val);
        }

        int pop() {
            // write your code here
            if(size() == 0){
                System.out.println("Stack Underflow");
            }
            return list.removeFirst();

        }

        int top() {
            // write your code here
            if(size() == 0){
                System.out.println("Stack Underflow");
            }
            return list.getFirst();
        }
    }

}

