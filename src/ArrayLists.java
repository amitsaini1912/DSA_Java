import java.util.ArrayList;

public class ArrayLists {

    //SWAP OF TWO NUMBERS IN A ARRAYLIST
    public static void swap(ArrayList list, int idx1, int idx2){
        int temp = (int) list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }


    //CONTAINER WITH MOST WATER PROBLEM WITH TWO POINTR APPRAOCH
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp<rp){
            //calculate water
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp-lp;
            int currWater = ht*width;
            maxWater = Math.max(currWater, maxWater);
            //update pointer
            if(height.get(lp)<height.get(rp))
                lp++;
            else
                rp--;
        }
        return maxWater;
    }



    //PAIR SUM PROBLEM FOR SORTED ARRAYLIST
    public static boolean isPairSum1(ArrayList<Integer> list,int target){
        //BRUTE FORCE APPROACH
        /*int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
               if (list.get(i) + list.get(j) == target){
                   return true;
               }
            }
        }
        return false;*/
        //TWO POINTER APPROACH
        int lp = 0;
        int rp = list.size()-1;

        while(lp != rp){
            int sum = list.get(lp)+list.get(rp);
            if(sum == target){
                return true;
            }if (sum < target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }


    //PAIR SUM PROBLEM FOR SORTED & ROTATED ARRAYLIST
    public static boolean isPairSum2(ArrayList<Integer> list, int target){
        int n = list.size();

        int bp = -1; //bracking point
        for (int i = 0; i < n; i++) {
            if (list.get(i)>list.get(i+1)) {
                bp = i;
                break;
            }
        }

        int lp = bp+1;
        int rp = bp;
        while(lp!=rp){
            if (list.get(lp)+list.get(rp)==target)
                return true;
            if (list.get(lp)+list.get(rp)<target)
                lp = (lp+1)%n;
            else
                rp = (n+rp-1)%n;
        }
        return false;
    }

    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        System.out.println(list);

        System.out.println(storeWater(list));

//        swap(list, 1,3);
//        System.out.println(list);

//        System.out.println(isPairSum2(list, 100));

    }
}
