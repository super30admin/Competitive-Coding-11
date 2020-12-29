//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.Stack;
class Remove_K_Digits_402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k)
            return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        while(k > 0)
        {
            st.pop();
            k--;
        }
        while(!st.isEmpty())
                sb.append(st.pop());
        
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
    	Remove_K_Digits_402 obj = new Remove_K_Digits_402();
    	String str = "1439999";
    	System.out.println(obj.removeKdigits(str, 3));
    	
    }
}
