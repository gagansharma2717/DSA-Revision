package Linked_List;
// Data Iterative -- Two Pointer with getNodeAt
// Data Recursive
// Pointer Iterative
// Pointer Recursive

public class Reverse_LinkedList {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        // Data Iterative
        public Node getNodeAt(int idx) {
            Node temp = head;

            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }

            return temp;
        }

        public void reverseDI() {
            int li = 0;
            int ri = size - 1;

            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        // Data Recursive
        Node rleft;
        public void reverseDR(){
            rleft = head;
            reverseDRHelper(head, 0);
        }

        public void reverseDRHelper(Node right, int floor) {
            if(right == null){
                return;
            }

            reverseDRHelper(right.next, floor+1);

            // because recursion call m stack se niche aate hue means right se left jaate hue swapping hui
            // so checked floor >= 2
            if(floor >= size / 2 ){
                int temp = right.data;
                right.data = rleft.data;
                rleft.data = temp ;

                rleft = rleft.next;
            }
        }


        // Pointer Iterative
        public void ReversePtrIterative(){
            // It will require three pointers
            Node prev = null;
            Node curr = head;

            while(curr != null){
                // Storing current ka next in 3rd pointer
                Node currNext= curr.next;
                // Making a reverse link
                curr.next = prev;

                // Increasing both prev and curr pointers
                prev = prev.next;
                curr = currNext;
            }

            // Swapping head and tail
            Node temp = head ;
            head = tail;
            tail = temp;
        }

        // Pointer Recursive
        private void reversePtrHelper(Node node) {
            if(node == null) return;

            reversePtrHelper(node.next);

            if(node == tail){
                // nothing to do
            }else{
                node.next.next = node;
            }
        }
        public void ReversePtrRecursive(){
            reversePtrHelper(head);

            // breaking the connection from head to its next node
            head.next = null;

            // Swapping head and tail
            Node temp = head ;
            head = tail;
            tail = temp;

            tail.next = null;
        }
    }

}
