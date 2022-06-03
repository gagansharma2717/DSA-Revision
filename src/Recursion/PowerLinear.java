package Recursion;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int res = powerLinear(x,n);
        System.out.println(res);
    }

    private static int powerLinear(int x, int n) {
        if(n == 0)
        {
            return 1;
        }

        int xpn = powerLinear(x,n-1) * x;

        return xpn;
    }
}

//O(n)
