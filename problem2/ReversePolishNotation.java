// Time Complexity : O(n), n -> Length of token
// Space Complexity : O((n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			if (!"+*-/".contains(token)) {
				stack.push(Integer.valueOf(token));
				continue;
			}

			int num2 = stack.pop();
			int num1 = stack.pop();
			int res = 0;

			switch (token) {
			case "+":
				res = num1 + num2;
				break;

			case "-":
				res = num1 - num2;
				break;

			case "*":
				res = num1 * num2;
				break;

			case "/":
				res = num1 / num2;
				break;
			}

			stack.push(res);
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		ReversePolishNotation obj = new ReversePolishNotation();
		String[] tokens = { "2", "1", "+", "3", "*" };

		System.out.println("Output: " + obj.evalRPN(tokens));
	}

}
