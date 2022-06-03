package Recursion;

import java.util.Scanner;

public class MaxOfArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = scn.nextInt();
        }

        int res = maxOfArray(arr,0);
        System.out.println(res);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length)
        {
            return Integer.MIN_VALUE;
        }

        int maxRa = maxOfArray(arr,idx+1);

        int max = Math.max(maxRa,arr[idx]);

        return max;
    }


}
