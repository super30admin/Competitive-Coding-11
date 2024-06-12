class RPN {

// Time Complexity : O(N) where N is length of array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


/**
 * Approach:
 * 1. Add each token to stack if token is number. Else pop the the top 2 elements and operate on
 * them and push the result
 */

    public int evalRPN(String[] tokens) {
            
        if(tokens == null || tokens.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        
        for(String s: tokens){
            
            if(operations.contains(s)){
                int first = stack.pop();
                int second = stack.pop();
                
                if(s.equals("+")){
                    stack.push(first + second);
                }
                else if(s.equals("-")){
                    stack.push(second - first);
                }
                else if(s.equals("*")){
                    stack.push(first * second);
                }
                else if(s.equals("/")){
                    stack.push(second / first);
                }
                
            }
            else {
                int num = Integer.parseInt(s);
                stack.push(num);
            }
            
        }
        
        return stack.pop();
        
    }
}