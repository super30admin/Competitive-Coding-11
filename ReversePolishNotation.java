// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

class Solution {
    public int evalRPN(String[] tokens) {
        
        if(tokens == null || tokens.length == 0) return 0;
        
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            
            if(token.equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                
                stack.push(second + first);
            }
            
            else if(token.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                
                stack.push(second - first);
            }
            
            else if(token.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                
                stack.push(second / first);
            }
            
            else if(token.equals("*")) {
                int first = stack.pop();
                int second = stack.pop();
                
                stack.push(second * first);
            } else {
                int digit = Integer.parseInt(token);
                stack.push(digit);
            }
        }
        
        return stack.pop();
    }
}