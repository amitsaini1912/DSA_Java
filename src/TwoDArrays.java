import java.util.Scanner;

public class TwoDArrays {
    //DIAGONAL SUM
    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for(int i=0; i<matrix.length; i++){
            //PDS
            sum += matrix[i][i];
            //SDS
            if( i!= matrix.length-1-i ){
                sum += matrix[i][matrix.length-1-i];
            }
        }


//        int n = matrix.length;
//        for(int i=0; i< n; i++){
//            for(int j=0; j<matrix[0].length; j++){
//                if(i==j){
//                    sum += matrix[i][j];
//                } else if (i+j == matrix.length -1) {
//                    sum += matrix[i][j];
//                }
//            }
//        }
//        if(n%2 != 0){
//            int idx = n%2;
//            sum -= matrix[idx][idx];
//        }
        return sum;
    }

    //SPIRAL MATRIX
    public static void spiralMatrix(int matrix[][]){
        int n = matrix[0].length;
        int startRow = 0, startCol = 0, endRow = n-1, endCol = n-1;

        while (startRow <= endRow && startCol <= endCol){
            //Top
            for(int j=startCol; j<=endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }
            //Right
            for(int i=startRow+1; i<=endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }
            //Bottom
            for(int j=endCol-1; j>=startCol; j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            //Left
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            };

            startRow ++ ;
            startCol ++ ;
            endRow -- ;
            endCol -- ;
        }
    }

    //PRINT 2D Array
    public static void print2DArray(int arr[][]){
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int arr[][] = { {1 ,2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}, {13,14,15,16}};
        int newArr[][] = { {1 ,2, 3}, {4,5,6}, {7,8,9} };

        //spiralMatrix(arr);
        System.out.println(diagonalSum(newArr));

//        int newArr[][] = new int[3][3];
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter the elements one by one ");
//        for(int i=0; i<newArr.length; i++){
//            for(int j=0; j< newArr[0].length; j++){
//                newArr[i][j] = sc.nextInt();
//            }
//        }

    }
}
