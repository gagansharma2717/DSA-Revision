package Recursion;

import java.util.Scanner;

public class PowerLogarthimic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int res = powerLogarthimic(x,n);
        System.out.println(res);
    }

    private static int powerLogarthimic(int x, int n) {
        if( n == 0)
        {
            return 1;
        }

        int xpnb2 = powerLogarthimic(x,n/2);

        int xpn = xpnb2 * xpnb2;

        if(n % 2 == 1 )
        {
            xpn *= x;
        }

        return xpn;
    }
}
//O(logn)