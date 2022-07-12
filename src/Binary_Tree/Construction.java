package Binary_Tree;
import java.util.*;
public class Construction {
    // Node ke pass data and left node and right node hogi
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

    // state 1 toh left m node add hoga ,state 2 for right , 3 aate hi stack se pop krdiya
    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node)
    {
        if (node == null)
            return;

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        // faith
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        // root bnaya bcoz we know arr[0] hi root hoga then pair bnaya woth root node and state 1
        Node root = new Node(arr[0],null,null);
        Pair rtp = new Pair(root, 1);

        // then stack bnaya and root node pair push kiya
        Stack<Pair> stk = new Stack<>();
        stk.push(rtp);

        // index to run loop on array
        int idx = 0;
        // jb tak stack empty nhi ho jaata
        while(stk.size() > 0)
        {
            // aate hi stack ke top se pair nikala
            Pair top = stk.peek();

            // agar pair ki state 1 hogi toh left m add hoga
            if(top.state == 1)
            {
                // aate hi index bdaya
                idx++;
                // ab uss index pr ya value hogi ya null
                // agr value h toh
                if (arr[idx] != null) {
                    // Pair top ke node ke left m new node bnaya then uska pair bnaya with state 1 and stack pr push kiya
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    stk.push(lp);
                }
                // agar uss index pr null hai toh
                // Pair top ke node ke left m null krdiya
                else {
                    top.node.left = null;
                }

                // At the end pair top ki state bda di
                top.state++;
            }
            // agar pair state 2 hogi m right m add hoga
            // similar things we have to do for right as well just ab top ke node ke right m new node bnega
            else if(top.state == 2)
            {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);

                    Pair rp = new Pair(top.node.right, 1);
                    stk.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            }
            // agr 3 hogi toh stack se pop
            else
            {
                stk.pop();
            }
        }

        display(root);
    }
}
