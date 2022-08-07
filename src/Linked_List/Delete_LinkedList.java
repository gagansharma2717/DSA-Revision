package Linked_List;

public class Delete_LinkedList {
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

        public void deleteFirst(){
            if(size == 1){
                head = tail = null;
                size--;
            }else{
                head = head.next;
                size--;
            }
        }

        public void deleteLast(){
            Node temp = head;

            for(int i = 0 ; i < size-2; i++){
                temp = temp.next;
            }

            temp.next = null;
            tail = temp;
            size--;
        }

        public void deleteAtIdx(int idx){
            if(idx <  0 || idx > size){
                System.out.println("Invalid Arguments");
                return;
            }
            if(idx == 0){
                deleteFirst();
            }else if( idx == size){
                deleteLast();
            }else{
                Node temp = head;
                Node prevNode = head;

                for(int i = 0 ; i < idx-1; i++) {
                    temp = temp.next;
                    prevNode = prevNode.next;
                }

                temp = temp.next.next;
                prevNode.next = temp;
                size--;
            }
        }
    }
}
