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


    //ADD AT FIRST
    public void addFirst(int data){
        //step1 - create new node
        Node newNode = new Node(data);
        if (head==null){
            head = tail = newNode;
            return;
        }
        //step2 - new node next -> head
        newNode.next = head;
        //step3 - head -> new node
        head = newNode;
    }
    //ADD AT Kth IDX IN A LINKEDLIST
    public void add(int idx, int data){
        Node newNode = new Node(data);
        int i = 0;
        Node temp = head;
        while (i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
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
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String args[]){
        //LinkedList ll = new LinkedList();
        LinkedLists_Implementation ll = new LinkedLists_Implementation();
        ll.addLast(1);
        ll.addLast(2);
        ll.add(2,4);
        ll.print();
    }
}
