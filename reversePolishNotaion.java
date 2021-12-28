// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int elem2 = stack.pop();
                int elem1 = stack.pop();
                
                if (token.equals("+")) {
                    stack.push(elem1 + elem2);
                }
                else if (token.equals("-")) {
                    stack.push(elem1 - elem2);
                }
                else if (token.equals("*")) {
                    stack.push(elem1 * elem2);
                }
                else if (token.equals("/")) {
                    stack.push(elem1 / elem2);
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}