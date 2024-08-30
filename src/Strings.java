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

    public static void main(String[] args){
        String name = "racecar";
        System.out.println(isPalindrome(name));
    }

}
