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

    //Dynamic Programing: Fibonacci Series Using Iterative Tabulation
    public static int fibT(int n){
        //step1 Initialization
        int dp[] = new int[n+1];
        dp[0] = 0;  //that is for c++ bcz in java it will automatic initialize all idx with 0
        dp[1] = 1;

        //step2 - Calculations (Filling)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    //DYNAMIC PROGRAMING: CLIMBING STAIRS - RECURSION MEMOIZATION
    public static int climbStair(int n, int[] dp){
        if (n==0 || n==1){
           return 1;
        }
        if (n == 2) { //Extra pre-calc if u want include otherwise not
            return 2;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n] = climbStair(n-1, dp) + climbStair(n-2, dp);
        return dp[n];
    }


    public static void main(String args[]){

        int n = 5;
        int dp[] = new int[n+1];
        System.out.println(climbStair(n, dp));
    }

}
