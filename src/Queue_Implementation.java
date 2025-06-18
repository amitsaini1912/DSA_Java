public class Queue_Implementation {

    //QUEUE IMPLEMENTATION USING ARRAYS
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        Queue(int n){
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


    public static void main(String args[]){
        QueueLL q = new QueueLL();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
