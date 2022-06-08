package Recursion;
import java.util.*;

public class PrintEncodings {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str,"");
    }

    public static void printEncodings(String str,String out) {
        if(str.length() == 0)
        {
            System.out.println(out);
            return;
        }

        char ch1 = str.charAt(0);
        if(ch1 >= '1' && ch1 <= '9')
        {
//          (ch1 - '0') Converting char to integer and then adding 96 for encoding
            printEncodings(str.substring(1),out+ (char) (ch1 - '0' + 96));
        }

//        To Handle when stringh left with only one character
        if(str.length() > 1) {
//            Extracting first two characters
            String s = str.substring(0, 2);
//            Coverting into integer
            int ch12 = Integer.parseInt(s);
            if (ch12 >= 10 && ch12 <= 26) {
//           (char) (ch12 + 96) To transform integer to alphabets adding Ascii Value of 96 and then transforming into char
                printEncodings(str.substring(2), out + (char) (ch12 + 96));
            }
        }

    }
}


/*
In: 655196
Out : feeaif
feesf
*/