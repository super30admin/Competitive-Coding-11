// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<>();

		/* 
		   If the token is an operator, perform the operation by
           poping the 2 operands and pushing on the stack

           Otherwise if the token is an operand, 
           just push it on the stack.
		*/

		for (String token: tokens) {
			if ("+-*/".contains(token)) {
				int y = s.pop(); // 2nd operand
				int x = s.pop(); // 1st operand
				if (token.equals("+"))
					s.push(x + y);
				else if (token.equals("-"))
					s.push(x - y);
				else if (token.equals("*"))
					s.push(x * y);
				else if (token.equals("/"))
					s.push(x / y);
			} else {  // token is a number
				s.push(Integer.parseInt(token));
			}
		}

		// the number remaining on the stack, will be the answer
		return s.pop();
	}
}