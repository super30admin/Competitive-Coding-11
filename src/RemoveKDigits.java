import java.util.Stack;

/*
 *  The Time complexity of the algorithm is O(n)) where n is no of elements in array.
 *  Space complexity of the algorithm is O(n) .
 */

public class RemoveKDigits {

	public String removeKdigits(String num, int k) {

		int len = num.length();

		if (len == k)
			return "0";

		Stack<Character> stack = new Stack<>();

		int i = 0;
		while (i < len) {

			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {

				stack.pop();
				k--;

			}

			stack.push(num.charAt(i));
			i++;

		}

		while (k > 0) {

			stack.pop();
			k--;

		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {

			sb.append(stack.pop());

		}

		sb.reverse();

		while (sb.length() > 1 && sb.charAt(0) == '0') {

			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
