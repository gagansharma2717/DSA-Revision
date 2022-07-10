package Generic_Tree;
import java.util.*;

public class Traversal {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr){
        Node root = null;
        Stack<Node> stk = new Stack<>();

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] != -1){
                Node child = new Node();
                child.data = arr[i];

                if(stk.isEmpty()){
                    root = child;
                }else{
                   Node parent = stk.peek();
                   parent.children.add(child);
                }

                stk.push(child);
            }else{
                stk.pop();
            }
        }

        return root;
    }
    private static void traversal(Node root) {
        System.out.println("Pre-Node -> " + root.data);
        for(Node child : root.children){
            System.out.println( "Pre-Edge -> " + root.data + "-> " + child.data + ".");
            traversal(child);
            System.out.println( "Post-Edge -> " + root.data + "-> " + child.data + ".");
        }
        System.out.println("Post-Node -> " + root.data );
    }
    public static void main(String[] args) {

        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        traversal(root);

    }
}

