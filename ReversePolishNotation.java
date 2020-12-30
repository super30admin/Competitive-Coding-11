import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {

		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<String> st = new Stack<>();

		for (String str : tokens) {
			if (str.equals("+")) {
				String v1 = st.pop();
				String v2 = st.pop();
				st.push("" + (Integer.parseInt(v1) + Integer.parseInt(v2)));

			}

			else if (str.equals("-")) {

				String v1 = st.pop();
				String v2 = st.pop();
				st.push("" + (Integer.parseInt(v2) - Integer.parseInt(v1)));
			}

			else if (str.equals("*")) {

				String v1 = st.pop();
				String v2 = st.pop();
				int val = Integer.parseInt(v2) * Integer.parseInt(v1);
				st.push("" + (val));
			} else if (str.equals("/")) {

				String v1 = st.pop();
				String v2 = st.pop();
				st.push("" + (Integer.parseInt(v2) / Integer.parseInt(v1)));
			} else {
				// int val = Integer.parseInt(str);
				st.push(str);
			}
		}
		return Integer.parseInt(st.pop());
	}
}
