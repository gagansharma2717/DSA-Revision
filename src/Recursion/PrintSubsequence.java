package Recursion;
import java.util.*;

public class PrintSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printSS(str,"");
    }

    public static void printSS(String str, String ans) {
        if(str.equals(""))
        {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);

        printSS(str.substring(1),ans+ch);
        printSS(str.substring(1),ans);

    }
}

/*
In : yvTA
Out :
yvTA
yvT
yvA
yv
yTA
yT
yA
y
vTA
vT
vA
v
TA
T
A
*/