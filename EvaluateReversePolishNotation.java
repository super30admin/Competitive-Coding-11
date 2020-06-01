// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a;
        int b;
        for(String s : tokens){
            if(s.equals("+")){
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
            } else if(s.equals("-")){
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if(s.equals("*")){
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
            } else if(s.equals("/")){
                b = stack.pop();
                a = stack.pop();
                stack.push((int)a / b);
            } else{
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
