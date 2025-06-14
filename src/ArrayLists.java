import java.util.ArrayList;

public class ArrayLists {

    //SWAP OF TWO NUMBERS IN A ARRAYLIST
    public static void swap(ArrayList list, int idx1, int idx2){
        int temp = (int) list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }


    //PAIR SUM PROBLEM
    public static boolean isPairSumAvailable(ArrayList<Integer> list,int target){
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
               if (list.get(i) + list.get(j) == target){
                   return true;
               }
            }
        }
        return false;
    }

    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        System.out.println(list);

//        swap(list, 1,3);
//        System.out.println(list);

        System.out.println(isPairSumAvailable(list, 14));

    }
}
