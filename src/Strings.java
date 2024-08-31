public class Strings {

    //Check wheather a string palindrome or not
    public static boolean isPalindrome(String name){
        for(int i=0; i<name.length()/2; i++){
            if(name.charAt(i) != name.charAt(name.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    //Shortest Path Find?
    public static float pathFinder(String str){
        int x=0, y=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'N')
                y +=1;
            if(str.charAt(i) == 'E')
                x +=1;
            if(str.charAt(i) == 'S')
                y -=1;
            if(str.charAt(i) == 'W')
                x -=1;
        }
        int x2 = x*x, y2 = y*y;
        return (float)Math.sqrt(x2+y2);

    }

    public static void main(String[] args){
        String name = "EENNNWWS";
        System.out.println(pathFinder(name));
    }

}
