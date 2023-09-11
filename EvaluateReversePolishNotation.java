package CompetitiveCoding11;

// Time Complexity : O(n)
// Space Complexity : O(n)  -> at the max half of the input array will be in stack;
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++)
        {
            String temp = tokens[i];

            if(temp.equals("+"))
            {
                st.push(st.pop() + st.pop());

            }
            else if(temp.equals("-"))
            {
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 - num2);
            }
            else if(temp.equals("*"))
            {
                st.push(st.pop() * st.pop());
            }
            else if(temp.equals("/"))
            {
                int num2 = st.pop();
                int num1 = st.pop();

                st.push(num1 /num2);
            }
            else{
                st.push(Integer.parseInt(temp));
            }
        }

        return st.pop();
    }
}