// Time Complexity : O(n) because each token is processed exactly once
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a stack to evaluate the Reverse Polish Notation expression.
// Numbers are pushed onto the stack, while operators pop the top two operands, perform the operation, and push the result back.
// After processing all tokens, the remaining value on the stack is the final answer.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {

            // process operator
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                if(token.equals("+")) {
                    stack.push(a + b);
                } else if(token.equals("-")) {
                    stack.push(a - b);
                } else if(token.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }
            }

            // process operand
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
