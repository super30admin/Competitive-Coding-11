import java.util.Stack;
/*
Evaluate Reverse Polish Notation
approach: use stack
time: O(2n)
space: O(n)
 */
public class Problem2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<tokens.length;i++) {
            String token = tokens[i];

            if (token.equals("+")) {
                st.push(st.pop()+st.pop());
            } else if (token.equals("-")) {
                int a = st.pop(), b = st.pop();
                st.push(b-a);
            } else if (token.equals("*")) {
                st.push(st.pop()*st.pop());
            } else if (token.equals("/")) {
                int a = st.pop(), b = st.pop();
                st.push(b/a);
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.evalRPN(new String[]{"3","2","+","2","*"});
    }
}
