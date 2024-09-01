public class SortingAlgo {

    //BUBBLE SORT ALGO
    public static void bubbleSort(int arr[]){
        for(int turn=0; turn<arr.length-1; turn++){
            for(int j=0; j<arr.length-1-turn; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args){
        int arr[] = {9,8,6,4,5,2,1};
        bubbleSort(arr);
    }
}
