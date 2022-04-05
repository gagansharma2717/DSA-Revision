package Graph;

import java.io.*;
import java.util.*;

public class numberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0 ;
//        Basically Iss Question Mai We meed to find number of connected components.
//        So, we will check connected components from every index and maintain its counts.
//        At last we will print the count

        for(int i = 0 ; i < arr.length; i++)
        {
            for(int j = 0 ; j < arr[0].length; j++)
            {
//              Condition to make call is
//              Ek toh vo land hona chahiye and second is visited nhi hona chahiye
                if(arr[i][j] == 0 && visited[i][j] == false)
                {
                    dfs(arr,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static void dfs(int[][] arr, int row , int col , boolean[][] visited )
    {
        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 1
                || visited[row][col] == true) {

            return;
        }

        visited[row][col] = true;

        dfs(arr,row + 1 , col,visited);
        dfs(arr,row - 1 , col,visited);
        dfs(arr,row, col + 1,visited);
        dfs(arr,row, col - 1,visited);

    }

}

/*

Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

Sample Output
3

Time Complexity:
O(4*n2) which is simply written as O(n2) This is because each cell of the matrix is processed at most 4 times.
For Example, a particular cell can call a cell to its north, east, west or south.

Space Complexity:
O(n2) Since a 2D array is used to store "visited" elements hence the space complexity is quadratic.

*/