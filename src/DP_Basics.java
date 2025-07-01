public class DP_Basics {

    //Dynamic Programing: Fibonacci Series Using Recursion Memoization
    public static int fib(int n, int[] dp){
        if (n==0 || n==1) //Base case - fibonacci of 1&0 is 1&0.
            return n;

        if (dp[n]!=0){ //fibonacci is already calculated
            return dp[n];
        }

        dp[n] = fib(n-1, dp) + fib(n-2, dp); //Recursion with memoization(Storing Recursive solution)
        return dp[n];
    }


    public static void main(String args[]){

        int n = 5;
        int dp[] = new int[n+1];
        System.out.println(fib(n, dp));
    }

}
