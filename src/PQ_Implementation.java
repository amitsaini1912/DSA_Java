import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ_Implementation {

    static class Student implements Comparable<Student>{//Overriding
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    public static void main(String args[]){

        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 4));
        pq.add(new Student("B",5));
        pq.add(new Student("C",2));
        pq.add(new Student("D",12));

        while (!pq.isEmpty()){
            System.out.println(pq.peek().name + " -> "+ pq.peek().rank);
            pq.remove();
        }


       /* PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(5);
        pq2.add(3);
        pq2.add(1);
        pq2.add(9);
        pq2.add(2);  //-> O(logn)

        System.out.println(pq2);
        System.out.println(pq2.peek());   // -> O(1)
        pq.remove(3);      // -> O(nlogn)
        System.out.println(pq2);
        */

    }
}
