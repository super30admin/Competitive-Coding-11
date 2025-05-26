// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use a stack to evaluate the expression by each token.
// Push numbers to the stack, for operators, pop two numbers, apply the operation push the result to the stack.
// Result is the only element left in the stack at the end.

import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        Set<String> set=new HashSet<>();
        set.add("+");set.add("-");set.add("*");set.add("/");
        for(String s:tokens){
            if(set.contains(s)){
                int num1=st.pop();
                int num2=st.pop();
                if(s.equals("+")) st.push(num2+num1);
                else if(s.equals("-")) st.push(num2-num1);
                else if(s.equals("*")) st.push(num2*num1);
                else if(s.equals("/")) st.push(num2/num1);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
