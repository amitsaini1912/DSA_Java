
public class Backtacking {

    //BACKTRACKING ON ARAAYS
    public static void changArr(int arr[], int i, int val){
       //base case
        if(i==arr.length){
            printArr(arr);
            return;
        }
        //Recursion
        arr[i]=val;
        changArr(arr, i+1, val+1); //function call step
        arr[i]=arr[i]-2;  //Backtacking step
    }

    //PRINT ARRAY FUNCTION
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }


    //FIND SUBSETS PROBLEM
    public static void findSubsets(String str, int i, String ans){
        //base case
        if(i==str.length()){
            System.out.println("<"+ ans + ">");
            return;
        }
        //Recursion
        findSubsets(str, i+1, ans+str.charAt(i)); //yes choice
        findSubsets(str, i+1, ans); //No Choice
    }


    //FIND PERMUTATIONS PROBLEM
    public static void findPermutation(String str, String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //Recursion
        for (int i = 0; i < str.length(); i++) {
           char curr = str.charAt(i);
           //"abcde" => "ab" + "de" = "abde"
           String newStr = str.substring(0,i)+str.substring(i+1);
           findPermutation(newStr, ans+curr);
        }
    }


    //N-QUEENS PROBLEM
    public static boolean isSafe(char board[][], int row, int col){
        //Vertical Up
        for (int i = row-1; i >=0 ; i--) {
            if(board[i][col]=='Q')
              return false;
        }
        //Diagonal left Up
        for (int i = row-1, j = col-1; i >=0 && j>=0 ; i--, j--) {
            if(board[i][j]=='Q')
              return false;
        }
        //Diagonal right Up
        for (int i = row-1, j = col+1; i >=0 && j< board.length ; i-- ,j++) {
            if(board[i][j]=='Q')
              return false;
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("------------ Chess Board -------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    public static void nQueens(char board[][], int row){
         //base case
        if(row== board.length){
            printBoard(board);
            return;
        }
        //run loop on column
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);  //fucn Call
                board[row][j] = 'x';  //Backtacking Step
            }
        }
    }

    public static void main(String args[]){
        //int arr[] = {1,2,3,4,5};
        //changArr(arr,0,1);
        //printArr(arr);

         //String str = "abc";
         //String ans = new String();
         //findPermutation(str, ans);


        int n=4;
        char board[][] = new char[n][n];
        //intialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);
    }
}
