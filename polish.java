import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String i : tokens) {
            if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                int ans = cal(a, b, i.charAt(0));
                st.push(ans);
            } else {
                st.push(Integer.parseInt(i));
            }
        }
        return st.pop();
    }

    private int cal(int a, int b, char op) {
        if (op == '+')
            return a + b;
        else if (op == '-')
            return a - b;
        else if (op == '*')
            return a * b;
        else
            return a / b;
    }
}