public class Main {

    public static int maxNumber(int arr[]){
        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i] > maxNum){
                maxNum = arr[i];
            }
        }
        return maxNum;
    }
    public static int minNumber(int arr[]){
        int minNum = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < minNum){
                minNum = arr[i];
            }
        }
        return minNum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,8,4,5};

        System.out.println(minNumber(arr));
        System.out.println(maxNumber(arr));
    }
}