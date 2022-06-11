package Recursion;
import java.util.*;

public class KnightsTour {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess,r,c,1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0)
        {
            return;
        }

        if(move == chess.length * chess.length)
        {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
        }

        chess[r][c] = move;

        printKnightsTour(chess, r-2, c+1, move + 1);
        printKnightsTour(chess, r-1, c+2, move + 1);
        printKnightsTour(chess, r+1, c+2, move + 1);
        printKnightsTour(chess, r+2, c+1, move + 1);
        printKnightsTour(chess, r+2, c-1, move + 1);
        printKnightsTour(chess, r+1, c-2, move + 1);
        printKnightsTour(chess, r-1, c-2, move + 1);
        printKnightsTour(chess, r-2, c-1, move + 1);

        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}


/*
In:
5
2
0

Out:
25 2 13 8 23
12 7 24 3 14
1 18 15 22 9
6 11 20 17 4
19 16 5 10 21

19 2 13 8 21
12 7 20 3 14
1 18 15 22 9
6 11 24 17 4
25 16 5 10 23

25 2 13 8 19
12 7 18 3 14
1 24 15 20 9
6 11 22 17 4
23 16 5 10 21

19 2 13 8 25
12 7 18 3 14
1 20 15 24 9
6 11 22 17 4
21 16 5 10 23

21 2 17 8 19
12 7 20 3 16
1 22 13 18 9
6 11 24 15 4
23 14 5 10 25

23 2 17 8 25
12 7 24 3 16
1 22 13 18 9
6 11 20 15 4
21 14 5 10 19

25 2 17 8 23
12 7 24 3 16
1 18 13 22 9
6 11 20 15 4
19 14 5 10 21

19 2 17 8 21
12 7 20 3 16
1 18 13 22 9
6 11 24 15 4
25 14 5 10 23

25 2 15 8 19
16 7 18 3 14
1 24 11 20 9
6 17 22 13 4
23 12 5 10 21

19 2 15 8 25
16 7 18 3 14
1 20 11 24 9
6 17 22 13 4
21 12 5 10 23

21 2 15 8 19
16 7 20 3 14
1 22 11 18 9
6 17 24 13 4
23 12 5 10 25

23 2 15 8 25
16 7 24 3 14
1 22 11 18 9
6 17 20 13 4
21 12 5 10 19

23 2 13 8 21
14 7 22 3 12
1 24 9 20 17
6 15 18 11 4
25 10 5 16 19

21 2 13 8 23
14 7 22 3 12
1 20 9 24 17
6 15 18 11 4
19 10 5 16 25
*/