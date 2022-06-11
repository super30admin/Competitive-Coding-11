import java.util.Stack;

public class ReversePolishNotation {
    // TC : O(n) n - number of tokens
    // SC : O(n)
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;

        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                int answer = evalExpression(operand1, operand2, token);
                stack.push("" + answer);
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private int evalExpression(String operand1, String operand2, String operator) {
        switch (operator) {
            case "-":
                return Integer.parseInt(operand1) - Integer.parseInt(operand2);
            case "*":
                return Integer.parseInt(operand1) * Integer.parseInt(operand2);
            case "/":
                return Integer.parseInt(operand1) / Integer.parseInt(operand2);
            default:
                return Integer.parseInt(operand1) + Integer.parseInt(operand2);
        }
    }
}
