// Time Complexity :O(n), length of string num
// Space Complexity : O(n), size of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

public class Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<>();
		for(String s: tokens){
			if("+-*/".contains(s)){
				int y = st.pop();
				int x = st.pop();
				if(s.equals("+"))
					st.push(x + y);
				else if(s.equals("-"))
					st.push(x - y);
				else if(s.equals("*"))
					st.push(x * y);
				else if(s.equals("/"))
					st.push(x / y);
			}
			else{
				// string is a number
				st.push(Integer.parseInt(s));
			}
		}
		return st.pop();
	}
}
