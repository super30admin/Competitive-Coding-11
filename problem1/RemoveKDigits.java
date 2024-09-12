// Time Complexity : O(n), n -> Number of characters in the string
// Space Complexity : O((n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.LinkedList;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (num == null || num.length() == 0 || k == num.length()) {
			return "0";
		}

		LinkedList<Character> list = new LinkedList<Character>();

		for (char ch : num.toCharArray()) {
			while (!list.isEmpty() && k > 0 && list.peekLast() > ch) {
				list.removeLast();
				k--;
			}

			list.add(ch);
		}

		for (int i = 0; i < k; i++) {
			list.removeLast();
		}

		StringBuilder sb = new StringBuilder();

		while (!list.isEmpty() && list.peekFirst() == '0') {
			list.pollFirst();
		}

		if (list.isEmpty()) {
			return "0";
		}

		while (!list.isEmpty()) {
			sb.append(list.pollFirst());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		RemoveKDigits obj = new RemoveKDigits();
		String s = "1432219";
		int k = 2;
		System.out.println("Smallest Number: " + obj.removeKdigits(s, k));
	}

}
