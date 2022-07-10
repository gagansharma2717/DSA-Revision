package Generic_Tree;
import java.util.*;
public class HeightofTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // For this contruction we need stack and node root which will be null initially
    public static Node construct(int[] arr){
        Node root = null;
        Stack<Node> stk = new Stack<>();

        // run loop on given array
        for(int i = 0 ; i < arr.length; i++){
            // if ele of array is not -1 means there is a node
            // so make a new node add the value of ele in node data
            // then check stack if stack is empty means this is root node and assign this node as root
            // if stack is not empty then peek the stack and uske children mai curr node add krdo
            // then push curr node to stack
            // while looping if you find ele -1 then remove top node from stack
            if(arr[i] != -1){
                Node child = new Node();
                child.data = arr[i];
                if(stk.isEmpty()){
                    root = child;
                }else {
                    Node parent = stk.peek();
                    parent.children.add(child);
                }

                stk.push(child);
            }else{
                stk.pop();
            }
        }

        // return the root node your generic tree is ready
        return root;
    }

    public static int heightByEdges(Node root){
       // initially we took height as -1 bcoz if tree has only root node then its height will be 0
       // by edges
       int ht = -1;

       // loop on root's children and get a height of children nodes and compare it with maxht
       for(Node child : root.children){
           int ch = heightByEdges(child);
           ht = Math.max(ch + 1,ht);
       }

       // add root own height
       ht += 1;

       return ht;
    }


    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0 ; i < arr.length; i++){
//            arr[i] = scn.nextInt();
//        }
        // -1 determines here that immediate node has no child e.g. 50, -1 means 50 has no child
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        //int[] arr = {10};
        Node root = construct(arr);
       
        int heightofTree = heightByEdges(root);
        System.out.println("Height By Edges of tree : " + heightofTree);

    }
}
