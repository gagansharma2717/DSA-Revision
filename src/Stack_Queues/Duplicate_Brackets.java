package Stack_Queues;
import java.util.*;
public class Duplicate_Brackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> stk = new Stack<>();

        /*for(int i = 0 ; i  < str.length(); i++){
            int count = 0 ;
            Character ch = str.charAt(i);

            if(ch == ')'){

                while(stk.peek() != '('){
                    count++;
                    stk.pop();
                }
                stk.pop(); // Poped Opening Bracket

                if(count == 0){
                    // here count 0 means string m closing bracket aane pr stack ke top pr directly opening bracket tha
                    // instead of some operator or operand that means there is a duplicacy of brackets
                    System.out.println("true");
                    return;
                }
            }else{
                stk.push(ch);
            }
        }
        System.out.println(false);
        */

        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                // if we are getting opening bracket directly at stack top in front of closing bracket of string
                // without any operator or operand it means there are duplicate brackets exits so
                // simply print true and return
                if(stk.peek() == '('){
                    System.out.println(true);
                    return;
                }else{
                    // else remove operator or operands from stack
                    while(stk.peek() != '('){
                        stk.pop();
                    }
                    // also pop opening bracket
                    stk.pop();
                }
            }else{
                stk.push(ch);
            }
        }
        System.out.println(false);
    }
}

/*
Example
Sample Input
(a + b) + ((c + d))
((a+b) + (c + d))
Sample Output
true - redundant duplicate brackets exists ((c+d))
false
*/
