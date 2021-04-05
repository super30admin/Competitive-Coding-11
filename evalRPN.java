// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class Solution {
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> s = new Stack();
        String operators = "/*+-";
        
        for(String token : tokens) {
            
            if(operators.contains(token)) {
                int y = s.pop();
                int x = s.pop();
                if(token.equals("*")) {
                    s.push(x*y);
                } 
                else if(token.equals("+")) {
                    s.push(x+y);
                }
                else if(token.equals("-")) {
                    s.push(x-y);
                }
                else {
                    s.push(x/y);
                } 
            }
            else {
                
                // it is a number
                s.push(Integer.valueOf(token));                
                
            }
        }
        
        return s.pop();
    }
    
    
}

