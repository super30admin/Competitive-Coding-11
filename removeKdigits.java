// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        
        if (k == num.length()) {
            return "0";
        }
        
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < num.length(); i++) {
            char s = num.charAt(i);
            
            while (!st.isEmpty() && k > 0 && st.peek() > s) {
                st.pop();
                k--;
            }
            
            st.push(s);
        }
        
        for (int i = 0; i < k; i++) {
            st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
