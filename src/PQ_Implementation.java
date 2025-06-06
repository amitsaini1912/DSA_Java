import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ_Implementation {
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(5);
        pq.add(3);
        pq.add(1);
        pq.add(9);
        pq.add(2);  //-> O(logn)

        System.out.println(pq);
        System.out.println(pq.peek());   // -> O(1)
        pq.remove(3);      // -> O(nlogn)
        System.out.println(pq);
    }
}
