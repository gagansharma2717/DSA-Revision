package Binary_Tree;

import java.io.*;
import java.util.*;

public class Iterative_Traversal {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    // We will use class pair and uski state ki help se ye traversal krenge
    public static void iterativePrePostInTraversal(Node node) {
        // write your code here
        Pair rp = new Pair(node, 1);
        // Added node and state in pair object root pair rp
        Stack<Pair> stk= new Stack();
        stk.push(rp);

        String pre = "";
        String in = "";
        String post = "";
        while(stk.size() > 0)
        {
            Pair top = stk.peek();

            if(top.state == 1) // pre and state ++ and add left node
            {
                pre += top.node.data + " "; //add node data

                top.state++; // state++

                if(top.node.left != null) // adding left child
                {
                    Pair ln = new Pair(top.node.left, 1);

                    stk.push(ln);
                }
            }
            else if(top.state == 2) // in and state++ and right node
            {

                in += top.node.data + " "; //add node data

                top.state++; // state++

                if(top.node.right != null) //adding right child
                {
                    Pair rn = new Pair(top.node.right, 1);

                    stk.push(rn);
                }
            }
            else // post and pop node from stack
            {

                post += top.node.data + " ";
                stk.pop();
            }

        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        iterativePrePostInTraversal(root);
    }

}
