// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//if integer add in stack, if operator do operation on last two integers and add in stack. at last return the result
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        // traverse input
        for (String token : tokens) {
            // System.out.println(st);
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = st.pop();
                int b = st.pop();

                if (token.equals("+")) {
                    st.push(a + b);
                } else if (token.equals("-")) {
                    st.push(b - a);
                } else if (token.equals("*")) {
                    st.push(a * b);
                } else if (token.equals("/")) {
                    st.push(b / a);
                }
            } else {
                int i = Integer.parseInt(token);
                st.push(i);
            }

        }

        return st.pop();
    }
}