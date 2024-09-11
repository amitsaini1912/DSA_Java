import java.util.Scanner;

public class TwoDArrays {

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

        spiralMatrix(arr);

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
