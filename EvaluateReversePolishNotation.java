// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (c.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);

            } else if (c.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);

            } else if (c.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b * a);

            } else if (c.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);

            } else
                st.push(Integer.parseInt(c));

        }

        return st.peek();
    }
}