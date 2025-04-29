
public class ArrayList {
    public static void main(String[] args){
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.set(0,2);
        list.set(1,6);
        list.set(2,8);

        System.out.println(list);
        //System.out.println(findMax(list));
    }


    //Find Maximum in given ArrayList
    public static int findMax(java.util.ArrayList<Integer> list){
         int n = list.size();
         int max = Integer.MIN_VALUE;
         for(int i=0; i<n-1; i++){
             if(list.get(i)>max){
                 max = list.get(i);
             }
         }
         return max;
    }
}
