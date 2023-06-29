// TC - O(n)
// SC - O(n) - for the stack

/*
 * Approach:
 * We use a stack to perform all our operations one-by-one as and when we
 * encounter an operator.
 * The answer will be present in the end as the last and top element of the
 * stack.
 */

import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return -1;
        }

        if(tokens.length == 1) { // single operand
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> s = new Stack<>();

        for(int i=0; i<tokens.length; i++) {
            String t = tokens[i];
            int op1, op2;
            switch(t) {
                case "+":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 + op2);
                    break;
                case "-":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 - op2);
                    break;
                case "*":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 * op2);
                    break;
                case "/":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 / op2);
                    break;
                default:
                    s.push(Integer.parseInt(t));
            }
        }

        return s.pop();
    }
}