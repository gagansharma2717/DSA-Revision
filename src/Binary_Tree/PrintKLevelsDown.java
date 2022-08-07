package Binary_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PrintKLevelsDown {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> stk = new Stack<>();
        stk.push(rtp);

        int idx = 0;
        while(stk.size() > 0){
            Pair top = stk.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);

                    stk.push(lp);
                }else{
                    top.node.left = null;
                }

                top.state++;
            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    stk.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else {
                stk.pop();
            }
        }

        return root;
    }

    private static void printKLevels(Node node, int k) {

        // Negative Base Case
        if(node == null || k < 0){
            return ;
        }

        // Positive Base Case
        if(k == 0 ){
            System.out.println(node.data);
            return;
        }

        // Faith K-1 levels se saare print ho jaayenge
        printKLevels(node.left, k-1);
        printKLevels(node.right, k-1);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            if(!values[i].equals("n")){
                arr[i] = Integer.parseInt(values[i]);
            }else{
                arr[i] = null;
            }
        }

        int k = Integer.parseInt(br.readLine());
        Node root = construct(arr);
        printKLevels(root,k);

    }

}
