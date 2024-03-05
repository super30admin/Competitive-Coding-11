/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
* 
*/

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int op2 = st.pop();
                int op1 = st.pop();

                st.push(op1 + op2);
            } else if (token.equals("-")) {
                int op2 = st.pop();
                int op1 = st.pop();

                st.push(op1 - op2);
            } else if (token.equals("*")) {
                int op2 = st.pop();
                int op1 = st.pop();

                st.push(op1 * op2);
            } else if (token.equals("/")) {
                int op2 = st.pop();
                int op1 = st.pop();

                st.push(op1 / op2);
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }
}