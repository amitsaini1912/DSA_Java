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

    //DYNAMIC PROGRAMING: 0-1 KNAPSACK USING TABULATION (Bottom Up) - O(n*W)
    public static int knapsackT(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; //base case - Ist Row zero
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; //base case - Ist Col zero
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) { // i=val idx & j=W
                int v = val[i-1]; //ith item val
                int w = wt[i-1];  // ith item weight
                if (w<=j){ // Valid
                    int incProfit = v + dp[i-1][j-w]; // j is W and w is weight of nth item
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else {  //Not valid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }


    //DYNAMIC PROGRAMING: TARGET SUM SUBSETS - TABULATION (Bottom Up)
    public static boolean targetSumSubsets(int val[], int sum){
        int n = val.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for (int i = 0; i < dp.length; i++) {  //java assign by default false at every idx
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][0] = true;
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int v = val[i-1];
                if (v<=j && dp[i-1][j-v]==true) //valid - include
                    dp[i][j] = true;
                else if (dp[i-1][j] == true) //invalid - exclude
                    dp[i][j] = true;
            }
        }

        return dp[n][sum];
    }

    //DYNAMIC PROGRAMING: UNBOUNDED KNAPSACK - TABULATION (Bottom Up)
    public static int unBoundedKnapsackT(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; //base case - Ist Row zero
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; //base case - Ist Col zero
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) { // i=val idx & j=W
                int v = val[i-1]; //ith item val
                int w = wt[i-1];  // ith item weight
                if (w<=j){ // Valid
                    int incProfit = v + dp[i][j-w]; // j is W and w is weight of nth item
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else {  //Not valid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }


    //DYNAMIC PROGRAMING: LCS (LONGEST COMMON SUBSEQUENCE) - RECURSION -> O(2^N)
    public static int lcsR(String str1, String str2, int n, int m){
        if(n==0 || m==0)
            return 0;

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return lcsR(str1, str2, n-1, m-1) + 1;
        }else {
            int ans1 = lcsR(str1, str2, n-1, m);
            int ans2 = lcsR(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }


    //DYNAMIC PROGRAMING: LCS (LONGEST COMMON SUBSEQUENCE) - MEMOIZATION -> O(n*m)
    public static int lcsM(String str1, String str2, int n, int m, int dp[][]){
        if(n==0 || m==0)
            return 0;

        if (dp[n][m]!=-1)
            return dp[n][m];

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m] = lcsM(str1, str2, n-1, m-1, dp) + 1;
        }else {
            int ans1 = lcsM(str1, str2, n-1, m, dp);
            int ans2 = lcsM(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }


    //DYNAMIC PROGRAMING: LCS (LONGEST COMMON SUBSEQUENCE) - TABULATION -> O(n*m)
    public static int lcsT(String str1, String str2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        //base case initialization in table
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0)
                    dp[i][j] = 0;
                if (j==0)
                    dp[i][j] = 0;
            }
        }

        //table filling in bottom up manner - small to large
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){//bottom up - traversing from start of strings
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        //final answer at n*m idx
        return dp[n][m];
    }


    public static void main(String args[]){
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcsT(str1, str2, n, m));
    }

}
