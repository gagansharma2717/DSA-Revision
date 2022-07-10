package Generic_Tree;
import java.util.*;
// Generic tree can have any number of children nodes
// So, a node stores data and a arraylist of children nodes information
public class Construction {
    // Node has two type of info that is data and arraylist of children nodes
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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0 ; i < arr.length; i++){
//            arr[i] = scn.nextInt();
//        }
        // -1 determines here that immediate node has no child e.g. 50, -1 means 50 has no child
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        display(root);

    }
}

