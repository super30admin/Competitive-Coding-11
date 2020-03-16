// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>(); 
        /* 
            if token is operator, perform the operation by poping operands from stack
            else add the operand to the stack
        */
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") 
               || token.equals("/") || token.equals("*")) {
                int b = st.pop(); // 2nd operand
                int a = st.pop(); // 1st operand
                // based on the type of token perform operation
                switch (token) {
                    case "+": st.push(a+b);
                        break;
                    case "-": st.push(a-b);
                        break;
                    case "/": st.push(a/b);
                        break;
                    case "*": st.push(a*b);
                        break;
                }
            }
            else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}


