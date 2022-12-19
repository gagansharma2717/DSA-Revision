package Stack_Queues;
import java.util.*;
public class Balanced_Brackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> stk = new Stack<>();

        for(int i = 0 ; i < str.length(); i++) {
            char ch = str.charAt(i);
            // For opening push in stk operators and operand are ignored
            if (ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            } else if (ch == ')') {
                // For closing bracket we will check if stack is not empty and also stack top/peek has corresponding opening bracket if any of condition is
                // false then print false and return else pop corresponding opening bracket from stack in handleClosing Method
                boolean val =  handlingClosing(stk, '(');
                if(!val){
                    System.out.println(val);
                    return;
                }
            } else if (ch == '}'){
                boolean val =  handlingClosing(stk, '{');
                if(!val){
                    System.out.println(val);
                    return;
                }
            }else if(ch == ']'){
                boolean val =  handlingClosing(stk, '[');
                if(!val){
                    System.out.println(val);
                    return;
                }
            }

        }

        // if stack has some data it means open brackets are more then it is not balanced else if stack is empty means it is balanced
        if(stk.size() == 0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    public static boolean handlingClosing(Stack<Character> stk, char correspondingOpeningChar){
        if(stk.size() == 0){
            return false;
        }else if(stk.peek() != correspondingOpeningChar){
            return false;
        }
            stk.pop();
            return true;
    }
}
/*
e.g.
        [(a + b) + {(c + d) * (e / f)}] -> true
        [(a + b) + {(c + d) * (e / f)]} -> false
        [(a + b) + {(c + d) * (e / f)} -> false
        ([(a + b) + {(c + d) * (e / f)}] -> false
*/


