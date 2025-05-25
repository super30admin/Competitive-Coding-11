import java.util.Stack;

public class RPN {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (!stack.isEmpty()) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int res = 0;
                    switch (s) {
                        case "+":
                            res = b + a;
                            break;
                        case "-":
                            res = b - a;
                            break;
                        case "*":
                            res = b * a;
                            break;
                        case "/":
                            res = b / a;
                            break;
                    }
                    stack.push(res);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }
}

//TC: O(n), SC: O(n)
