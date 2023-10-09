//https://leetcode.com/problems/remove-k-digits/
// Time Complexity :O(n)  
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public String removeKdigits(String num, int k) {
        
        int n = num.length();
        if(n == k) {
            return "0";
        }
        int count = k;
        Stack<Integer> st = new Stack<>();
        

        for(int i=0;i<n;i++) {
            int ch=num.charAt(i)-'0';
            while(!st.isEmpty() && 
                   st.peek() > ch && count > 0) {
                st.pop();
                count--;
            }
            st.push(ch);
        }
        StringBuilder result = new StringBuilder();
        
        while(count > 0) {
            st.pop();
            count--;
        }
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();
        while(result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
        
}
