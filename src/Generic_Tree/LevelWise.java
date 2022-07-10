package Generic_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelWise {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr){
        Node root = null;
        Stack<Node> stk = new Stack<>();

        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != -1){
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
    private static void levelWise(Node root) {
        // For level wise we need to use queue we will add only 1 level nodes in the queue
        // Added root node initially
        Queue<Node> que  = new ArrayDeque<>();
        que.add(root);

        // Till queue size becomes 0 remove node from queue , print it and add their children
        while(que.size() > 0 ){
            root = que.remove();
            System.out.print(root.data + " ");

            for(Node child : root.children){
                que.add(child);
            }
        }
        System.out.print(" ");
    }
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        levelWise(root);
    }
}
