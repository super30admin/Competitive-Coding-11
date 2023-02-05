// Approach: Keep adding numbers in the stack, if operation found, pop last 2 numbers num2 first
// then num1 and perform required operation on them using switch statement and store the result
// back into the stack
// Time: O(n)
// Space: O(n)

import java.util.Stack;

class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();
            int result = 0;

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
            stack.push(result);
        }
        return stack.pop();
    }
}