package Recursion;
import java.util.*;

public class GetSubSequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }
    // sub-array is same as substring
    // subset is same as subsequence It can be non-contiguous.
    public static ArrayList<String> gss(String str) {
//        Base Case
        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

//        Faith
        ArrayList<String> sres = gss(str.substring(1));

        ArrayList<String> res = new ArrayList<>();
//        Adding Blank
        for(String s : sres)
        {
            res.add("" + s);
        }
//        Adding first character
        for(String s : sres)
        {
            res.add(str.charAt(0) + s);
        }

        return res;
    }
}

/*
Sample Input
abc

Sample Output
[, c, b, bc, a, ac, ab, abc]
*/
