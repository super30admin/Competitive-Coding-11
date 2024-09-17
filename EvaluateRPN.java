// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// if int push to stack, else if operator pop last two elements, perform operation and push back onto stack

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(int i=0; i<tokens.length; i++){
            if(!set.contains(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                
                switch(tokens[i]){                        
                    case "+": 
                        stack.push(num1+num2);
                        break;
                        
                    case "-": 
                        stack.push(num1-num2);
                        break;
                    
                    case "*": 
                        stack.push(num1*num2);
                        break;
                    
                    case "/": 
                        stack.push(num1/num2);
                        break;    
                }
            }
        }
        
        return stack.pop();
    }
}