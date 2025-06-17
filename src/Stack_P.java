import java.awt.*;
import java.util.*;
public class Stack_P {

    //PUSH AT THE BOTTOM OF THE STACK PROBLEM (USING RECURSION)
    public static void pushAtBootom(Stack<Integer>s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBootom(s,data);
        s.push(top);
    }


    //REVERSE A STRING USING STACK
    public static String reverseStr(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }


    //REVERSE A STACK USING RECURSION WITHOUT USING EXTRA SPACE
    public static void reverseStack(Stack<Integer>s){
        if(s.isEmpty()) return;
        int top = s.pop();
        reverseStack(s);
        pushAtBootom(s,top);
    }

    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }
}
