//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.Stack;

class Evaluate_RPN_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n1, n2;
        for(String str : tokens)
        {
            if(st.size() >= 2 && str.equals("*"))
            {
                n1 = st.pop();
                n2 = st.pop();
                st.push(n2 * n1);
            }
            else if(st.size() >= 2 && str.equals("/"))
            {
                n1 = st.pop();
                n2 = st.pop();
                st.push(n2 / n1);
            }
            else if(st.size() >= 2 && str.equals("+"))
            {
                n1 = st.pop();
                n2 = st.pop();
                st.push(n2 + n1);
            }
            else if(st.size() >= 2 && str.equals("-"))
            {
                n1 = st.pop();
                n2 = st.pop();
                st.push(n2 - n1);
            }
            else st.push(Integer.parseInt(str));
        }
        return st.pop();
    }
    public static void main(String[] args)
    {
    	Evaluate_RPN_150 obj = new Evaluate_RPN_150();
    	String[] str = {"2", "1", "+", "3", "*"};
    	System.out.println(obj.evalRPN(str));
    	
    }
}
