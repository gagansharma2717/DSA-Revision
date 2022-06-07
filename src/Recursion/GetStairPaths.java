package Recursion;
import java.util.*;

public class GetStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        ArrayList<String> res = getStairPaths(num);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
//        Positive Base Case
        if(n == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
//        Negative Base Case
        if(n < 0)
        {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> res = new ArrayList<>();

        ArrayList<String> tempres1 = getStairPaths(n-1);
        for(String s : tempres1)
        {
            res.add(1 + s);
        }
        ArrayList<String> tempres2 = getStairPaths(n-2);
        for(String s : tempres2)
        {
            res.add(2 + s);
        }
        ArrayList<String> tempres3 = getStairPaths(n-3);
        for(String s : tempres3)
        {
            res.add(3 + s);
        }
        return res;
    }
}
