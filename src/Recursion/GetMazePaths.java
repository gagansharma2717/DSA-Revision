package Recursion;
import java.util.*;

public class GetMazePaths {
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
        // Positive Base Case
        if(sr == dr && sc == dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
//        Negative Base case
        if(sr > dr || sc > dc)
        {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> hpaths= getMazePaths(sr,sc+1,dr,dc );
        for(String s : hpaths)
        {
            result.add("h" + s);
        }
        ArrayList<String> vpaths = getMazePaths(sr+1,sc,dr,dc );
        for(String s : vpaths)
        {
            result.add("v" + s);
        }
        return result;
    }
}

/*
3
3
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
*/