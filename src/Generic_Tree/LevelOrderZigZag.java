package Generic_Tree;
import java.util.*;

public class LevelOrderZigZag {
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
    private static void levelOrderZigZag(Node node) {
        // For this zig-zag we require two stack one is main stack and another one is child stack
        // We will do the operations in main stack and add children in child stack
        // For odd level we will add the node in child stack from front
        // For even level we will add the nodes in the child stack from end
        // We main stack is empty we will make child stack as main stack
        // re-initialize child stack and increase the level
        // Initial level is 1
        int level = 1;

        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.push(node);
        while(ms.size() > 0 ){
            node = ms.pop();
            System.out.print(node.data + " ");

            if(level % 2 == 1 ){
                for(int i = 0 ; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }else{
                for(int i = node.children.size() - 1; i > 0 ; i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }

            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        levelOrderZigZag(root);
    }
}
