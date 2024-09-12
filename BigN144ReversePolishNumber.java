// Time complexity is O(N)
// Space complexity is O(N)
// This solution is submitted on leetcode

import java.util.HashSet;
import java.util.Stack;

public class BigN144ReversePolishNumber {
	class Solution {
		public int evalRPN(String[] tokens) {
			// edge case
			if (tokens == null || tokens.length == 0)
				return 0;
			HashSet<String> set = new HashSet<>();
			set.add("+");
			set.add("-");
			set.add("/");
			set.add("*");
			Stack<Integer> st = new Stack<>();
			for (String s : tokens) {
				if (set.contains(s)) {
					int first = st.pop();
					int second = st.pop();
					if (s.equals("+"))
						st.push(second + first);
					else if (s.equals("-"))
						st.push(second - first);
					else if (s.equals("/"))
						st.push(second / first);
					else if (s.equals("*"))
						st.push(second * first);
				} else
					st.push(Integer.parseInt(s));
			}
			return st.pop();
		}
	}
}