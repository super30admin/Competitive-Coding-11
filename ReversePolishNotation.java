/*
Space: O(S) for stack
Time: O(S) 
Approach:
========
1. Store operators in set
2. For every string in tokens, check if its a number, if so, simply push to stack
3. If operator, pop two numbers, do operation, push result to stack
4. Final result would be what is still left in stack
*/
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0; 
        // Add operators to set
        Set<String> set = new HashSet<>(); 
        set.add("+"); 
        set.add("-"); 
        set.add("*"); 
        set.add("/");
        
        Stack<Integer> stack = new Stack<>(); 

        for(String ch: tokens) {
            int temp = 0; 
            // if number, just add to stack
            if(!set.contains(ch)) {
                stack.push(Integer.parseInt(ch)); 
            }
            else {
                // If operator, pop last two numbers, do operation and push the result back to stack
                int a = stack.pop(); 
                int b = stack.pop();
                if(ch.equals("+")) {
                    temp = b + a;
                } else if(ch.equals("-")) {
                    temp = b - a;
                } else if(ch.equals("*")) {
                    temp = b * a;
                }
                else {
                    temp = b/a;
                }
                stack.push(temp); 
            }
            
        }
        //Final result would be element left in stack
        return stack.pop();
    }
}