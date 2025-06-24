import java.util.ArrayList;
public class Heap_Implementation {

    //HEAP : HEAP IMPLEMENTATION USING ARRAYLIST
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        //INSERT IN HEAP
        public void add(int data) {
            //add at last idx
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (arr.get(x) < arr.get(par)) { //O(log n)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        //PEEK IN HEAP
        public int peek(){
            return arr.get(0);
        }

        //REMOVE FROM HEAP
        private void heapify2(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx = left;
            }
            if (right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){ //This condition means we reach at leaf node
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify2(minIdx);
            }
        }
        public int remove(){
            int data = arr.get(0);

            //step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step2 - delete last
            arr.remove(arr.size()-1);

            //step3 - heapify
            heapify2(0);
            return data;
        }
    }


    //HEAP: HEAP SORT - ASCENDING ORDER SORT (BY CREATING MAX HEAP)
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxInt = i;

        if (left < size && arr[left] > arr[maxInt]) {
            maxInt = left;
        }

        if (right < size && arr[right] > arr[maxInt]) {
            maxInt = right;
        }

        if (maxInt != i) {
            int temp = arr[i];
            arr[i] = arr[maxInt];
            arr[maxInt] = temp;

            heapify(arr, maxInt, size);
        }
    }
    public static void heapSort(int arr[]) {
        //step1 - build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        //step2 - push largest at end
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }



    public static void main(String args[]) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.add(6);

        int arr[] = {1,2,4,5,3};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

}
