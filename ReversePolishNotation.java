//https://leetcode.com/problems/evaluate-reverse-polish-notation/
/*
Time: O(n) where n = tokens.length
Space: O(n) for Stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int y = stack.pop();
                int x = stack.pop();

                if ("+".equals(token))
                    stack.push(x + y);

                else if ("-".equals(token))
                    stack.push(x - y);

                else if ("*".equals(token))
                    stack.push(x * y);

                else if ("/".equals(token))
                    stack.push(x / y);

            }

            else // number
            {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
