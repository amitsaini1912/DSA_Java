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


    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBootom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
