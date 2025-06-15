import java.util.LinkedList;

public class LinkedLists_Implementation {

    //NODE CREATION
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;


    //ADD AT LAST
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = tail = newNode;
            return;
        }
        tail.next= newNode;
        tail = newNode;
    }


    //PRINT A LINKEDLIST
    public void print(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String args[]){
        //LinkedList ll = new LinkedList();
        LinkedLists_Implementation ll = new LinkedLists_Implementation();
        ll.print();
        ll.addLast(1);
        ll.print();
        ll.addLast(2);
        ll.print();
        ll.addLast(4);
        ll.print();
    }
}
