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


    //STOCK SPAN PROBLEM USING STACK [TC->O(n)]
    public static void stackSpan(int stocks[], int span[]){
        Stack s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice>stocks[(int) s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i;
            }else{
                int prevHigh = (int) s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }


    //NEXT GREATER ELEMENT PROBLEM
    public static void nextGreater(int arr[], int nextGreater[]){
        int n = arr.length;
        Stack s = new Stack<>();
        nextGreater[n-1] = -1;
        s.push(n-1);

        for (int i = n-2; i >= 0; i--) {
            int currElement = arr[i];
            while (!s.isEmpty() && currElement>arr[(int)s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[(int)s.peek()];
            }
            s.push(i);
        }
    }


    //CHECK GIVEN PARENTHESES STRING IS VALID OR NOT
    public static boolean validParentheses(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //Move opening parentheses in stack
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }
            //if closing parentheses comes compiar with top
            else {
                if (s.isEmpty())
                    return false;
                if ( (ch==')' && (char)s.peek()=='(')
                        || (ch=='}' && (char)s.peek()=='{')
                        || (ch==']' && (char)s.peek()=='[')){
                    s.pop();
                }else
                    return false;
            }
        }
        if (s.isEmpty())
            return true;
        else
            return false;
    }


    //CHECK WHETHER DUPLICATE PARENTHESES PRSENT OR NOT
    public static boolean duplicateParentheses(String str){
        Stack <Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //if closing parentheses comes compiar with top and pop
                if (ch==')') {
                    int count = 0;
                    while (s.peek() != '(') {
                        s.pop();
                        count++;
                    }
                    if (count < 1) //duplicate found
                        return true;
                    else
                        s.pop(); //pop '(' also from stack
                }else {
                    s.push(ch); //Move opening backets, operents and operators in stack
                }

        }
        return false;
    }


    public static void main(String args[]){
        String str = "((a+b)-(d*c))";
        System.out.println(duplicateParentheses(str));
    }
}
