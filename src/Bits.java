public class Bits {

    //Check wheather a number even or odd
    public static boolean isEven(int num){
        int bitMask = 1;
        if((num & bitMask) == 0)
            return true;
        else{
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(isEven(7));
        //System.out.println(5&6);//3=011, 4=100, 5=101, 6=110  7=111,
//        System.out.println(5|6);
//        System.out.println(5^6);
//        System.out.println(~5);
//        System.out.println(~0);
//        System.out.println(~4);
    }
}
