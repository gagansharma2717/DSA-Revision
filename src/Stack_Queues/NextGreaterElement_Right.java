package Stack_Queues;
import java.util.*;
public class NextGreaterElement_Right {
    public static void display(int[] ans){
        StringBuilder sb = new StringBuilder();

        for(int val : ans){
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int val : arr){
            arr[val] = scn.nextInt();
        }

        int [] result = solve(arr);
        display(result);

    }

    private static int[] solve(int[] arr) {

    }
}
/*
Sample Input
5
5
3
8
-2
7

Sample Output
8
8
-1
7
-1

*/
