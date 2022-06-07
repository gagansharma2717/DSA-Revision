package Recursion;
import java.util.*;

public class GetMazeWithJumps {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> res = getMazePaths(0,0,n-1,m-1);
        System.out.println(res);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(sr > dr || sc > dc)
        {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> result = new ArrayList<>();

        for(int i = 1 ; sc + i <= dc ; i++) {
            ArrayList<String> hpaths = getMazePaths(sr, sc + i, dr, dc);
            for (String s : hpaths) {
                result.add("h"+ i + s);
            }
        }
        for(int i = 1 ; sr + i <= dr ; i++) {
            ArrayList<String> vpaths = getMazePaths(sr + i, sc, dr, dc);
            for (String s : vpaths) {
                result.add("v" + i + s);
            }
        }
        for(int i = 1 ; sr + i <= dr && sc + i <= dc; i++) {
            ArrayList<String> dpaths = getMazePaths(sr + 1, sc + 1, dr, dc);
            for (String s : dpaths) {
                result.add("d" + i + s);
            }
        }
        return result;
    }
}
