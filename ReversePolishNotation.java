// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

public class ReversePolishNotation {
    
    class Solution {
        public int evalRPN(String[] tokens) {
    
            Stack<String> st = new Stack<>();
    
            for (String str : tokens){
                if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                    int n1 = Integer.parseInt(st.pop());
                    int n2 = Integer.parseInt(st.pop());
                    if (str.equals("+")){
                        st.push(String.valueOf(n1+n2));
                    } else if (str.equals("-")){
                        st.push(String.valueOf(n2-n1));
                    } else if (str.equals("*")){
                        st.push(String.valueOf(n1*n2));
                    } else if (str.equals("/")){
                        st.push(String.valueOf(n2/n1));
                    }  
                } else {
                    st.push(str);
                }
            }
            return Integer.parseInt(st.pop());
            
        }
    }
