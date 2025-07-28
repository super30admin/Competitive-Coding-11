/*
Approach - when there are numbers(operands) keep updating to stack and if operator come
           then pop two elements and do the arithmatic operation based on operands,
           also keep pushing new results to the stack so it will act as number among two numbers which are required to do
           arithmetic operation for upcoming one.
Time Complexity - O(N)
Space Complexity - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
import java.util.Stack;

public class EvaluateReversePolishNotation_LC_150 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") &&
                    !token.equals("*") && !token.equals("/")) {
                st.push(Integer.parseInt(token));
            } else {
                int result = 0;
                int b = st.pop();
                int a = st.pop();
                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break;
                }
                st.push(result);  // needed to allow chained operations
            }
        }

        return st.pop();
    }
}

