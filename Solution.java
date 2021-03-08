package cc11;
import java.util.Stack;
//Time complexity: O(N)
//Space Complexity: O(N)

public class Solution {
	public int evalRPN(String[] tokens) {
		if(tokens.length == 0 || tokens == null)return 0;
		int a;
		int b;
		Stack<Integer> st = new Stack<>();
		
		for(String token : tokens) {
			if(token.equals("+")) {
				a = st.pop();
				b = st.pop();
				st.push(a+b);
			}
			else if(token.equals("-")) {
				b = st.pop();
				a = st.pop();
				st.push(a-b);
			}
			else if(token.equals("*")) {
				a = st.pop();
				b = st.pop();
				st.push(a*b);
			}
			else if(token.equals("/")) {
				b = st.pop();
				a = st.pop();
				st.push((int)a/b);
			}
			else {
				st.push(Integer.parseInt(token));
			}
		}
		return st.pop();
	}
	public static void main(String[] args) {
		String[]  ss = {"4","13","5","/","+"};
		String[] ss1 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		Solution sp = new Solution();
		System.out.println(sp.evalRPN(ss1));
	}
}
