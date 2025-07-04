import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue_Implementation {

    //QUEUE IMPLEMENTATION USING ARRAYS
    static class QueueA{
        static int arr[];
        static int size;
        static int rear;
        QueueA(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public boolean isEmpty(){
            return rear == -1;
        }
        public boolean isFull(){
            return rear == size-1;
        }
        public void add(int data){
            if (isFull()){
                System.out.println("Queue is full");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }
        public int remove(){
            if (isEmpty())
                return -1;
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }
        public int peek(){
            if(isEmpty())
                return -1;
            return arr[0];
        }
    }


    //CIRCULAR QUEUE IMPLEMENTATION USING ARRAYS
    static class CQueue{
        static int arr[];
        static int size;
        static int front;
        static int rear;
        CQueue(int n){
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }
        public boolean isEmpty(){
            return  (rear==-1 && front==-1);
        }
        public boolean isFull(){
            return (rear+1)%size==front;
        }
        public void add(int data){
            if (isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if (front==-1)
                front=0;  //frist time add
            rear = (rear+1)%size;
            arr[rear]=data;
        }
        public int remove(){
            if (isEmpty())
                return -1;
            int result = arr[front];
            if (rear==front)
                rear=front=-1; //last element remove
            else
                front = (front+1)%size;
            return result;
        }
        public int peek(){
            if (isEmpty())
                return -1;
            return arr[front];
        }
    }


    //QUEUE IMPLEMENTATION USING LINKED LIST
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class QueueLL{
        static Node head = null;
        static Node tail = null;
        static int size;

        public boolean isEmpty(){
            return (tail==null && head==null);
        }
        public void add(int data){
            Node newNode = new Node(data);
            if(head==null){
                head=tail=newNode;
            }
            tail.next=newNode;
            tail=newNode;
            size++;
        }
        public int remove(){
            if (isEmpty())
                return -1;
            if(head==tail){
                head=tail=null;
            }
            int result = head.data;
            head = head.next;
            size--;
            return result;
        }
        public int peek(){
            if (isEmpty())
                return -1;
            return head.data;
        }
    }


    //QUEUE IMPLEMENTATION USING TWO STACKS
    static class Queue2S{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }
        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public int remove(){
            if (s1.isEmpty())
                return -1;
            return s1.pop();
        }
        public int peek(){
            if (s1.isEmpty())
                return -1;
            return s1.peek();
        }
    }


    //STACK IMPLEMENTATION USING TWO QUEUES
    static class StackC2{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        //Add data in non empty queue
        public void add(int data){
            if(!q1.isEmpty())
                q1.add(data);
            else
                q2.add(data);
        }
        //Remove
        public int pop(){
            if (isEmpty())
                return -1;
            int top = -1;
            if(!q1.isEmpty()){  //case 1 - when transfer q1 to q2
                while (!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty())
                        break;
                    q2.add(top);
                }
            }else{ //case 2 - when transfer q2 to q1
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty())
                        break;
                    q1.add(top);
                }
            }
            return top;
        }
        //peek
        public int peek(){
            if (isEmpty())
                return -1;
            int top = -1;
            if(!q1.isEmpty()){  //case 1 - when transfer q1 to q2
                while (!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }else{ //case 2 - when transfer q2 to q1
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }


    public static void main(String args[]){
        StackC2 s = new StackC2();
        s.add(1);
        s.add(2);
        s.add(3);

        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
