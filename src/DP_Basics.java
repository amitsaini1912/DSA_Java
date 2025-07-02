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


    //DYNAMIC PROGRAMING: CLIMBING STAIRS - ITERARTION TABULATION
    public static int climbStairT(int n){
        //step1 Initialization
        int dp[] = new int[n+1];
        dp[0] = 1;

        //step2 - Calculations (Filling)
        for (int i = 1; i <= n; i++) {
            if (i==1)
               dp[i] = dp[i-1] + 0;
            else
                dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }



    //DYNAMIC PROGRAMING: 0-1 KNAPSACK USING RECURSION - O(2^N)
    public static int knapsack(int val[], int wt[], int W, int n){
        if(W==0 || n==0){ //n is idx of val array - traversing from last
            return 0;
        }

        if(wt[n-1]<=W){ //item can be added in knapsack
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1); //include condition - (1)
            int ans2 = knapsack(val, wt, W, n-1); // exclude condition - (0)
            return Math.max(ans1,ans2);
        }else { //item not added in knapsack
            return knapsack(val, wt, W, n-1);
        }
    }

    //DYNAMIC PROGRAMING: 0-1 KNAPSACK USING MEMOIZATION - O(n*W)
    public static int knapsackM(int val[], int wt[], int W, int n, int dp[][]){
        if(W==0 || n==0){ //n is idx of val array - traversing from last
            return 0;
        }

        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        if(wt[n-1]<=W){ //item can be added in knapsack
            int ans1 = val[n-1] + knapsackM(val, wt, W-wt[n-1], n-1, dp); //include condition - (1)
            int ans2 = knapsackM(val, wt, W, n-1, dp); // exclude condition - (0)
            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        }else { //item not added in knapsack
            dp[n][W] = knapsackM(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackM(val, wt, W, n, dp));
    }

}
