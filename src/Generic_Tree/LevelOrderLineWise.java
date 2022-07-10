package Generic_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLineWise {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr){
        Node root = null;
        Stack<Node> stk = new Stack<>();
        for(int i = 0 ; i < arr.length; i++) {
            if (arr[i] != -1) {
                Node temp = new Node();
                temp.data = arr[i];

                if(stk.isEmpty()){
                    root = temp;
                }else{
                    Node parent = stk.peek();
                    parent.children.add(temp);
                }

                stk.push(temp);
            }else{
                stk.pop();
            }
        }

        return root;
    }
    public static void levelOrderLineWise(Node root) {
        // In levelOrderLineWise we require two queues one is main queue and another one is child queue
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();

        // We mainly do the operations in main queue and will add the children in child queue
        // when main queue will become empty then we will make child queue as main queue
        // and will re-initialize child queue
        mq.add(root);
        while (mq.size() > 0) {
            root = mq.remove();
            System.out.print(root.data + " ");

            for (Node child : root.children) {
                cq.add(child);
            }

            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    public static void levelOrderLineWise2(Node root) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);

        while (mq.size() > 0) {
            // chidlren in current level
            int cicl = mq.size();

            // loop from 0 to children in current level
            for (int i = 0; i < cicl; i++) {
                // remove print add children
                root = mq.remove();
                System.out.print(root.data + " ");

                for (Node child : root.children) {
                    mq.add(child);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        levelOrderLineWise(root);
        System.out.println("Approach 2");
        levelOrderLineWise2(root);
    }
}
