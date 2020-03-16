package com.recommender;

import java.util.Stack;

/*
Time Complexity: O(N) for Stack Approach
Space Complexity: O(N) for Stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

/**
 * 
 * Stack is most relevant data structure for polish notation problems
 *  The alog working is explained below
 *  	1.) Maintain a stack for storing Numbers or Digit
 *  	2.)	Start iterating the string.let curr_digit be currently processed digit
 *  		a.) Store curr_digit on to stack
 *  		b.) Now compare curr_digit with top of stack.If top of stack is greater than curr_digit,pop out the number.
 *  		c.) Keep removing the top of elemens until a smaller number is found
 *  		d.) Also keep decrementing the counter.When counter reaches 0 i.e we have found smallest number out of given number string
 *  			is and currently stored on stack
 *  		e) Keep removing number from stack and add it to output string
 *  	3.) Keep repeating until stack is empty or all characters are processed
 * */

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (num == null || "".equals(num) || num.length() == 0)
			return "";
		StringBuffer out = new StringBuffer();
		Stack<Integer> stack = new Stack<>();

		int size = num.length();
		for (int i = 0; i < size; i++) {
			int ch = num.charAt(i) - '0';
			while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
				k--;
				stack.pop();
			}
			stack.push(ch);
			System.out.println(stack);
		}
		System.out.println(stack);

		for (int i = 0; i < k; i++) {
			stack.pop();
		}
		System.out.println(stack);

		boolean leadingZero = true;
		for (int n : stack) {
			if (leadingZero && n == 0) {
				continue;
			}
			leadingZero = false;
			out.append(n);
		}
		return out.toString().length() == 0 ? "0" : out.toString();
	}

	public static void main(String args[]) {
		String num = "10200";
		int k = 1;
		System.out.println(new RemoveKDigits().removeKdigits(num, k));
	}
}
