// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        
        if(k == num.length()) return "0";
        
        Stack<Character> s = new Stack<>();
        
        int i = 0;
        
        while(i < num.length()) {
            
            char c = num.charAt(i);
            while(k > 0 && !s.isEmpty() && c < s.peek()) {
                s.pop();
                k--;
            }
            
            s.push(c);
            i++;
        }
        
        while(k > 0) {
            s.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        
        while(sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.reverse().toString();
    }
}