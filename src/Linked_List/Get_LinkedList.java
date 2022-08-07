package Linked_List;

public class Get_LinkedList {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList{
        Node head ;
        Node tail;
        int size ;

        LinkedList(){
            head = null;
            tail = null;
            size = 0;
        }

        // Not Imp
        public int getFirst(){
            if(size == 0) {
                return -1;
            }
            return head.data;
        }

        // Not Imp
        public int getLast(){
            if(size == 0){
                return -1;
            }

            return tail.data;
        }

        // IMP
        public int getAtIdx(int idx){
            if(idx < 0 || idx > size){
               return -1;
            }
            if(size == 0){
                return -1;
            }

            Node temp = head;
            for(int i = 0 ; i < idx; i++ ){
                temp = temp.next;
            }

            return temp.data;
        }
    }
}
