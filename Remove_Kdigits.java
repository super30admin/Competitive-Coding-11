//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.*;

class Solution {
	public String removeKdigits(String num, int k) {
		int size = num.length();
		if (k == size)
			return "0";
		Stack<Character> stack = new Stack<>();
		int count = 0;
		while (count < size) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(count)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(count));
			count++;
		}
		while (k > 0) {
			stack.pop();
			k--;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			char curr = stack.pop();
			sb.append(curr);
		}
		sb.reverse();
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
}