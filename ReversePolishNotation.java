import java.util.Stack;

public class ReversePolishNotation {
    // TC : O(n) n - number of tokens
    // SC : O(n)
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int answer = evalExpression(operand1, operand2, token);
                stack.push(answer);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int evalExpression(int operand1, int operand2, String operator) {
        switch (operator) {
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                return operand1 + operand2;
        }
    }
}
