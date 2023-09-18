// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * use a stack to store the previous number, whenever an operand is encountered. Pop the elements and perform the operation.
 * finally return the value.
 */

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;

        for(int i=0; i<n; i++){
            String currStr = tokens[i];
            if(currStr.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            }else if(currStr.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }else if(currStr.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            }else if(currStr.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else {
                stack.push(Integer.parseInt(currStr));
            }
        }

        return stack.peek();
    }
}