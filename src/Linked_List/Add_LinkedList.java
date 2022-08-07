package Linked_List;

public class Add_LinkedList {
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
        int size;

        public LinkedList(){
            head = null;
            tail = null;
            size = 0;
        }

        public void addAtHead(int val){
            Node temp = new Node(val);

            if(size == 0){
                head = tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }

            size++;
        }

        public void addAtTail(int val){
            Node temp = new Node(val);

            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public void addAtIndex(int index, int val){
            if(index < 0 || index > size){

            }
            else if(index == 0){
                addAtHead(val);
            }else if(index == size){
                addAtTail(val);
            }else{
                Node newNode = new Node(val);
                Node prevNode = head;
                Node temp = head;

                for(int i = 0 ; i < index-1; i++){
                    prevNode = prevNode.next;
                    temp = temp.next;
                }

                temp = temp.next;
                prevNode.next = newNode;
                newNode.next = temp;
                size++;
            }

        }
    }
}
