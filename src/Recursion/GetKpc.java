package Recursion;
import java.util.*;

public class GetKpc {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = getKPC(str);
        System.out.println(res);
    }
    static String[] keypad = {".;", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        // Faith
        ArrayList<String> tempres =  getKPC(str.substring(1));
        ArrayList<String> result = new ArrayList<>();
        char ch = str.charAt(0);

        for(int i = 0 ; i < keypad[ch - '0'].length(); i++)
        {
            char letter = keypad[ch-'0'].charAt(i);

            for(String s : tempres)
            {
                result.add(letter + s);
            }
        }
        return result;
    }
}

/*
Sample Input
78

Sample Output
[tv, tw, tx, uv, uw, ux]
*/