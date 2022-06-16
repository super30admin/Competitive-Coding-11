// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for(char ch: num.toCharArray()) {
            int n = ch - '0';
            
            while(!stack.isEmpty() && n < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        
        for(int i = 0; i < k; i++)
            stack.pop();
        
        StringBuilder result = new StringBuilder();
        
        boolean leadingZeros = true;
        for(int n: stack) {
            if(n == 0 && leadingZeros == true) continue;
            leadingZeros = false;
            
            result.append(n);
        }
        
        return result.toString().length() == 0 ? "0" : result.toString();
    }
}