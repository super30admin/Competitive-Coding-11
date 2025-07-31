// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop two operands and perform operation
                int b = stack.pop();
                int a = stack.pop();
                int result = performOperation(a, b, token);
                stack.push(result);
            } else {
                // Push operand onto stack
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/");
    }

    private int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

// Alternative implementation using enhanced switch (Java 14+)
class SolutionEnhanced {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

// Test cases
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: ["2","1","+","3","*"] -> ((2 + 1) * 3) = 9
        String[] tokens1 = { "2", "1", "+", "3", "*" };
        System.out.println("Result 1: " + solution.evalRPN(tokens1)); // Expected: 9

        // Test case 2: ["4","13","5","/","+"] -> (4 + (13 / 5)) = 6
        String[] tokens2 = { "4", "13", "5", "/", "+" };
        System.out.println("Result 2: " + solution.evalRPN(tokens2)); // Expected: 6

        // Test case 3: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        String[] tokens3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println("Result 3: " + solution.evalRPN(tokens3)); // Expected: 22
    }
}

//
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        // Edge cases
        if (k >= num.length()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }

        Stack<Character> stack = new Stack<>();

        // Iterate through each digit
        for (char digit : num.toCharArray()) {
            // Remove digits from stack while:
            // 1. Stack is not empty
            // 2. Current digit is smaller than top of stack
            // 3. We still have digits to remove (k > 0)
            while (!stack.isEmpty() && digit < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If we still have digits to remove, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}

// Alternative implementation using StringBuilder (more efficient)
class SolutionOptimized {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }

        StringBuilder result = new StringBuilder();

        for (char digit : num.toCharArray()) {
            // Remove digits from result while:
            // 1. Result is not empty
            // 2. Current digit is smaller than last digit in result
            // 3. We still have digits to remove
            while (result.length() > 0 && digit < result.charAt(result.length() - 1) && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            result.append(digit);
        }

        // Remove remaining digits from end if needed
        while (k > 0 && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}

// Test cases
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: num = "1432219", k = 3
        // Remove 4, 3, 2 -> "1219"
        System.out.println("Test 1: " + solution.removeKdigits("1432219", 3)); // Expected: "1219"

        // Test case 2: num = "10200", k = 1
        // Remove 1 -> "0200" -> "200"
        System.out.println("Test 2: " + solution.removeKdigits("10200", 1)); // Expected: "200"

        // Test case 3: num = "10", k = 2
        // Remove all digits -> "0"
        System.out.println("Test 3: " + solution.removeKdigits("10", 2)); // Expected: "0"

        // Test case 4: num = "1234567890", k = 9
        // Remove 9 digits -> "0"
        System.out.println("Test 4: " + solution.removeKdigits("1234567890", 9)); // Expected: "0"

        // Test case 5: num = "112", k = 1
        // Remove 1 -> "12"
        System.out.println("Test 5: " + solution.removeKdigits("112", 1)); // Expected: "12"
    }
}
