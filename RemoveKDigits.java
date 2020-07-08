// Time Complexity : O(number length)
// Space Complexity : O(number length)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        if(len<=k)
            return "0";
        for(Character ch:num.toCharArray()){
            int num1 = ch-'0';
            while(!st.isEmpty() && num1<st.peek() && --k>=0)
                st.pop();
            
            st.push(num1);
        }
        
         while(!st.isEmpty() && --k>=0)
             st.pop();
        
        while(!st.isEmpty())
            sb.insert(0,st.pop());
        
        while(sb.length()>0 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.length()>0?sb.toString():"0";
            
    }
}
