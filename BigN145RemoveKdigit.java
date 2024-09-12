// Time complexity is O(N)
// Space complexity is O(N)
// This solution is submitted on leetcode

import java.util.Stack;

public class BigN145RemoveKdigit {
	class Solution {
		public String removeKdigits(String num, int k) {
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < num.length(); i++) {
				char c = num.charAt(i);
				while (!st.isEmpty() && st.peek() > c && k > 0) {
					st.pop();
					k--;
				}
				st.push(c);
			}

			for (int i = 0; i < k; i++) {
				st.pop();
			}

			char[] result = new char[st.size()];
			for (int i = st.size() - 1; i >= 0; i--) {
				result[i] = st.pop();
			}
			int index = 0;
			while (result.length != 0 && index < result.length && result[index] == '0') {
				index++;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = index; i < result.length; i++) {
				sb.append(result[i]);
			}
			if (sb.length() == 0) {
				return "0";
			}
			return sb.toString();
		}
	}
}