// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use a stack to maintain digits in increasing order, removing larger digits when a smaller digit comes and `k > 0`.
// If k digits haven't been removed, remove from the end of the stack.
// Make the final number from the stack while skipping leading zeroes, return "0" if the result is empty.

import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(char c:num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k-->0){
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (char n:st) {
            if (sb.length() == 0 && n == '0') continue;
            sb.append(n);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}