import java.util.Stack;
//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * use a stack to push the integers. Whenever an operator is found, pop the top
 * 2 elements and perform the operation and push it to the stack. Once all
 * tokens are iterated, add the left over elements from the stack to return the
 * result.
 *
 */
class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (String s : tokens) {
			if (s.equals("+") && stack.size() >= 2) {
				int x = stack.pop();
				int y = stack.pop();
				int ans = y + x;
				stack.push(ans);
			} else if (s.equals("-") && stack.size() >= 2) {
				int x = stack.pop();
				int y = stack.pop();
				int ans = y - x;
				stack.push(ans);
			} else if (s.equals("*") && stack.size() >= 2) {
				int x = stack.pop();
				int y = stack.pop();
				int ans = y * x;
				stack.push(ans);
			} else if (s.equals("/") && stack.size() >= 2) {
				int x = stack.pop();
				int y = stack.pop();
				int ans = y / x;
				stack.push(ans);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		while (!stack.isEmpty())
			res += stack.pop();
		return res;
	}
}