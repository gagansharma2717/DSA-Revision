package Recursion;
import java.util.*;

public class NQueens {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess,"" , 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length)
        {
            System.out.println(qsf + ".");
            return;
        }
        for(int col = 0 ; col < chess.length; col++)
        {
            if(chess[row][col] == 0 && isQueenSafe(chess,row,col)) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isQueenSafe(int[][] chess, int row, int col) {
        // left diagonal up
        for(int i = row-1, j = col-1 ; i >= 0 && j >= 0 ; i-- ,j--){
            if(chess[i][j] == 1)
            {
                return false;
            }
        }

        //vertical up
        for(int i = row-1, j = col ; i >= 0; i--){
            if(chess[i][j] == 1)
            {
                return false;
            }
        }

        //right diagonal up
        for(int i = row-1, j = col+1 ; i >= 0 && j < chess[0].length ; i-- ,j++){
            if(chess[i][j] == 1)
            {
                return false;
            }
        }
        return true;
    }
}

/*
In: 4
Out: 0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
*/