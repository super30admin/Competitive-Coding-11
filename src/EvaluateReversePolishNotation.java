import java.util.Stack;

/*
 *  The Time complexity of the algorithm is O(n)) where n is no of elements in array.
 *  Space complexity of the algorithm is O(n) .
 */

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {

		if (tokens.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();

		for (String input : tokens) {

			if (input.equals("+")) {
				int result = 0;
				int first = stack.pop();
				int second = stack.pop();

				result = first + second;
				stack.push(result);

			} else if (input.equals("-")) {
				int result = 0;
				int first = stack.pop();
				int second = stack.pop();

				result = (second - first);
				stack.push(result);

			} else if (input.equals("*")) {
				int result = 0;
				int first = stack.pop();
				int second = stack.pop();

				result = first * second;
				stack.push(result);

			} else if (input.equals("/")) {
				int result = 0;
				int first = stack.pop();
				int second = stack.pop();

				result = (second / first);
				stack.push(result);

			} else {

				stack.push(Integer.parseInt(input));

			}

		}

		return stack.pop();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
