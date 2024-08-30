public class Strings {

    //Check wheather a string palindrome or not
    public static boolean isPalindrome(String name){
        for(int i=0; i<name.length()/2; i++){
            if(name.charAt(i) == name.charAt(name.length()-i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String name = "racecar";
        isPalindrome(name);
    }

}
