// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

public class RemoveKDigit {
    
        public String removeKdigits(String num, int k) {
    
            Stack<Character> st = new Stack<>();
            int i =0;
    
            while (i < num.length()){
                while(!st.isEmpty() && k>0 && st.peek() > num.charAt(i)){
                    st.pop();
                    k--;
                }
                st.push(num.charAt(i));
                i++;
            }
    
            while (k>0){
                st.pop();
                k--;
            }
    
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()){
                sb.append(st.pop());
            }
    
            //String result = "";
            //boolean zero = true;
            sb.reverse();
            System.out.println(sb.toString());
            while (sb.length() > 1 && sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }
    
            //return sb.reverse().toString();
            if (sb.toString().equals("")) return "0";
            return sb.toString();
    
        }
    }
