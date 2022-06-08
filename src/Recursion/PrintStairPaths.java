package Recursion;
import java.util.*;

public class PrintStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        printStairPaths(num,"");
    }

    public static void printStairPaths(int n, String path) {
        if(n == 0)
        {
            System.out.println(path);
            return;
        }
        if(n < 0)
        {
            return;
        }

        printStairPaths(n-1,path+1);
        printStairPaths(n-2,path+2);
        printStairPaths(n-3,path+3);
    }
}

/*
In: 3
Out:
111
12
21
3
*/