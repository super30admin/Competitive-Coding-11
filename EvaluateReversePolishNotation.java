package CompetitiveCoding11;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /* Created by palak on 8/8/2021 */

    /**
         TC: O(n)
         SC: O(n)
     */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < tokens.length ; i++) {
            String temp = tokens[i];
            if(temp.equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first + second);
            } else if(temp.equals("-")) {
                int first  = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if(temp.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(temp.equals("/")) {
                int first  = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                int num = Integer.parseInt(temp);
                stack.push(num);
            }
        }
        return stack.peek();
    }
}