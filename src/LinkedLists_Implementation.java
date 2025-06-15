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


    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.add(2);
        ll.add(4);
        System.out.println(ll);
    }
}
