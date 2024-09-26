// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<>();
		int prev;
		for (String token : tokens) {
			switch (token) {

			case "+":
				prev = stack.pop();
				stack.push(stack.pop() + prev);
				break;
			case "-":
				prev = stack.pop();
				stack.push(stack.pop() - prev);
				break;
			case "*":
				prev = stack.pop();
				stack.push(stack.pop() * prev);
				break;
			case "/":
				prev = stack.pop();
				stack.push(stack.pop() / prev);
				break;
			default:
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}
