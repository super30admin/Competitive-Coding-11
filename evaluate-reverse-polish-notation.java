// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After interview solution


// Your code here along with comments explaining your approach
//The approach is to push elements onto the stack whenever it is not equal to "+-/*".
//Whenevr we encounter a operand, then we pop 2 elements from the stack. We keep the second element as first, thent he first element.
//We perform the required operation, then we put the result back to the stack.

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> s = new Stack<>();
        
        int n = tokens.length;
        
        
        for(String token: tokens){
            
            //check is the token contains something other than operand
            if(!"+-/*".contains(token)){
                s.push(Integer.valueOf(token));
                continue;
            }
            	//pop the first element into number2 due to odering. Ordering matters in division.
                int number2 = s.pop();
                //pop the second into number 1
                int number1 = s.pop();

            int result = 0;
            //perform the required operation
            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
            
            //push result back onto stack
            s.push(result);           
        }
        
        return s.pop();
    }
}
