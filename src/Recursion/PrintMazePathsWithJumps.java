package Recursion;
import java.util.*;

public class PrintMazePathsWithJumps {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(0,0,n-1,m-1,"");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc)
        {
            System.out.println(psf);
            return;
        }
        if(sr > dr || sc > dc)
        {
            return;
        }

        for(int i = 1 ; sc + i <= dc ; i++) {
            printMazePaths(sr, sc + i, dr, dc, psf + "h" + i);
        }

        for(int i = 1 ; sr + i <= dr  ; i++) {
            printMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
        }

        for(int i = 1 ; sr + i <= dr  && sc + i <= dc ; i++) {
            printMazePaths(sr + i, sc + i, dr, dc, psf + "d"+ i);
        }
    }
}

/*
In:
3
3

Out:
h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1
h2v1v1
h2v2
v1h1h1v1
v1h1v1h1
v1h1d1
v1h2v1
v1v1h1h1
v1v1h2
v1d1h1
v2h1h1
v2h2
d1h1v1
d1v1h1
d1d1
d2
*/