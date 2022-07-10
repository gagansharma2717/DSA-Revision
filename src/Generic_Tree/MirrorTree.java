package Generic_Tree;

import java.util.*;

public class MirrorTree {
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
    public static void display(Node node){
        // Negative base case
        if(node == null) return;

        // node ka data storing it in string
        String str = node.data + "->";
        // run loop on node ke children and add their data as well
        for(Node child : node.children){
            str += child.data + ", ";
        }
        str += ".";
        //print string
        System.out.println(str);

        // run loop on each node of tree and call same display mode
        for(Node child : node.children){
            display(child);
        }
    }
    private static void mirror(Node root) {

        // faith root ke children apne children ko mirror ke denge
        for(Node child : root.children){
            mirror(child);
        }

        // ab root ke children khud reverse ho jaye and root toh single node hi h toh tree ka mirror bn jaye
        Collections.reverse(root.children);
    }
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        display(root);
        mirror(root);
        System.out.println("After Mirror");
        display(root);
    }
}
