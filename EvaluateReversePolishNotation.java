// Time Complexity : O(n) n -> no of tokens
// Space Complexity : O(n) stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: 
// Whenever a number is encountered, it needs to be converted to integer and pushed into stack.
// Whenever an operator is encountered, the last two numbers in stack are popped, operation is performed and the result of this operation is pushed into stack.
// We need to be mindful of the order in which the operation is being performed especially in case of subtraction and division.

class Solution {
    public int evalRPN(String[] tokens) {
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(String str : tokens) {
            if(str.equals("-")) {
                num = -1 * stack.pop() + stack.pop();
                stack.push(num);
            }
            else if(str.equals("+")) {
                num = stack.pop() + stack.pop();
                stack.push(num);
            }
            else if(str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                num = b/a;
                stack.push(num);
            }
            else if(str.equals("*")) {
                num = stack.pop() * stack.pop();
                stack.push(num);
            }
            else {
                num = Integer.parseInt(str);
                stack.push(num);
            }
        }
        
        return stack.pop();
    }
}

