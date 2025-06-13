import java.util.ArrayList;

public class Heap_Implementation {

    public static void heapify(int arr[], int i, int size){
       int left = 2*i+1;
       int right = 2*i+2;
       int maxInt = i;

       if(left<size && arr[left]>arr[maxInt]){
           maxInt=left;
       }

       if(right<size &&  arr[right]>arr[maxInt]){
           maxInt=right;
       }

       if(maxInt != i){
           int temp = arr[i];
           arr[i] = arr[maxInt];
           arr[maxInt]=temp;

           heapify(arr, maxInt, size);
       }
    }

    public static void heapSort(int arr[]){
        //step1 - build maxHeap
        int n = arr.length;
        for (int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        //step2 - push largest at end
        for (int i = n-1; i > 0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]){
        int arr[]  = {1,2,5,3,4};
        heapSort(arr);

        //print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

   /* static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last idx
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x)<arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        /*private void heapify(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx = left;
            }
            if (right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(arr.get(i), arr.get(minIdx));
                arr.set(arr.get(minIdx), temp);

                heapify(minIdx);
            }
        }
        public int remove(){
         int data = arr.get(0);

         //step1 - swap first & last
            int temp = arr.get(0);
            arr.set(arr.get(0), arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

         //step2 - delete last
            arr.remove(arr.size()-1);

         //step3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    */
}
