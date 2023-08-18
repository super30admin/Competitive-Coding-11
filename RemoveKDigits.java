import java.util.Stack;
//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * use a stack to push chars to the stack. when a char is less than the peek of
 * stack, pop the peek and reduce k. and then push the current char to the
 * stack. Then check if k is 0, if not remove k chars and push the chars to the
 * string. While doing iterate from 1st element. Initially take leading zero as
 * true and check if any leading zeros are present. once a non zero is reached,
 * make it false and push that number to the string and return the result.
 *
 */
class Solution {
	public String removeKdigits(String num, int k) {
		if (num == null || num.equals(""))
			return num;
		Stack<Character> stack = new Stack<>();
		for (char c : num.toCharArray()) {
			while (!stack.isEmpty() && k > 0 && (int) (stack.peek()) > (int) c) {
				stack.pop();
				k--;
			}
			stack.push(c);
		}
		for (int i = 0; i < k; i++)
			stack.pop();
		StringBuilder sb = new StringBuilder();
		boolean lead = true;
		for (char c : stack) {
			if (c == '0' && lead)
				continue;
			lead = false;
			sb.append(c);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}