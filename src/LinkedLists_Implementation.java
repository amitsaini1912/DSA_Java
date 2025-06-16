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
    public static int size;


    //ADD AT FIRST
    public void addFirst(int data){
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
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
        if (idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
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
        size++;
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


    //ROMOVE FROM START IN LINKEDLIST
    public static int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return -1;
        }
        if(size == 1){
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }
        size--;
        int val = head.data;
        head = head.next;
        return val;
    }
    //ROMOVE FROM LAST IN LINKEDLIST
    public static int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        }
        if(size == 1){
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }
        //find prev
        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }


    //SEARCH IN A LINKED LIST [ITERATIVE - LINEAR SEARCH]
    public static int itrSearch(int key){
        int i = 0;
        Node temp = head;
        while (temp != null){
            if(temp.data == key)
                return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }
    //SEARCH IN A LINKED LIST [RECURSIVE SEARCH]
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key); //recursive func
        if (idx ==-1){
            return -1;
        }
        return idx+1; //Backtarcking step
    }
    public int recSearch(int key){
        return helper(head, key);
    }


    //FIND AND DELETE Nth NODE FROM END IN LL
    public static int delNthFromEnd(int n){
        //step1 - find prev(temp)
        int i = 0;
        Node temp = head;
        while(i<size-n-1){
            temp = temp.next;
            i++;
        }
        //step2 - prev.next = prev.next.next
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }


    //REVERSE A LINKED LIST WITH ITERATIVE APPROACH
    public void reveseLL(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    //CHECK WHETHER A LL IS PALINDROM OR NOT
    public Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow;
    }
    public boolean isPalindrom(){
        if (head==null || head.next == null)
            return true;
        //step1 - find mid
        Node midNode = findMid();
        //step2 - reverse 2nd half ll
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        //step3 - check 1st half == 2nd half
        while (right!=null){
            if (left.data!=right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }


    //DETECT A LOOP/CYCLE IN A LL
    public static boolean iscycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if (slow==fast)
                return true;
        }
        return false;
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(iscycle());
        //     LinkedLists_Implementation ll = new LinkedLists_Implementation();
//        ll.addLast(2);
//        ll.addLast(4);
//        ll.addLast(5);
//        ll.addLast(6);
//        ll.add(2,3);
//        ll.print();
    }
}
